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
        Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Sign-In butonuna tıklanır
        signUpInPage.signInIbrahim.click();

        //Kullanıcı adı girilir vendorvendoring@gmail.com
        //Şifre girilir vendor123.
        //Home page'e gidilir
        signUpInPage.userNameTextBoxIbrahim.sendKeys("vendorvendoring@gmail.com", Keys.TAB, "vendor123.", Keys.ENTER);


        //Search kısmından ürün aratılır Chess
        ReusableMethods.waitForSecond(3);
        String searchProduct = "Vintage Toy Car";
        homePage.searchBoxIbrahim.sendKeys(searchProduct, Keys.ENTER);
        ReusableMethods.waitForSecond(2);

        //doğrulama
        Assert.assertTrue(Driver.getDriver().getTitle().contains(searchProduct));


        //ADD TO CART butonuna tıklayarak ürünü sepete eklenir
        productPage.addToCartIbrahim.click();

        //add to cart ekleme doğrulama
        String actualAddToCartConfirmMessage = productPage.addToCartConfirm.getText();
        String expectedContains ="has been added to your cart.";
        Assert.assertTrue(actualAddToCartConfirmMessage.contains(expectedContains));

        //Cart sembolune tıklanır
        productPage.cartSymolIbrahim.click();

        //Cart display
        String cartDisplayText = productPage.cartDisplay.getText();
        Assert.assertTrue(cartDisplayText.contains(searchProduct));

        //View cart
        productPage.viewCart.click();

        //coupon girilir
        productPage.couponBox.sendKeys("dsc18904",Keys.TAB,Keys.ENTER);

        //coupon ekleme doğrulama
        String couponMessage = productPage.couponAddMessage.getText();
        Assert.assertTrue(couponMessage.contains("dsc18904"));

        //proceed to checkout
        productPage.proceedToCheckOut.click();

        //Wire transfer seçili
        Assert.assertTrue(ordersPage.wireTransfer.isSelected());




    }
}
