package allovercommerce_com.tests.us17;

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

public class TC04 {
    SignUpInPage signUpInPage = new SignUpInPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    OrdersPage ordersPage = new OrdersPage();
    @Test
    public void testVendorBuy() {

        ReusableMethods.extentReportCreate("Ibrahim",
                "US_17 || Vendor olarak alışveriş yapabilmeliyim.",
                "TC_04 || Kullanıcı billing detailste isim bilgisini yazmadan alışveriş tamamlanmamalı");

            Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir
            Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen siteye gidildi.");

        //Sign-In butonuna tıklanır
        ReusableMethods.waitForSecond(3);
        ReusableMethods.jsClick(signUpInPage.signInIbrahim);


        //Kullanıcı adı girilir
        //Şifre girilir
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
        productPage.addToCartIbrahim.click();

        //Cart sembolune tıklanır
        productPage.cartSymolIbrahim.click();

        //CHECKOUT butonuna tıklanır
        productPage.checkOutButtonIbrahim.click();

        //Sepete eklenen ürünün checkout sayfasındaki görünümü doğrulanır
        Assert.assertTrue(productPage.productListIbrahim.getText().contains("Vintage Toy Car"));
        ReusableMethods.extentTestPass("Urun goruntulenme dogrulandı");

        //müsteri bilgileri otomatik gelir
        //firstname bos bırakılır.
        ReusableMethods.deleteAll(ordersPage.customerFirstNameIbrahim);

        //Toplam tutar bilgisinin checkout sayfasındaki görünümü doğrulanır
        Assert.assertTrue(productPage.totalAmountIbrahim.isDisplayed());

        //Place order butonuna tıklanır
        ReusableMethods.waitForSecond(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ordersPage.placeOrderIbrahim.click();

        //"Kullanıcı  "BILLING FIRST NAME is a required field." mesajının görüldüğü onaylanır.
        ReusableMethods.waitForSecond(6);
        String actualErrorMessage = ordersPage.billingFirstNameMessage.getText();
        String expectedErrorMessage = "BILLING FIRST NAME is a required field.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        ReusableMethods.extentTestPass("Siparisin tamamlanmadigi onaylandı");

        ReusableMethods.extentReportFlush();
        ReusableMethods.waitForSecond(5);
        ReusableMethods.jsClick(signUpInPage.signOutIbrahim);
        ReusableMethods.jsClick(signUpInPage.signOutConfirm);
        ReusableMethods.waitForSecond(5);
     //   Driver.closeDriver();







    }
}
