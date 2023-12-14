package allovercommerce_com.tests.us02;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 {
    @Test
    public void test05() {
        ReusableMethods.extentReportCreate("U2T5 Selma ", "US02","TC05");

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
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(faker.internet().password());

        //I agree to the privacy policy kutusu isaretlenir
        signUpInPage.signUpIAgreeBoxSS.click();

        //Kayit isleminin gerceklestigi dogrulanir
        Assert.assertTrue(signUpInPage.signUpOnayButtonSS.isEnabled());

        ReusableMethods.extentTestPass("Alanlar dolduruldugunda Sign up buttonunun tiklanabilir oldugu dogrulandi");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();

    }
}
