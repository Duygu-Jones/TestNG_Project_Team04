package allovercommerce_com.tests.us03;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC15 {
    @Test
    public void test15() {
        ReusableMethods.extentReportCreate("U3T15 Selma", "US03","TC15");
       // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

       // Sign in butonuna tiklanir
       // Username or email address kutusuna kayitli bir veri girilir
       // Password kutusuna kayitli bir veri girilir
       // Sign in butonuna tiklanir
        ReusableMethods.getSignInSS();
        HomePage homePage = new HomePage();
        homePage.myAccountButtonSS.click();

        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.addressButtonSS.click();

        //Billing Address menüsü altindaki EDIT YOUR BILLING ADDRES butonuna tiklanir
        AddressPage addressPage = new AddressPage();
        addressPage.editYourBillingAddressSS.click();

        //Country / Region menüsünden farkli bir secenek secilir
        ReusableMethods.ddmIndex(addressPage.countryRegionDdmSS,8);

        //SAVE ADDRESS butonuna tiklanir
        addressPage.saveAddressButtonSS.click();
        ReusableMethods.waitForSecond(2);
        
        //Address changed successfully. yazisinin görüntülendigi dogrulanir
        String expectedAlertText = "Address changed successfully.";
        String actualAddressAddAlertText = addressPage.addressAddAlertSS.getText().toString();
        System.out.println("addressAddAlertText = " + actualAddressAddAlertText);
        Assert.assertTrue(actualAddressAddAlertText.contains(expectedAlertText));


        ReusableMethods.extentTestPass("Country / Region bilgisinin güncellendigi dogrulandi");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();





    }
}
