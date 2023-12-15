package allovercommerce_com.tests.us01;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 {
    @Test
    public void test15() {
        ReusableMethods.extentReportCreate("U1T15 Selma", "US01","TC15");

        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        // Register butonuna tiklanir
        HomePage homePage = new HomePage();
        homePage.registerButtonSS.click();

        // Username kutusuna bir veri girilir
        Faker faker = new Faker();
        SignUpInPage signUpInPage = new SignUpInPage();
        signUpInPage.signUpUsernameTextBoxSS.sendKeys (faker.name().username());

        // Your Email address kutusuna gecerli bir veri girilir. abc@gmail.com formatinda
        signUpInPage.signUpEmailTextBoxSS.sendKeys(faker.internet().emailAddress());

        // Password kutusuna gecerli bir veri girilir
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(faker.internet().password());

        // I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        // Sign Up butonunun tiklanabilir oldugu dogrulanir
        Assert.assertTrue(signUpInPage.signUpOnayButtonSS.isEnabled());

        ReusableMethods.extentTestPass("Sign Up butonunun tiklanabilir oldugu dogrulandi. ");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();
    }
}
