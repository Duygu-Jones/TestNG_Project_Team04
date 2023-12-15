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

public class TC01 {

    @Test
    public void test01() {

        HomePage homePage=new HomePage();
        Actions actions=new Actions(Driver.getDriver());
        ShoppingPage shoppingPage=new ShoppingPage();
        CartPage cartPage=new CartPage();
        ReusableMethods.extentReportCreate("Salih","US06- Kullanıcı Siteden Alışveriş Yapabilmeli","TC01-Kullanıcı Siteden Alışveriş Yapabilmeli");


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
        actions.moveToElement(shoppingPage.searchedProductsAddToCartButtonsST.get(0)).perform();
        shoppingPage.searchedProductsAddToCartButtonsST.get(0).click();
        ReusableMethods.extentTestInfo("İstenen Ürün Üzerinde Sepete Tıklandı");

        //4	Sağ Üst Köşedeki  Cart Butonuna Tıkla
        shoppingPage.cartButtonST.click();
        ReusableMethods.extentTestInfo("Cart Butonuna Tıklandı");

        //5	Checkout Butonuna Tıkla
        shoppingPage.checkoutButtonST.click();
        ReusableMethods.extentTestInfo("Checkout Butonuna Tıklandı");

        //6	Payment Methods Kısmından Ödeme Seçeneğini Seç
        ReusableMethods.waitForSecond(1);
        cartPage.payAtTheDoorRadioButtonST.sendKeys(Keys.ENTER);
        ReusableMethods.extentTestInfo("Payment Methods Kısmından Ödeme Seçeneği (Pay at the door) Seçildi");

        //7	Place Order Butonuna Tıkla
        ReusableMethods.waitForSecond(3);
        cartPage.placeOrderButtonST.sendKeys(Keys.ENTER);
        ReusableMethods.extentTestInfo("Place Order Butonuna Tıklandı");

        //8	Thank you. Your order has been received. Yazısının Görünür Olduğunu Doğrula
        Assert.assertTrue(cartPage.thankYouYourOrderHasBeenReceivedTextST.getText().contains("Thank you. Your order has been received."));
        ReusableMethods.extentTestInfo("'Thank you. Your order has been received.' Yazısının Görünür Olduğunu Doğrulandı");

        ReusableMethods.extentTestPass("Kullanıcı Siteden Alışveriş Yapabilmiştir.");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();



    }

}
