package allovercommerce_com.tests.us10;

import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 {
    ReusableMethods reusableMethods = new ReusableMethods();
    SignUpInPage signUpInPage = new SignUpInPage();

    @Test
    public void TC04() {

        ReusableMethods.extentReportCreate("Muammer", "US10-Password seviyeleri görülebilmeli (Vendor Kaydı için)", "TC04 Password seviyeleri (Strong) görülebilmeli");

//    Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen URL'e gidildi");

//    Register linkine tıklanır
        signUpInPage.registerMU.click();
        ReusableMethods.extentTestInfo("Register linkine tıklandı");

//    Sign up as a vendor? linkine tıklanır
        signUpInPage.signUpAsAVendorButtonMU.click();
        ReusableMethods.extentTestInfo("Become a Vendor butonuna tıklandı");

//    Password kutusuna veri girilir
        signUpInPage.passwordBoxAlloverCommerMU.sendKeys("aA123456");
        ReusableMethods.extentTestInfo("Password kutusuna veri girildi");

//    "Strong" yazısının görüldüğünü doğrular
        String actualResult = signUpInPage.strongTextMU.getText();
        String expectedResult = "Strong";
        Assert.assertEquals(expectedResult, actualResult);
        ReusableMethods.extentTestPass(" 'Strong' yazısının görüldüğü doğrulandı");

//    Sayfayı kapatılır
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();
    }
}