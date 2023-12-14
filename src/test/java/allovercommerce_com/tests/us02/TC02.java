package allovercommerce_com.tests.us02;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 {
    @Test
    public void test02() {
        ReusableMethods.extentReportCreate("U2T2 Selma ", "US02","TC02");

        //Web sitesine gidilir	https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Register butonuna tiklanir
        HomePage homePage = new HomePage();
        homePage.registerButtonSS.click();

        //Username kutusuna kayitli bir veri girilir Alice
        Faker faker = new Faker();
        SignUpInPage signUpInPage = new SignUpInPage();
        signUpInPage.signUpUsernameTextBoxSS.sendKeys(faker.name().username());

        //Your Email address kutusuna gecerli bir veri girilir	{email}
        signUpInPage.signUpEmailTextBoxSS.sendKeys(ConfigReader.getProperty("musteriEmail"));

        //Password kutusuna gecerli bir veri girilir	{Password}
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(faker.internet().password());

        //I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        //Sign Up butonuna tiklanir
        signUpInPage.signUpOnayButtonSS.click();

        //An account is already registered with that username. Please choose another. uyari yazisinin görüntülendigi dogrulanir
        String expectedText="An account is already registered with your email address. Please log in.";
        String actualText = signUpInPage.alreadyRegisteredEmailSS.getText();
        System.out.println("actualText = " + actualText);
        Assert.assertTrue(actualText.contains(expectedText));

        ReusableMethods.extentTestPass("Kayitli Email ile kayit olunamadigi dogrulandi");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();

    }
}
