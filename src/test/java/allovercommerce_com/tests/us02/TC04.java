package allovercommerce_com.tests.us02;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 {
    @Test
    public void test04() {
        ReusableMethods.extentReportCreate("U2T4 Selma ", "US02","TC04");

        //Web sitesine gidilir	https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Register butonuna tiklanir
        HomePage homePage = new HomePage();
        homePage.registerButtonSS.click();

        //Username kutusu bos birakilir

        //Your Email address kutu bos birakilir

        //Password kutusu bos birakilir

        //I agree to the privacy policy kutusu bos birakilir

        //Sign Up butonunun tiklanabilir olmadigi dogrulanir
        SignUpInPage signUpInPage = new SignUpInPage();
        Assert.assertTrue(signUpInPage.signUpOnayButtonSS.isEnabled());

        ReusableMethods.screenShot("Sign UP Button", "U2T4 Selma");
        ReusableMethods.extentTestFail("Alanlar bos birakildiginda Sign Up butonu tiklanabilir oldugu icin test Fail oldu");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();

    }
}
