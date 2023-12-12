package allovercommerce_com.tests.us03;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {
    @Test
    public void test01() {
        ReusableMethods.extentReportCreate("01Selma Simsek","US03","TC01");
        //Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

        //Sign in butonuna tiklanir
        //Username or email address kutusuna kayitli bir veri girilir
        //Password kutusuna kayitli bir veri girilir
        //Sign in butonuna tiklanir
        ReusableMethods.getRegister();

        //My Account butonuna tiklanir
        HomePage homePage = new HomePage();
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].style.border = '5px solid red'",homePage.myAccountButtonSS);
        ReusableMethods.screenShot("My Account", "01Selma Simsek");
        homePage.myAccountButtonSS.click();

        //Address butonuna tiklanir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.addressButtonSS.click();

        //Billing Address menüsü altindaki ADD butonuna tiklanir
        AddressPage addressPage = new AddressPage();
        ReusableMethods.jsScroll(addressPage.addButtonSS);
        addressPage.addButtonSS.click();

        //Billing Address sayfasinin acildigi dogrulanir
        String expectedBillingAddressText = "Billing address";
        String actualBillingAddressText = addressPage.billingAddressButtonSS.getText();
        System.out.println("actualBillingAddressText = " + actualBillingAddressText);
        Assert.assertEquals(expectedBillingAddressText,actualBillingAddressText);

        ReusableMethods.extentTestPass("Billing Address sayfasinin acildigi dogrulandi");
        ReusableMethods.extentTestInfo("Cosmetic Bug : My Account Buttonu görünmüyor");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();
    }
}
