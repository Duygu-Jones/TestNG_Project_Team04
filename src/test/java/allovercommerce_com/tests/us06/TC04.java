package allovercommerce_com.tests.us06;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ShoppingPage;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC04 {

    @Test
    public void test01() {
        HomePage homePage=new HomePage();
        ShoppingPage shoppingPage=new ShoppingPage();
        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.extentReportCreate("Salih", "US06-Kullanıcı Siteden Alışveriş Yapabilmeli", "TC04-Kullanıcı ürünleri satın alabilmek için fatura adresini görebilmelidir.");

        //1	Web sitesine git ve Log in ol
        homePage.performLoginSalih();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildi ve Log in Olundu");

        //2	Ürün Ara
        String aranacakUrun = "pen";
        ReusableMethods.waitForSecond(7);
        homePage.searchBoxST.sendKeys(aranacakUrun, Keys.ENTER);
        ReusableMethods.waitForSecond(5);
        ReusableMethods.extentTestInfo("Ürün Arandı");

        //3 Bulunan sonuçlardan istenen ürün üzerine gel ve sepete (Cart) tıkla
        List<WebElement> urunListesi = Driver.getDriver().findElements(By.xpath("//li[@class='product-wrap']"));

        if (urunListesi.size() >= 2) {
            WebElement ikinciUrun = urunListesi.get(1);
            actions.moveToElement(ikinciUrun).perform();
        } else {
            System.out.println("Listede en az iki ürün bulunmalıdır.");
            return; // Eğer yeterli ürün yoksa testi burada sonlandır
        }
        shoppingPage.addToCartButtonST.click();
        ReusableMethods.extentTestInfo("İstenen Ürün Üzerinde Sepete Tıklandı");

        //4	Sağ Üst Köşedeki Sepete (Cart) Tıkla
        shoppingPage.cartButtonST.click();
        ReusableMethods.extentTestInfo("Sepete Tıklandı");

        //5 "View Cart" Butonuna Tıkla
        shoppingPage.viewCartButtonST.click();
        ReusableMethods.extentTestInfo("View Cart Butonuna Tıklandı");

        //6	Fartura adresinin göründüğünü doğrula
        Assert.assertTrue(shoppingPage.shippingText.isDisplayed());
        ReusableMethods.extentTestInfo("Fatura Adresinin Görüldüğü Doğrulandı");

        ReusableMethods.extentTestPass("Fatura Adresi Görülmüştür.");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }
}
