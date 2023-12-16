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

public class TC01 {
    SignUpInPage signUpInPage = new SignUpInPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    OrdersPage ordersPage = new OrdersPage();
    @Test
    public void testVendorButWithCoupon() {

        Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Sign-In butonuna tıklanır
        signUpInPage.signInIbrahim.click();

        //Kullanıcı adı girilir vendorvendoring@gmail.com
        //Şifre girilir vendor123.
        //Home page'e gidilir
        signUpInPage.userNameTextBoxIbrahim.sendKeys("vendorvendoring@gmail.com", Keys.TAB, "vendor123.", Keys.ENTER);

        //Home page de olunduğu doğrulanır
        String expectedTitle = "Allover Commerce";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        ReusableMethods.waitForSecond(2);

        //Search kısmından ürün aratılır Chess
        homePage.searchBoxIbrahim.sendKeys("Vintage Toy Car", Keys.ENTER);
        ReusableMethods.waitForSecond(2);

        //ADD TO CART butonuna tıklayarak ürünü sepete eklenir
        productPage.addToCartIbrahim.click();

        //Cart sembolune tıklanır
        productPage.cartSymolIbrahim.click();

        //view vart butonuna tıklanır
        productPage.viewCart.click();

        //Sepete eklenen ürünün checkout sayfasındaki görünümü doğrulanır
        Assert.assertTrue(productPage.productListIbrahim.getText().contains("Vintage Toy Car"));



        //Toplam tutar bilgisinin checkout sayfasındaki görünümü doğrulanır
        Assert.assertTrue(productPage.totalAmountIbrahim.isDisplayed());

        //coupon girilir
        productPage.couponBox.sendKeys("dsc18904",Keys.TAB,Keys.ENTER);

        //coupon ekleme doğrulama
        String couponMessage = productPage.couponAddMessage.getText();
        Assert.assertTrue(couponMessage.contains("dsc18904"));

        //proceed to checkout
        productPage.proceedToCheckOut.click();

        //müsteri bilgileri otomatik gelir

        //Place order butonuna tıklanır
        ReusableMethods.waitForSecond(3);
        ordersPage.placeOrderIbrahim.click();

        //"Kullanıcı  ""Thank you. Your order has been received."" mesajının görüldüğü onaylanır.
        ReusableMethods.waitForSecond(6);
        String actualConfirmMessage = ordersPage.orderConfirmMessage.getText();
        String expectedConfirmMessage = "Thank you. Your order has been received.";
        Assert.assertEquals(actualConfirmMessage,expectedConfirmMessage);

        //Sayfanın en altında bulunan MY ACCOUNT kısmına gelir
        actions.sendKeys(Keys.END).perform();

        //My Orders butonuna tıklanır
        ReusableMethods.waitForSecond(3);
        ordersPage.myOrdersButton.click();

        //VIEW butonuna tıklanır WebElement view = Driver.getDriver().
        ordersPage.orderView.click();

        //Alışveriş ayrıntılarının görüntülendiği doğrulanır
        Assert.assertTrue(ordersPage.orderDetails.isDisplayed());



    }
}
