package allovercommerce_com.tests.us03;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 {
    @Test
    public void test02() {
        ReusableMethods.extentReportCreate("U3T2 Selma", "US03","TC02");
       // Web sitesine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));

       // Sign in butonuna tiklanir
       // Username or email address kutusuna kayitli bir veri girilir
       // Password kutusuna kayitli bir veri girilir
       // Sign in butonuna tiklanir
        Faker faker = new Faker();
        HomePage homePage = new HomePage();
        SignUpInPage signUpInPage = new SignUpInPage();

        String kayitliEmail = faker.internet().emailAddress();
        homePage.registerButtonSS.click();
        signUpInPage.signUpUsernameTextBoxSS.sendKeys(faker.name().username());
        signUpInPage.signUpEmailTextBoxSS.sendKeys(kayitliEmail);
        signUpInPage.signUpPasswordTextBoxSS.sendKeys(faker.internet().password());
        signUpInPage.signUpIAgreeBoxSS.click();
        signUpInPage.signUpOnayButtonSS.click();

        // My Account Butonuna tiklanir
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
        addressPage.firstNameTextBoxSS.sendKeys(faker.name().firstName());

       // Last name kutusuna bir veri girilir
        addressPage.lastNameTextBoxSS.sendKeys(faker.name().lastName());
        ReusableMethods.jsScroll(addressPage.countryRegionDdmSS);

       // Country / Region menüsünden bir secenek secilir
        ReusableMethods.ddmIndex(addressPage.countryRegionDdmSS,5);

       // Street address kutusuna bir veri girilir
        addressPage.streetAddressTextBoxSS.sendKeys(faker.address().streetAddress());

       // Town/City kutusuna bir veri girilir
        addressPage.townCityTextBoxSS.sendKeys(faker.address().city());

       // State / Country kutusuna bir veri girilir
        try {
            ReusableMethods.ddmIndex(addressPage.stateTextBoxSS, 3);
        } catch (Exception e) {
            ReusableMethods.jsSendKeys(addressPage.stateTextBoxSS,faker.address().state());
        }

       // Postcode / ZIP kutusuna bir veri girilir
        addressPage.zipCodeTextBoxSS.sendKeys(faker.address().zipCode());

       // Phone kutusuna bir veri girilir
        addressPage.phoneTextBoxSS.sendKeys(faker.phoneNumber().cellPhone());

        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].style.border='5px solid red'",addressPage.stateTextBoxSS);

        ReusableMethods.waitForSecond(3);

       // Email adresinin otomatik geldigi dogrulanir
        String expectedEmailTextData = kayitliEmail;
        System.out.println("expectedData = " + expectedEmailTextData);
        String actualEmailTextData = ReusableMethods.jsGetValueBySS("billing_email","value");
        System.out.println("actualEmailTextData = " + actualEmailTextData);
        Assert.assertTrue(actualEmailTextData.contains(expectedEmailTextData));
        ReusableMethods.extentTestPass("Email adresinin otomatik geldigi dogrulandi");

        ReusableMethods.screenShot("State_Country", "U3T2 Selma");
        ReusableMethods.extentTestInfo("Manuell testte Dropdown menü olan State/Country menü, otomasyonda input olarak degerlendirildi");
        ReusableMethods.extentReportFlush();


        Driver.closeDriver();





    }
}
