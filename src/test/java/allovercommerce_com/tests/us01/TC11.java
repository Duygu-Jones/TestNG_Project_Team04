package allovercommerce_com.tests.us01;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;

public class TC11 {
    @Test
    public void test11() {
        ReusableMethods.extentReportCreate("U1T11 Selma", "US01","TC11");

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
        String password = faker.internet().password().getBytes(StandardCharsets.UTF_8).toString().substring(0,8);
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(password);
        System.out.println("password = " + password);

        // I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        // Sign Up butonuna tiklanir
        signUpInPage.signUpOnayButtonSS.click();

        // Kayit isleminin gerceklestigi dogrulanir
        Assert.assertTrue(homePage.signUpButtonSS.isDisplayed());

        ReusableMethods.extentTestPass("8 karakter uzunlugunda Password girilerek kayit isleminin gerceklestirildigi dogrulandi.");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();
    }
}
