package allovercommerce_com.tests.us11;

import allovercommerce_com.pages.AddressPage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01 {
    @Test
    public void testUS11TC01(){


        ReusableMethods.extentReportCreate("Ismail","Vendor sign in, Vendor olarak Sign in yapılabilmeli",
                "Vendor olarak email ve şifre girilmeli ve sistemde My Accout görünmeli   ---  " +
                        " Dashboard altında ise; Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve log out olmali");
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


        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(myAccountPage.myAccountPageVerifyIsmail.isDisplayed());
        ReusableMethods.extentTestPass("My Account sayfasının görüldüğü doğrulandı");
        softAssert.assertTrue(myAccountPage.storeManagerIsmail.isEnabled());
        ReusableMethods.extentTestPass("Store Manager olduğu doğrulandı");
        softAssert.assertTrue(myAccountPage.ordersIsmail.isEnabled());
        ReusableMethods.extentTestPass("Orders olduğu doğrulandı");
        softAssert.assertTrue(myAccountPage.downloadsIsmail.isEnabled());
        ReusableMethods.extentTestPass("Downloads olduğu doğrulandı");
        softAssert.assertTrue(myAccountPage.addressesIsmail.isEnabled());
        ReusableMethods.extentTestPass("Adresses olduğu doğrulandı");
        softAssert.assertTrue(myAccountPage.accountDetailsIsmail.isEnabled());
        ReusableMethods.extentTestPass("Account Details olduğu doğrulandı");
        softAssert.assertTrue(myAccountPage.wishlistIsmail.isEnabled());
        ReusableMethods.extentTestPass("Wishlist olduğu doğrulandı");
        softAssert.assertTrue(myAccountPage.supportTicketsIsmail.isEnabled());
        ReusableMethods.extentTestPass("Support Tickets olduğu doğrulandı");
        softAssert.assertTrue(myAccountPage.followingsIsmail.isEnabled());
        ReusableMethods.extentTestPass("Followings olduğu doğrulandı");
        softAssert.assertTrue(myAccountPage.logOutIsmail.isEnabled());
        ReusableMethods.extentTestPass("Log Out olduğu doğrulandı");
        softAssert.assertAll();

        ReusableMethods.extentReportFlush();

        Driver.closeDriver();












    }
}
