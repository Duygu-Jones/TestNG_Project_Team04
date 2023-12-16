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

public class TC02 {
    SignUpInPage signUpInPage = new SignUpInPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();

    OrdersPage ordersPage = new OrdersPage();
    @Test
    public void testVendorBuy() {

        ReusableMethods.extentReportCreate("Ibrahim",
                "US_17 || Vendor olarak alışveriş yapabilmeliyim.",
                "TC_02 || Kullanıcı (geçerli verilerle) vendor olarak birden fazla ürünü satın alabilmeli (Wire Transfer )");

            Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir
            Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen siteye gidildi.");

        //Sign-In butonuna tıklanır
        signUpInPage.signInIbrahim.click();

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
        productPage.addToCartIbrahim.click();

        //Search kısmından 2. ürün aratılır Chess
        homePage.searchBoxIbrahim.sendKeys("Automatic Crusher", Keys.ENTER);
        ReusableMethods.waitForSecond(2);

        //ADD TO CART butonuna tıklayarak ürünü sepete eklenir
        productPage.addToCartIbrahim.click();

        //Cart sembolune tıklanır
        productPage.cartSymolIbrahim.click();

        //CHECKOUT butonuna tıklanır
        productPage.checkOutButtonIbrahim.click();

        //Sepete eklenen ürünlerin checkout sayfasındaki görünümü doğrulanır
        Assert.assertTrue(productPage.firstProduct.getText().contains("Vintage Toy Car"));
        Assert.assertTrue(productPage.secondProduct.getText().contains("Automatic Crusher"));
        ReusableMethods.extentTestPass("Urunlerin goruntulenme dogrulandı");

        //müsteri bilgileri otomatik gelir

        //Toplam tutar bilgisinin checkout sayfasındaki görünümü doğrulanır
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(productPage.totalAmountIbrahim.isDisplayed());

        //Place order butonuna tıklanır
        ReusableMethods.waitForSecond(3);
        ReusableMethods.jsClick(ordersPage.placeOrderIbrahim);
        

        //"Kullanıcı  ""Thank you. Your order has been received."" mesajının görüldüğü onaylanır.
        ReusableMethods.waitForSecond(6);
        String actualConfirmMessage = ordersPage.orderConfirmMessage.getText();
        String expectedConfirmMessage = "Thank you. Your order has been received.";
        Assert.assertEquals(actualConfirmMessage,expectedConfirmMessage);
        ReusableMethods.extentTestPass("Siparis tamamlandi.");

        //Sayfanın en altında bulunan MY ACCOUNT kısmına gelir
        actions.sendKeys(Keys.END).perform();

        //My Orders butonuna tıklanır
        ReusableMethods.waitForSecond(3);
        ordersPage.myOrdersButton.click();

        //VIEW butonuna tıklanır WebElement view = Driver.getDriver().
        ordersPage.orderView.click();

        //Alışveriş ayrıntılarının görüntülendiği doğrulanır
        Assert.assertTrue(ordersPage.orderDetails.isDisplayed());
        ReusableMethods.extentTestPass("Alisveris ayrintileri goruntulendi");

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();





















    }
}
