package allovercommerce_com.tests.us01;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;

public class TC01 {
    @Test
    public void test01() {
        ReusableMethods.extentReportCreate("U1T1 Selma", "US01","TC01");

        // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        // Register butonuna tiklanir
        HomePage homePage = new HomePage();
        homePage.registerButtonSS.click();

        // Username kutusuna  bir veri girilir
        // (kücük harf, büyük harf, rakam ve özel karakter iceren username)
        Faker faker = new Faker();
        SignUpInPage signUpInPage = new SignUpInPage();
        signUpInPage.signUpUsernameTextBoxSS.sendKeys (faker.name().username().getBytes(StandardCharsets.UTF_8).toString());
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].style.border='5px solid red'",signUpInPage.signUpUsernameTextBoxSS);

        // Your Email address kutusuna gecerli bir veri girilir
        signUpInPage.signUpEmailTextBoxSS.sendKeys(faker.internet().emailAddress());

        // Password kutusuna gecerli bir veri girilir
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(faker.internet().password());

        // I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        // Sign Up butonuna tiklanir
        signUpInPage.signUpOnayButtonSS.click();


        // Kayit isleminin gerceklestigi dogrulanir
        String expextedText = "Please enter a valid account username.";
        String actualText = signUpInPage.invalidUsernameTextSS.getText();
        System.out.println("actualText = " + actualText);
        Assert.assertTrue(actualText.contains(expextedText));

        js.executeScript("arguments[0].style.border='5px solid red'",signUpInPage.invalidUsernameTextSS);
        ReusableMethods.screenShot("invalid Username", "U1T1 selma");

        ReusableMethods.extentTestFail("Kücük harf, büyük harf, rakam ve özel karakter iceren Username ile kayit gerceklesmedi. Test Fail oldu");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();
    }
}
