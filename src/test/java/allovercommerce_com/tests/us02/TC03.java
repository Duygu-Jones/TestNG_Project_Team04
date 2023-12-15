package allovercommerce_com.tests.us02;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 {
    @Test
    public void test03() {
        ReusableMethods.extentReportCreate("U2T3 Selma ", "US02","TC03");

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
        signUpInPage.signUpEmailTextBoxSS.sendKeys(faker.internet().emailAddress());

        //Password kutusuna gecerli bir veri girilir	{Password}
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(ConfigReader.getProperty("musteriPassword"));

        //I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        //Sign Up butonuna tiklanir
        signUpInPage.signUpOnayButtonSS.click();

        //Kayit isleminin gerceklestigi dogrulanir
        Assert.assertTrue(homePage.signUpButtonSS.isDisplayed());

        ReusableMethods.extentTestPass("Kayitli Password ile kayit olunabildigi dogrulandi");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();

    }
}
