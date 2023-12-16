package allovercommerce_com.tests.us13;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC10 {

    SoftAssert softAssert = new SoftAssert();

    Faker faker = new Faker();

    @Test
    public void test01() {
        MyAccountPage alloverPage = new MyAccountPage();
        SignUpInPage signUpInPage = new SignUpInPage();
        AddressPage shippingAddressPage = new AddressPage();

        ReusableMethods.extentReportCreate("Fatma",
                "Company Name kutusu boş bırakıldığında shipping address ekleyebilmeli",
                "Shipping adress eklenebilmeli");

        //https://allovercommerce.com Sitesine Git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Driver.getDriver().navigate().refresh();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildi");

        //Register'a tıkla
        alloverPage.register.click();
        ReusableMethods.extentTestInfo("Register'a tıklandı");

        //Sign Up'a tıkla.

        ReusableMethods.extentTestInfo("Sign UP'a tıklandı");


        //Username gir.
        String userNameFaker=faker.name().username();
        alloverPage.userNamebox.sendKeys(userNameFaker);
        ReusableMethods.extentTestInfo("Username girildi.");


        //Email address gir.
        String addressBox =faker.internet().emailAddress();
        alloverPage.mailBox.sendKeys(addressBox);
        ReusableMethods.extentTestInfo("Email address girildi.");


        //Password address gir.
        String passWordBox1 =faker.internet().password();
        alloverPage.passWordBox.sendKeys(passWordBox1);
        ReusableMethods.extentTestInfo("Password address girildi.");


        //Tik'e Tıkla.
        alloverPage.tick.click();
        alloverPage.tick.sendKeys(Keys.TAB,Keys.ENTER);
        ReusableMethods.extentTestInfo("Tik'e tıklandı.");


        //Sign Out'a tıkla.
        signUpInPage.signOut.click();
        ReusableMethods.extentTestInfo("Sign Out'a tıklandı.");


        //Address'e tıkla.
        signUpInPage.address.click();
        ReusableMethods.extentTestInfo("Addresse tıklandı.");

        //Add'tıkla.
        signUpInPage.add.click();
        ReusableMethods.extentTestInfo("Add'e tıklandı.");


        //First Name gir.
        String firstName2 = ConfigReader.getProperty("firstName");
        shippingAddressPage.firstName.sendKeys(firstName2, Keys.TAB);
        ReusableMethods.extentTestInfo("First Name girildi.");

        //Last name gir.
        String lastName = ConfigReader.getProperty("lastName");
        shippingAddressPage.lastName.sendKeys(lastName);
        ReusableMethods.extentTestInfo("Last name girildi.");


        //Country gir.
        Select select = new Select(shippingAddressPage.country1);
        select.selectByVisibleText("Canada");
        ReusableMethods.extentTestInfo("Country girildi.");


        //Street giriniz.
        String streetAddress1 = ConfigReader.getProperty("street");
        shippingAddressPage.streetAddress1.sendKeys(streetAddress1, Keys.TAB);
        ReusableMethods.extentTestInfo("Street girildi.");






        //Street giriniz.
        String streetAddress2 = ConfigReader.getProperty("street1");
        shippingAddressPage.streetAddress2.sendKeys(streetAddress2,Keys.PAGE_DOWN);
        ReusableMethods.extentTestInfo("Street girildi.");



        //City/Town gir.
        String city = ConfigReader.getProperty("city1");
        shippingAddressPage.city.sendKeys(city, Keys.TAB);
        ReusableMethods.extentTestInfo("City/Town girildi..");



        //State gir.
        Select select1 = new Select(shippingAddressPage.state);
        select1.selectByIndex(5);
        ReusableMethods.extentTestInfo("State girildi.");



        //Zipcode gir.
        String zipCode1 = ConfigReader.getProperty("zipcode");
        shippingAddressPage.zipCode.sendKeys(zipCode1);
        ReusableMethods.extentTestInfo("Zip Code girildi.");


        //Save button'a tıkla.
        String saveButton = ConfigReader.getProperty("saveButton");
        shippingAddressPage.saveAddress.sendKeys(Keys.ENTER);
        ReusableMethods.extentTestInfo("Save Butona tıklandı.");





        //Kayıdın gerçekleştiği doğrulanır.

        ReusableMethods.waitForSecond(5);
        softAssert.assertTrue(alloverPage.shipping.isDisplayed());
        ReusableMethods.extentTestInfo("Kayıdın gerçekleştiği doğrulandi");
        ReusableMethods.extentTestPass("Kullanıcı Shipping Adress ekleyebildi");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();


    }




}
