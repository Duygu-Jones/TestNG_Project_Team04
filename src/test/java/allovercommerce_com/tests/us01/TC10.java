package allovercommerce_com.tests.us01;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10 {
    @Test
    public void test10() {
        ReusableMethods.extentReportCreate("U1T10 Selma", "US01","TC10");

        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        // Register butonuna tiklanir
        HomePage homePage = new HomePage();
        homePage.registerButtonSS.click();

        // Username kutusuna bir veri girilir
        Faker faker = new Faker();
        SignUpInPage signUpInPage = new SignUpInPage();
        signUpInPage.signUpUsernameTextBoxSS.sendKeys (faker.name().username());

        // Your Email address kutusu bos birakilir
        signUpInPage.signUpEmailTextBoxSS.sendKeys("");

        // Password kutusuna gecerli bir veri girilir
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(faker.internet().password());

        // I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        // Sign Up butonuna tiklanir
        signUpInPage.signUpOnayButtonSS.click();

        // Kayit isleminin gerceklesmedigi dogrulanir
        Assert.assertTrue(signUpInPage.signUpOnayButtonSS.isDisplayed());

        ReusableMethods.extentTestPass("email bilgisi girilmeden kayit isleminin gerceklesmedigi dogrulandi. ");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();
    }
}
