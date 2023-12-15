package allovercommerce_com.tests.us13;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC11 {


    SoftAssert softAssert = new SoftAssert();
    @Test
    public void test01() {

        MyAccountPage alloverPage = new MyAccountPage();
        SignUpInPage signUpInPage = new SignUpInPage();
        AddressPage  shippingAddressPage = new AddressPage();

        ReusableMethods.extentReportCreate("Fatma",
                "First name,Last Name, Company Name,Country/Region, Streer address,Town/City,State ve ZIP code girirlmeli",
                "First name,Last Name, Company Name,Country/Region, Streer address,Town/City,State ve ZIP code girilebilmeli");

        //	https://allovercommerce.com Sitesine Git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Driver.getDriver().navigate().refresh();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildi.");


        //Sign in'e tıkla.
        signUpInPage.signIn.click();
        ReusableMethods.extentTestInfo("Sign in'e tıklandı.");

        //Geçerli E-mail ve password gir.
        String fakeEmail = ConfigReader.getProperty("fakeMail2");
        String fakePassword1 = ConfigReader.getProperty("fakePassWord2");
        signUpInPage.userName1.sendKeys(fakeEmail,Keys.ENTER);
        signUpInPage.password1.sendKeys(fakePassword1, Keys.TAB);
        ReusableMethods.extentTestInfo("Geçerli E-mail ve password girildi.");


        //SignIn'e tıkla.
        signUpInPage.signInol.click();
        ReusableMethods.extentTestInfo("Sign In'e tıklandı.");


        //SignOut'a tıkla.
        signUpInPage.signOut.click();
        ReusableMethods.extentTestInfo("Sign Out'a tıklandı.");


        //Addresse tıkla.
        signUpInPage.address.click();
        ReusableMethods.extentTestInfo("Addresse tıklandı.");

        //Add butonuna tıkla.
        signUpInPage.add.click();
        ReusableMethods.extentTestInfo("Add butonuna tıklandı.");



        //First Name girilebildiğini doğrula.
       softAssert.assertTrue(shippingAddressPage.firstName.isEnabled());
        ReusableMethods.extentTestInfo("Firstname girilebilidği doğrulandı.");

        //Last Name girilebildiğini doğrula.
        softAssert.assertTrue(shippingAddressPage.lastName.isEnabled());
        ReusableMethods.extentTestInfo("Last name girilebildiği doğrulandı.");


        //Company Name girilebildiğini doğrula.
        softAssert.assertTrue(shippingAddressPage.company.isEnabled());
        ReusableMethods.extentTestInfo("Company Name girilebilidiği doğrulandı.");



        //Country/Region girilebildiğini doğrula.
        softAssert.assertTrue(shippingAddressPage.country1.isEnabled());
        ReusableMethods.extentTestInfo("Country/Region girilebilidği doğrulandı.");

        //Street address1 girilebildiğini doğrula.
        softAssert.assertTrue(shippingAddressPage.streetAddress1.isEnabled());
        ReusableMethods.extentTestInfo("Street1 addrese girilebilidiği doğrulandı.");


        //Street address2 girilebildiğini doğrula.
        softAssert.assertTrue(shippingAddressPage.streetAddress2.isEnabled());
        ReusableMethods.extentTestInfo("Street2  addrese girilebildiği doğrulandı.");


        //State girilebildiğini doğrula.
        softAssert.assertTrue(shippingAddressPage.state.isEnabled());
        ReusableMethods.extentTestInfo("State girilebilidği doğrulandı.");


        //ZipCode girilebildiğini doğrula.
        softAssert.assertTrue(shippingAddressPage.zipCode.isEnabled());
        ReusableMethods.extentTestInfo("Zip Code girilebildiği doğrulandı.");



        //Town/City girilebildiğini doğrula.
        softAssert.assertTrue(shippingAddressPage.city.isEnabled());
        ReusableMethods.extentTestInfo("Town/City girilebildiği doğrulandı.");



    }




}
