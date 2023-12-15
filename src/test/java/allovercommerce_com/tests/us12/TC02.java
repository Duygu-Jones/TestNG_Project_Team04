package allovercommerce_com.tests.us12;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 {
    @Test
    public void testUS12TC02() {

        ReusableMethods.extentReportCreate("Ismail","Vendor Billing Address (Fatura Adresi) ekleyebilmeli",
                "Country/Region, Street address, Town / City, State, ZIP Code ve Phone girilmeli --- " +
                        "Save Address butonuna tıklayarak Billing Addrese (Fatura Adresi) eklenmeli --- " +
                        "Address changed successfully metni görülmeli");

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen url'e gidildi");

        SignUpInPage signUpInPage=new SignUpInPage();
        signUpInPage.signInButtonIsmail.click();
        ReusableMethods.extentTestInfo("Sign in butonuna tıklandı");

        signUpInPage.userNameBoxIsmail.sendKeys("vendorvendoring@gmail.com");
        signUpInPage.passwordBoxIsmail.sendKeys("vendor123.");
        ReusableMethods.extentTestInfo("email ve şifre girildi");
        signUpInPage.loginButtonIsmail.click();
        ReusableMethods.extentTestInfo("sign in butonuna tıklandı");
        Assert.assertTrue(signUpInPage.loginVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("login doğrulandı");
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

        ReusableMethods.deleteAll(addressPage.companyTextBoxSS);
        ReusableMethods.jsScroll(addressPage.countryBoxIsmail);
        ReusableMethods.waitForSecond(1);
        addressPage.countryBoxIsmail.click();
        Select select=new Select(addressPage.countryListIsmail);
        select.selectByValue("AL");
        ReusableMethods.deleteAll(addressPage.streetAddressTextBoxSS);
        ReusableMethods.deleteAll(addressPage.zipCodeTextBoxSS);
        ReusableMethods.deleteAll(addressPage.townCityTextBoxSS);
        ReusableMethods.deleteAll(addressPage.phoneTextBoxSS);

        addressPage.companyTextBoxSS.sendKeys("Akar");
        ReusableMethods.extentTestInfo("company kutucuğuna tıklandı");
        ReusableMethods.extentTestPass("company kutucuğuna veri girilebilirliği doğrulandı");

        addressPage.countryBoxIsmail.click();
        ReusableMethods.extentTestInfo("country kutucuğuna tıklandı");
        select.selectByValue("TR");
        ReusableMethods.extentTestPass("country kutucuğuna veri girilebilirliği doğrulandı");

        addressPage.streetAddressTextBoxSS.click();
        ReusableMethods.extentTestInfo("Street Adress kutucuğuna tıklandı");
        addressPage.streetAddressTextBoxSS.sendKeys("Arda Street");
        ReusableMethods.extentTestPass("Street Adress kutucuğuna veri girilebilirliği doğrulandı");

        addressPage.zipCodeTextBoxSS.click();
        ReusableMethods.extentTestInfo("Zip Code kutucuğuna tıklandı");
        addressPage.zipCodeTextBoxSS.sendKeys("82000");
        ReusableMethods.extentTestPass("Zip Code kutucuğuna veri girilebilirliği doğrulandı");

        addressPage.townCityTextBoxSS.click();
        ReusableMethods.extentTestInfo("Town/City kutucuğuna tıklandı");
        addressPage.townCityTextBoxSS.sendKeys("Yozgat");
        ReusableMethods.extentTestPass("Town/City kutucuğuna veri girilebilirliği doğrulandı");


      addressPage.provinceBoxIsmail.click();
        ReusableMethods.extentTestInfo("Province kutucuğuna tıklandı");
      addressPage.provinceIsmail.sendKeys("Yozgat",Keys.ENTER);
        ReusableMethods.extentTestPass("Province kutucuğuna veri girilebilirliği doğrulandı");

        addressPage.phoneTextBoxSS.click();
        ReusableMethods.extentTestInfo("Phone kutucuğuna tıklandı");
        addressPage.phoneTextBoxSS.sendKeys("905452626226");
        ReusableMethods.extentTestPass("Phone kutucuğuna veri girilebilirliği doğrulandı");

        addressPage.saveAddressButtonSS.click();
        ReusableMethods.extentTestInfo("Save Adress kutucuğuna tıklandı");
        ReusableMethods.waitForVisibleElement(addressPage.adressSuccessIsmail,2);
        Assert.assertTrue(addressPage.adressSuccessIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Girilen bilgilerin kayıt edildiği doğrulandı");
        ReusableMethods.extentTestPass("Ekranda Address changed successfully. görüldüğü doğrulandı");

        ReusableMethods.extentReportFlush();

        Driver.closeDriver();



    }
}
