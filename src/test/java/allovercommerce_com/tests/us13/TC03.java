package allovercommerce_com.tests.us13;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC03 {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() {
        MyAccountPage alloverPage = new MyAccountPage();
        SignUpInPage signUpInPage = new SignUpInPage();
        AddressPage shippingAddressPage = new AddressPage();
         Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.extentReportCreate("Fatma",
                "Last Name kutusu boş bırakılarak shipping address eklenmemeli",
                "Shipping address eklenememeli.");

        //https://allovercommerce.com Sitesine Git ve Login Ol
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Driver.getDriver().navigate().refresh();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildi ve Log in Olundu");


        //Sing In'e tıkla.
        signUpInPage.signIn.click();
        ReusableMethods.extentTestInfo("SignIn'e Tıklandı.");

        //Email address gir.
        String fakeEmail = ConfigReader.getProperty("fakeMail2");
        String fakePassword1 = ConfigReader.getProperty("fakePassWord2");
        ReusableMethods.extentTestInfo("Email address girildi.");

        //PassWord gir.
        signUpInPage.userName1.sendKeys(fakeEmail);
        signUpInPage.password1.sendKeys(fakePassword1);
        ReusableMethods.extentTestInfo("Password girildi.");

        //SignIn'e tıkla.
        signUpInPage.signInol.click();
        ReusableMethods.extentTestInfo("SignIn'e tıklandı.");


        //SignOut'a tıkla.
        signUpInPage.signOut.click();
        ReusableMethods.extentTestInfo("SignOut'a tıklandı.");


        //Address butonuna tıkla.
        signUpInPage.address.click();
        ReusableMethods.extentTestInfo("Address butonuna tıklandı.");


        //ADD butonuna tıkla.
        signUpInPage.add.click();
        ReusableMethods.extentTestInfo("Add butonuna tıklandı.");


        //First Name gir.
        String lastName = ConfigReader.getProperty("firstName");
        shippingAddressPage.firstName.sendKeys(lastName);
        ReusableMethods.extentTestInfo("First Name girildi.");


        //Company Name gir.
        String company = ConfigReader.getProperty("company");
        shippingAddressPage.company.sendKeys(company);
        ReusableMethods.extentTestInfo("Company Name girildi.");


        //Country/Region seç.
        Select select = new Select(shippingAddressPage.country1);
        select.selectByVisibleText("Canada");
        ReusableMethods.extentTestInfo("Country/Region girildi.");



        //Street Address2 gir.
        String streetAddress1 = ConfigReader.getProperty("street");
        shippingAddressPage.streetAddress1.sendKeys(streetAddress1);
        ReusableMethods.extentTestInfo("Street Address1 girildi.");


        //Street Address2 gir.
        String streetAddress2 = ConfigReader.getProperty("street1");
        shippingAddressPage.streetAddress2.sendKeys(streetAddress2);
        ReusableMethods.extentTestInfo("Street Address2girildi.");

        //City giriniz.
        String city = ConfigReader.getProperty("city1");
        shippingAddressPage.city.sendKeys(city);
        ReusableMethods.extentTestInfo("City giriniz");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //Province giriniz.
        Select select1 = new Select(shippingAddressPage.state);
        select1.selectByIndex(5);
        ReusableMethods.extentTestInfo("Province giriniz");



        //ZipCode giriniz.
        String zipCode1 = ConfigReader.getProperty("zipcode");
        shippingAddressPage.zipCode.sendKeys(zipCode1);
        ReusableMethods.extentTestInfo("ZipCode giriniz");


        //Save Butona tıkla.
         String saveButton= ConfigReader.getProperty("saveButton");
         shippingAddressPage.saveAddress.sendKeys(Keys.ENTER);
         ReusableMethods.extentTestInfo("Save Butona tıklandı.");



        ReusableMethods.waitForSecond(2);

        softAssert.assertFalse(alloverPage.shipping.isDisplayed());
        ReusableMethods.extentTestInfo("Shipping adress görülmediği doğrulandı.");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();


































    }






}
