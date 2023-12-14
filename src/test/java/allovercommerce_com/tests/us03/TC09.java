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

public class TC09 {
    @Test
    public void test09() {
        ReusableMethods.extentReportCreate("U3T9 Selma", "US03","TC09");
       // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

       // Sign in butonuna tiklanir
       // Username or email address kutusuna kayitli bir veri girilir
       // Password kutusuna kayitli bir veri girilir
       // Sign in butonuna tiklanir
        ReusableMethods.getRegister();

        // My Account Butonuna tiklanir
        HomePage homePage =new HomePage();
        homePage.myAccountButtonSS.click();

       // Adress butonuna tiklanir
        MyAccountPage myAccountPage = new MyAccountPage();
        myAccountPage.addressButtonSS.click();
        ReusableMethods.waitForSecond(2);

       // Billing Address menüsü altindaki ADD butonuna tiklanir
        AddressPage addressPage = new AddressPage();
        ReusableMethods.jsScroll(addressPage.addButtonSS);
        addressPage.addButtonSS.click();

       // First name kutusuna bir veri girilir
        Faker faker = new Faker();
        addressPage.firstNameTextBoxSS.sendKeys(faker.name().firstName());

       // Last name kutusuna bir veri girilir
        addressPage.lastNameTextBoxSS.sendKeys(faker.name().lastName());
        ReusableMethods.jsScroll(addressPage.countryRegionDdmSS);

       // Country / Region menüsünden bir veri secilir
        ReusableMethods.ddmIndex(addressPage.countryRegionDdmSS,5);

       // Street address kutusuna bir veri girilir
        addressPage.streetAddressTextBoxSS.sendKeys(faker.address().streetAddress());

       // Town/City na bir veri girilir
        addressPage.townCityTextBoxSS.sendKeys(faker.address().city());

       // State / Country kutusu bos birakilir

       // Postcode / ZIP kutusuna bir veri girilir
        addressPage.zipCodeTextBoxSS.sendKeys(faker.address().zipCode());

       // Phone kutusuna bir veri girilir
        addressPage.phoneTextBoxSS.sendKeys(faker.phoneNumber().cellPhone());

        addressPage.saveAddressButtonSS.click();
        ReusableMethods.waitForSecond(2);

        //Adres bilgisi kayit isleminin yapilamadigi dogrulanir
        String expectedbosTextAlertText = "State / County is a required field.";
        String actualbosTextAlertText = addressPage.bosTextAlertSS.getText().toString();
        System.out.println("actualbosTextAlertText = " + actualbosTextAlertText);
        Assert.assertTrue(actualbosTextAlertText.contains(expectedbosTextAlertText));

        ReusableMethods.extentTestPass("State / Country kutusu bos biralilarak islem kaydi yapilamadigi dogrulandi");
        ReusableMethods.extentReportFlush();

        Driver.closeDriver();





    }
}
