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

public class TC13 {
    @Test
    public void test13() {
        ReusableMethods.extentReportCreate("U3T13 Selma", "US03","TC13");
       // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

       // Sign in butonuna tiklanir
       // Username or email address kutusuna kayitli bir veri girilir
       // Password kutusuna kayitli bir veri girilir
       // Sign in butonuna tiklanir
        ReusableMethods.getSignInSS();
        HomePage homePage = new HomePage();
        homePage.myAccountButtonSS.click();

        // Adress butonuna tiklanir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.addressButtonSS.click();

        //Billing Address menüsü altindaki EDIT YOUR BILLING ADDRES butonuna tiklanir
        AddressPage addressPage = new AddressPage();
        addressPage.editYourBillingAddressSS.click();

        //First name kutusuna farkli bir veri girilir
        Faker faker = new Faker();
        addressPage.firstNameTextBoxSS.clear();
        addressPage.firstNameTextBoxSS.sendKeys(faker.name().firstName());

        //SAVE ADDRESS butonuna tiklanir
        addressPage.saveAddressButtonSS.click();
        ReusableMethods.waitForSecond(2);

        //Address changed successfully. yazisinin görüntülendigi dogrulanir
        String expectedAlertText = "Address changed successfully.";
        String actualAddressAddAlertText = addressPage.addressAddAlertSS.getText().toString();
        System.out.println("addressAddAlertText = " + actualAddressAddAlertText);
        Assert.assertTrue(actualAddressAddAlertText.contains(expectedAlertText));

        ReusableMethods.extentTestPass("First Name bilgisinin güncellendigi dogrulandi");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();





    }
}
