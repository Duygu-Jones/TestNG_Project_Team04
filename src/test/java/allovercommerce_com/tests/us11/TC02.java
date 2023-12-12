package allovercommerce_com.tests.us11;

import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC02 {
    @Test
    public void testUS11TC02() {
        ReusableMethods.extentReportCreate("Ismail","Vendor sign in, Vendor olarak Sign in yapılabilmeli",
                "Dashboard altındaki bu menülere girilebilmeli");

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

        SoftAssert softAssert=new SoftAssert();

        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.myAccountButtonIsmail.click();
        ReusableMethods.extentTestInfo("My Account sekmesine tıklandı");

        myAccountPage.storeManagerIsmail.click();
        ReusableMethods.extentTestInfo("Store Manager sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.storeManagerVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Store Manager menüsüne giriş doğrulandı");

        Driver.getDriver().navigate().back();

        myAccountPage.ordersIsmail.click();
        ReusableMethods.extentTestInfo("Orders sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.ordersVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Orders menüsüne giriş doğrulandı");

        myAccountPage.downloadsIsmail.click();
        ReusableMethods.extentTestInfo("Downloads sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.downloadsVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Downloads menüsüne giriş doğrulandı");

        myAccountPage.addressesIsmail.click();
        ReusableMethods.extentTestInfo("Adresses sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.adressesVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Adresses menüsüne giriş doğrulandı");

        myAccountPage.accountDetailsIsmail.click();
        ReusableMethods.extentTestInfo("Account Details sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.accountDetailsVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Account Details menüsüne giriş doğrulandı");

        ReusableMethods.jsScroll(myAccountPage.wishlistIsmail);
        ReusableMethods.waitForSecond(1);

        myAccountPage.wishlistIsmail.click();
        ReusableMethods.extentTestInfo("Wishlist sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.wishlistVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Wishlist menüsüne giriş doğrulandı");

        Driver.getDriver().navigate().back();

        myAccountPage.supportTicketsIsmail.click();
        ReusableMethods.extentTestInfo("Support Tickets sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.supportTicketsVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Support Tickets menüsüne giriş doğrulandı");

        ReusableMethods.waitForSecond(1);
        ReusableMethods.jsScroll(myAccountPage.followingsIsmail);
        ReusableMethods.waitForSecond(1);

        myAccountPage.followingsIsmail.click();
        ReusableMethods.extentTestInfo("Followings sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.followingsVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Followings menüsüne giriş doğrulandı");

        ReusableMethods.jsScroll(myAccountPage.logOutIsmail);
        ReusableMethods.waitForSecond(1);

        myAccountPage.logOutIsmail.click();
        ReusableMethods.extentTestInfo("Log Out sekmesine tıklandı");
        softAssert.assertTrue(myAccountPage.logoutVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("Log Out menüsüne giriş doğrulandı");
        ReusableMethods.extentTestInfo("Vendor hesabından çıkış yapıldı");


        softAssert.assertAll();

        ReusableMethods.extentReportFlush();

        Driver.closeDriver();



    }
}
