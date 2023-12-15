package allovercommerce_com.tests.us06;

import allovercommerce_com.pages.CartPage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ShoppingPage;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 {
    @Test
    public void test01() {

        HomePage homePage = new HomePage();
        Actions actions = new Actions(Driver.getDriver());
        ShoppingPage shoppingPage = new ShoppingPage();
        CartPage cartPage = new CartPage();
        ReusableMethods.extentReportCreate("Salih", "US06-Kullanıcı Siteden Alışveriş Yapabilmeli", "TC02-Sepete Eklenen Ürünlerin Miktarı Artırılabilmeli");


        //1	https://allovercommerce.com Sitesine Git ve Login Ol
        homePage.performLoginSalih();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildi ve Log in Olundu");

        //2	Search Box'tan Ürün Ara
        String aranacakUrun = "pen";
        ReusableMethods.waitForSecond(5);
        homePage.searchBoxST.sendKeys(aranacakUrun, Keys.ENTER);
        ReusableMethods.waitForSecond(5);
        ReusableMethods.extentTestInfo("Ürün Arandı");

        //3	Bulunan Sonuçlardan İstenen Ürün Üzerine Gel ve  Cart  Simgesine Tıkla
        actions.moveToElement(shoppingPage.searchedProductsAddToCartButtonsST.get(1)).perform();
        shoppingPage.searchedProductsAddToCartButtonsST.get(1).click();
        ReusableMethods.extentTestInfo("İstenen Ürün Üzerinde Cart Simgesine Tıklandı");

        //4	Sağ Üst Köşedeki  Cart Butonuna Tıkla
        shoppingPage.cartButtonST.click();
        ReusableMethods.extentTestInfo("Cart Butonuna Tıklandı");

        //5	View Cart Butonuna Tıkla
        shoppingPage.viewCartButtonST.click();
        ReusableMethods.extentTestInfo("View Cart Butonuna Tıklandı");

        //6	Sepetteki Ürün Miktarını Artır
        int firstQuantity = Integer.parseInt(cartPage.quantityTextST.getAttribute("value"));
        cartPage.quantityPlusButtonST.click();
        int lastQuantity = Integer.parseInt(cartPage.quantityTextST.getAttribute("value"));
        ReusableMethods.extentTestInfo("Sepetteki Ürün Miktarı Artırıldı");

        //7	Ürün Miktarının Arttığını Doğrula
        boolean expecdetData = lastQuantity > firstQuantity;
        Assert.assertTrue(expecdetData);
        ReusableMethods.extentTestInfo("Ürün Miktarının Arttığı Doğrulandı");

        ReusableMethods.extentTestPass("Sepete Eklenen Ürünlerin Miktarı Artırılmıştır..");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }
}
