package allovercommerce_com.tests.us02;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {
    @Test
    public void test01() {
        ReusableMethods.extentReportCreate("U2T1 Selma ", "US02","TC01");

        //Web sitesine gidilir	https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Register butonuna tiklanir
        HomePage homePage = new HomePage();
        homePage.registerButtonSS.click();

        //Username kutusuna kayitli bir veri girilir Alice
        SignUpInPage signUpInPage = new SignUpInPage();
        signUpInPage.signUpUsernameTextBoxSS.sendKeys(ConfigReader.getProperty("musteriUsername"));

        //Your Email address kutusuna gecerli bir veri girilir	{email}
        Faker faker = new Faker();
        signUpInPage.signUpEmailTextBoxSS.sendKeys(faker.internet().emailAddress());

        //Password kutusuna gecerli bir veri girilir	{Password}
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(faker.internet().password());

        //I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        //Sign Up butonuna tiklanir
        signUpInPage.signUpOnayButtonSS.click();

        //An account is already registered with that username. Please choose another. uyari yazisinin görüntülendigi dogrulanir
        String expectedText="An account is already registered with that username. Please choose another.";
        String actualText = signUpInPage.alreadyRegisteredUsernameSS.getText();
        System.out.println("actualText = " + actualText);
        Assert.assertTrue(actualText.contains(expectedText));

        ReusableMethods.extentTestPass("Kayitli Username ile kayit olunamadigi dogrulandi");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();

    }
}
