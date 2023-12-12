package allovercommerce_com.tests.us06;

import allovercommerce_com.pages.CartPage;
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

public class TC03 {
    @Test
    public void test01() {

        HomePage homePage = new HomePage();
        Actions actions = new Actions(Driver.getDriver());
        ShoppingPage shoppingPage = new ShoppingPage();
        CartPage cartPage = new CartPage();
        ReusableMethods.extentReportCreate("Salih", "US06-Kullanıcı Siteden Alışveriş Yapabilmeli", "TC03-Sepete eklenen ürünlerin miktarı azaltılabilmeli");


        //1	https://allovercommerce.com Sitesine Git ve Login Ol
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
        actions.click(shoppingPage.addToCartButtonST).perform();
        ReusableMethods.extentTestInfo("İstenen Ürün Üzerinde Sepete Tıklandı");

        //4	Sağ Üst Köşedeki Sepete (Cart) Tıkla
        shoppingPage.cartButtonST.click();
        ReusableMethods.extentTestInfo("Sepete Tıklandı");

        //5 "View Cart" Butonuna Tıkla
        shoppingPage.viewCartButtonST.click();
        ReusableMethods.extentTestInfo("View Cart Butonuna Tıklandı");

        //6	Sepetteki Ürün Miktarını Azalt
        int firstQuantity = Integer.parseInt(shoppingPage.quantity.getAttribute("value"));
        cartPage.quantityMinusButtonST.click();
        cartPage.quantityUpdateButtonST.click();
        int lastQuantity = Integer.parseInt(shoppingPage.quantity.getAttribute("value"));
        ReusableMethods.extentTestInfo("Sepetteki Ürün Miktarı Azaltıldı");

        //7	Ürün Miktarının Azaldığını Doğrula
        boolean expecdetData = lastQuantity < firstQuantity;
        Assert.assertTrue(expecdetData);
        ReusableMethods.extentTestInfo("Ürün Miktarının Azaltıldığı Doğrulandı");


        ReusableMethods.extentTestPass("Sepete Eklenen Ürünlerin Miktarı Azaltılmıştır..");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }
}

