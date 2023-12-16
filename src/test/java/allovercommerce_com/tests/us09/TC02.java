package allovercommerce_com.tests.us09;


import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;




public class TC02 {

    @Test
    public void TC01() throws InterruptedException {
        SignUpInPage signUpInPage=new SignUpInPage();
        ReusableMethods.extentReportCreate("Muammer","US09-Vendor (Satıcı) olarak, siteye kayıt yapılabilmeli(Vendor Registration)","TC02 Kayıtlı olan bir e-mail adresi ile Vendor olarak siteye kayıt yapılamamalı ve This Email already exists. Please login to the site and apply as vendor.' mesajını almalı");
//      Verilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        String string = Driver.getDriver().getWindowHandle();
        ReusableMethods.extentTestInfo("Verilen URL'e gidildi");

//      Register linkine tıklanır
        signUpInPage.registerMU.click();
        ReusableMethods.extentTestInfo("Register linkine tıklandı");

//      Become a Vendor butonuna tıklanır
        signUpInPage.BecomeAVendorMU.click();
        ReusableMethods.extentTestInfo("Become a Vendor butonuna tıklandı");

//      E-mail kutusuna bir eposta girilir
        signUpInPage.emailBoxMU.sendKeys(ConfigReader.getProperty("vendorEmail"));
        ReusableMethods.extentTestInfo("E-mail kutusuna bir eposta girildi");

//      Verification Code butonuna tıklanır
        signUpInPage.verificationCodeButtonMU.click();
        ReusableMethods.extentTestInfo("Verification Code butonuna tıklandı");

//      Mail adresine gelen kod Verification Code kutusuna girilir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("googleUrl"));
        signUpInPage.gmailButtonMU.click();
        signUpInPage.signInButtonMU.click();
        signUpInPage.gmailBoxMU.sendKeys("vendorvendoring@gmail.com", Keys.ENTER);
        signUpInPage.gmailPasswordBoxMU.sendKeys("vendor123.", Keys.ENTER);
        signUpInPage.otherButtonMU.click();
        signUpInPage.spamButtonMU.click();
        signUpInPage.emailCamingToGmailFromAlloverCommerceMU.click();
        System.out.println();
        String verifyCondeMuammer = signUpInPage.verificationCodeCamingToGmailFromAlloverCommerceMU.getText();
        System.out.println(verifyCondeMuammer);
        String words = verifyCondeMuammer.trim().split(" ")[6];
        Driver.getDriver().switchTo().window(string);
        signUpInPage.verificationCodeButtonMU.sendKeys(words);
        ReusableMethods.extentTestInfo("Mail adresine gelen kod Verification Code kutusuna girildi");

//      Password kutusuna şifre girilir
        signUpInPage.passwordBoxAlloverCommerMU.sendKeys("vendor123.");
        ReusableMethods.extentTestInfo("Password kutusuna şifre girildi");

//      Confirm Password  kutusuna aynı şifre tekrar girilir ve Register butonuna tıklanır
        signUpInPage.confirmPasswordBoxAlloverCommerMU.sendKeys("vendor123.", Keys.ENTER);
        ReusableMethods.extentTestInfo("Confirm Password  kutusuna aynı şifre tekrar girildi ve Register butonuna tıklandı");

//      Kayıt yapılamadığı doğrulanır
        String verifyText=signUpInPage.verifyTextAlloverCommerMU.getText();
        String expectualData = "This Email already exists. Please login to the site and apply as vendor.";
        String actualData = verifyText;
        Assert.assertEquals(expectualData,actualData);
        ReusableMethods.extentTestPass("Kayıt yapılamadığı doğrulandı");

//      Sayfayı kapatalim
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();
    }
}