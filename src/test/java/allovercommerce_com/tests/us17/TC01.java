package allovercommerce_com.tests.us17;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {
    SignUpInPage signUpInPage = new SignUpInPage();
    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    @Test
    public void testVendorBuy() {
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

        //CHECKOUT butonuna tıklanır
        productPage.checkOutButtonIbrahim.click();

        //Sepete eklenen ürünün checkout sayfasındaki görünümü doğrulanır
        Assert.assertTrue(productPage.productListIbrahim.getText().contains("Vintage Toy Car"));





















import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC01 {
    @Test
    public void testVendorBuy() {
            Actions actions = new Actions(Driver.getDriver());
            Driver.getDriver().get(ConfigReader.getProperty("URL"));


    }
}
