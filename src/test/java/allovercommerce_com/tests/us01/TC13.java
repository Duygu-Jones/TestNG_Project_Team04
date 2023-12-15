package allovercommerce_com.tests.us01;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13 {
    @Test
    public void test13() {
        ReusableMethods.extentReportCreate("U1T13 Selma", "US01","TC13");

        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        // Register butonuna tiklanir
        HomePage homePage = new HomePage();
        homePage.registerButtonSS.click();

        // Username kutusuna bir veri girilir
        Faker faker = new Faker();
        SignUpInPage signUpInPage = new SignUpInPage();
        signUpInPage.signUpUsernameTextBoxSS.sendKeys (faker.name().username());

        // Your Email address kutusuna bir veri girilir.
        signUpInPage.signUpEmailTextBoxSS.sendKeys(faker.internet().emailAddress());

        // Password kutusuna bir veri girilir
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(faker.internet().password());

        // I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        // Sign Up butonuna tiklanir
        signUpInPage.signUpOnayButtonSS.click();

        // Kayit isleminin gerceklestigi dogrulanir
        Assert.assertTrue(homePage.signUpButtonSS.isDisplayed());

        ReusableMethods.extentTestPass("I agree kutusu tiklanarak kayit isleminin gerceklestigi dogrulandi. ");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();
    }
}
