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

public class TC17 {
    @Test
    public void test17() {
        ReusableMethods.extentReportCreate("U3T17 Selma", "US03","TC17");
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

        //Town/City kutusuna farkli bir veri girilir
        Faker faker = new Faker();
        addressPage.townCityTextBoxSS.clear();
        addressPage.townCityTextBoxSS.sendKeys(faker.address().city());

        //SAVE ADDRESS butonuna tiklanir
        addressPage.saveAddressButtonSS.click();
        ReusableMethods.waitForSecond(2);
        
        //Address changed successfully. yazisinin görüntülendigi dogrulanir
        String expectedAlertText = "Address changed successfully.";
        String actualAddressAddAlertText = addressPage.addressAddAlertSS.getText().toString();
        System.out.println("addressAddAlertText = " + actualAddressAddAlertText);
        Assert.assertTrue(actualAddressAddAlertText.contains(expectedAlertText));

        ReusableMethods.extentTestPass("Town/City bilgisinin güncellendigi dogrulandi");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();





    }
}
