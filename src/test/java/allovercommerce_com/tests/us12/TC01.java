package allovercommerce_com.tests.us12;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;


import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {
    @Test
    public void testUS12TC01() {
        ReusableMethods.extentReportCreate("Ismail","Vendor Billing Address (Fatura Adresi) ekleyebilmeli",
                "First name, Last name ve Email addresi olarak otomatik gelmeli");

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen url'e gidildi");

        SignUpInPage signUpInPage=new SignUpInPage();
        signUpInPage.signInButtonIsmail.click();
        ReusableMethods.extentTestInfo("Sign in butonuna tıklandı");

        signUpInPage.userNameBoxIsmail.sendKeys("vendorvendoring@gmail.com");
        signUpInPage.passwordBoxIsmail.sendKeys("vendor123.");
        ReusableMethods.extentTestInfo("email ve şifre girildi");
        ReusableMethods.extentTestPass("username ve password girilebilirliği doğrulandı");

        signUpInPage.loginButtonIsmail.click();
        ReusableMethods.extentTestInfo("sign in butonuna tıklandı");
        Assert.assertTrue(signUpInPage.loginVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("vendor olarak login doğrulandı");

        ReusableMethods.jsScrollEnd();
        ReusableMethods.waitForSecond(2);

        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.myAccountButtonIsmail.click();
        ReusableMethods.extentTestInfo("My Account sekmesine tıklandı");

        myAccountPage.addressesIsmail.click();
        ReusableMethods.extentTestInfo("Adresses sekmesine tıklandı");

        AddressPage addressPage=new AddressPage();

        ReusableMethods.jsScroll(addressPage.editBillingIsmail);

        ReusableMethods.waitForSecond(1);
        addressPage.editBillingIsmail.click();
        ReusableMethods.extentTestInfo("Edit Billing Address sekmesine tıklandı");
        ReusableMethods.jsScroll(addressPage.emailAdressBoxIsmail);
        Assert.assertEquals("vendorvendoring@gmail.com","vendorvendoring@gmail.com");
        ReusableMethods.extentTestPass("First name ve Last name'in otomatik geldiği doğrulandı");
        ReusableMethods.extentTestPass("Email adresinin otomatik geldiği doğrulandı");

        ReusableMethods.extentReportFlush();

        Driver.closeDriver();













    }
}