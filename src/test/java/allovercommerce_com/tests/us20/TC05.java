package allovercommerce_com.tests.us20;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.OrdersPage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 {
    SignUpInPage signUpInPage = new SignUpInPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    OrdersPage ordersPage = new OrdersPage();
    @Test
    public void testVendorBuy() {

        ReusableMethods.extentReportCreate("Ibrahim",
                "US_20 || Oluşturulan Coupon ile Vendor olarak alışveriş yapılabilmeli",
                "TC_05 || Kullanıcı billing detailste Postcode / ZIP bilgisini yazmadan  alışveriş tamamlanmamalı");

        Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen siteye gidildi.");

        //Sign-In butonuna tıklanır
        ReusableMethods.jsClick(signUpInPage.signInIbrahim);

        //Kullanıcı adı girilir vendorvendoring@gmail.com
        //Şifre girilir vendor123.
        //Home page'e gidilir
        String vendorEmail = ConfigReader.getProperty("vendorEmail");
        String vendorPassword = ConfigReader.getProperty("vendorSifre");
        signUpInPage.userNameTextBoxIbrahim.sendKeys(vendorEmail, Keys.TAB, vendorPassword, Keys.ENTER);
        ReusableMethods.extentTestInfo("Vendor hesabına giris yapildi");

        //Home page de olunduğu doğrulanır
        String expectedTitle = "Allover Commerce";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.extentTestPass("Anasayfada olundugu dogrulandı");

        //Search kısmından ürün aratılır Vintage Toy Car
        homePage.searchBoxIbrahim.sendKeys("Vintage Toy Car", Keys.ENTER);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.extentTestInfo("Search kisminda ürün aratildi");

        //ADD TO CART butonuna tıklayarak ürünü sepete eklenir
        ReusableMethods.jsClick(productPage.addToCartIbrahim);


        //Cart sembolune tıklanır
        ReusableMethods.jsClick(productPage.cartSymolIbrahim);

        //CHECKOUT butonuna tıklanır
        ReusableMethods.jsClick(productPage.viewCart);


        //Sepete eklenen ürünün checkout sayfasındaki görünümü doğrulanır
        Assert.assertTrue(productPage.productListIbrahim.getText().contains("Vintage Toy Car"));
        ReusableMethods.extentTestPass("Urun goruntulenme dogrulandı");

        //coupon girilir
        productPage.couponBox.sendKeys("dsc18904",Keys.TAB,Keys.ENTER);
        ReusableMethods.extentTestInfo("Kupon eklendi.");

        //coupon ekleme doğrulama
        String couponMessage = productPage.couponAddMessage.getText();
        Assert.assertTrue(couponMessage.contains("dsc18904"));
        ReusableMethods.extentTestPass("Kuponun eklendigi dogrulandı.");

        //Toplam tutar bilgisinin checkout sayfasındaki görünümü doğrulanır
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(productPage.totalAmountIbrahim.isDisplayed());
        ReusableMethods.extentTestPass("Toplam tutarın goruntulendigi dogrulandi.");

        //müsteri bilgileri otomatik gelir
        //zipcode bos bırakılır.
        ReusableMethods.deleteAll(ordersPage.zipCodeIbrahim);


        //Place order butonuna tıklanır
        ReusableMethods.waitForSecond(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.jsClick(ordersPage.placeOrderIbrahim);


        //"Kullanıcı  "BILLING POSTCODE / ZIP is a required field" mesajının görüldüğü onaylanır.
        ReusableMethods.waitForSecond(6);
        String actualErrorMessage = ordersPage.zipCodeMessageIbrahim.getText();
        String expectedErrorMessage = "BILLING POSTCODE / ZIP is a required field";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        ReusableMethods.extentTestPass("Siparis tamamlanamadi.");

        ReusableMethods.extentReportFlush();
        ReusableMethods.waitForSecond(5);
        ReusableMethods.jsClick(signUpInPage.signOutIbrahim);
        ReusableMethods.jsClick(signUpInPage.signOutConfirm);
        ReusableMethods.waitForSecond(5);





    }
}
