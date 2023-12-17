package allovercommerce_com.tests.us19;

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

public class TC08 {
    OrdersPage ordersPage = new OrdersPage();
    ProductPage productPage = new ProductPage();
    SignUpInPage signUpInPage = new SignUpInPage();
    HomePage homePage = new HomePage();
    @Test
    public void testCustomerButWithCoupon() {

        ReusableMethods.extentReportCreate("Ibrahim",
                "US_19 || Oluşturulan Coupon ile müşteri olarak alışveriş yapılabilmeli",
                "TC_08 || Kullanıcı ödeme seçeneklerini seçebilmeli");

        Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen siteye gidildi.");

        //Sign-In butonuna tıklanır
        signUpInPage.signInIbrahim.click();

        //Kullanıcı adı girilir
        //Şifre girilir
        //Home page'e gidilir
        String customerEmail = ConfigReader.getProperty("musteriEmail");
        String customerPassword = ConfigReader.getProperty("musteriPassword");
        signUpInPage.userNameTextBoxIbrahim.sendKeys(customerEmail, Keys.TAB, customerPassword, Keys.ENTER);
        ReusableMethods.extentTestInfo("Müsteri hesabına giris yapildi");


        //Search kısmından ürün aratılır
        ReusableMethods.waitForSecond(3);
        String searchProduct = "Vintage Toy Car";
        homePage.searchBoxIbrahim.sendKeys(searchProduct, Keys.ENTER);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.extentTestInfo("Ürün aratildi");

        //doğrulama
        Assert.assertTrue(Driver.getDriver().getTitle().contains(searchProduct));
        ReusableMethods.extentTestPass("Sonuc sayfasinin ürünü icerdigi dogrulandi.");


        //ADD TO CART butonuna tıklayarak ürünü sepete eklenir
        productPage.addToCartIbrahim.click();
        ReusableMethods.extentTestInfo("Ürün sepete eklendi.");

        //add to cart ekleme doğrulama
        String actualAddToCartConfirmMessage = productPage.addToCartConfirm.getText();
        String expectedContains ="has been added to your cart.";
        Assert.assertTrue(actualAddToCartConfirmMessage.contains(expectedContains));
        ReusableMethods.extentTestPass("Ürünün eklendiği dogrulandi.");

        //Cart sembolune tıklanır
        productPage.cartSymolIbrahim.click();

        //Cart display
        String cartDisplayText = productPage.cartDisplay.getText();
        Assert.assertTrue(cartDisplayText.contains(searchProduct));
        ReusableMethods.extentTestInfo("Ürünün cart display de görüntülendigi dogrulandi.");

        //View cart
        productPage.viewCart.click();

        //coupon girilir
        productPage.couponBox.sendKeys("dsc18904",Keys.TAB,Keys.ENTER);
        ReusableMethods.extentTestInfo("Kupon girildi.");

        //coupon ekleme doğrulama
        String couponMessage = productPage.couponAddMessage.getText();
        Assert.assertTrue(couponMessage.contains("dsc18904"));
        ReusableMethods.extentTestPass("Kupon eklendigi dogrulandi.");

        //proceed to checkout
        productPage.proceedToCheckOut.click();

        //Wire transfer seçili
        Assert.assertTrue(ordersPage.wireTransfer.isSelected());
        ReusableMethods.extentTestInfo("Odeme yöntemi secildi.");



        ReusableMethods.extentReportFlush();
        ReusableMethods.waitForSecond(5);
        ReusableMethods.jsClick(signUpInPage.signOutIbrahim);
        ReusableMethods.jsClick(signUpInPage.signOutConfirm);
        ReusableMethods.waitForSecond(5);


    }
}
