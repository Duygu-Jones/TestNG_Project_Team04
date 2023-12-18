package allovercommerce_com.tests.us18;

import allovercommerce_com.pages.CouponManagerPage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 {
    SignUpInPage signUpInPage = new SignUpInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    CouponManagerPage couponManagerPage = new CouponManagerPage();
    @Test
    public void testCouponCreate() {

        ReusableMethods.extentReportCreate("Ibrahim",
                "US_18 || Vendor olarak Coupons oluşturabilmeliyim",
                "TC_02 || Code yazılabilmeli -- Negatif Senaryo");

        Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir  https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen siteye gidildi.");

        //Sign-In butonuna tıklanır
        signUpInPage.signInIbrahim.click();

        //Kullanıcı adı girilir vendorvendoring@gmail.com
        //Şifre girilir vendor123.
        //Home page'e gidilir
        String vendorEmail = ConfigReader.getProperty("vendorEmail");
        String vendorPassword = ConfigReader.getProperty("vendorSifre");
        signUpInPage.userNameTextBoxIbrahim.sendKeys(vendorEmail, Keys.TAB, vendorPassword, Keys.ENTER);
        ReusableMethods.extentTestInfo("Vendor hesabına giris yapildi");


        //Home page de olunduğu doğrulanır
        String expectedTitle = "Allover Commerce";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.extentTestPass("Anasayfada olundugu dogrulandı");

        //myaccount
        actions.sendKeys(Keys.END).perform();
        WebElement myAccount = Driver.getDriver().findElement(By.linkText("My Account"));
        myAccountPage.myAccountButtonIsmail.click();
        ReusableMethods.extentTestInfo("MyAccount kısmında gidildi.");

        //store manager
        myAccountPage.storeManagerIsmail.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //coupons button
        ReusableMethods.waitForSecond(3);
        couponManagerPage.couponsButton.click();

        //new coupon
        couponManagerPage.newCouponIbrahim.click();

        //submit buton a tıklanır
        //Submit
        actions.sendKeys(Keys.END,Keys.PAGE_UP).perform();
        ReusableMethods.waitForSecond(2);
        couponManagerPage.submitButtonIbrahim.click();
        ReusableMethods.extentTestInfo("Submit butonuna tıklandı");

        //Coupon Title Error
        ReusableMethods.waitForSecond(3);
        String actualErrorMessage = couponManagerPage.couponTitleErrorMessage.getText();
        String expectedErrorMessage = "Please insert atleast Coupon Title before submit.";
        ReusableMethods.extentTestPass("Kupon olusturulamadı");

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);


        ReusableMethods.extentReportFlush();
        ReusableMethods.waitForSecond(5);
        ReusableMethods.jsClick(signUpInPage.signOutIbrahim);
        ReusableMethods.jsClick(signUpInPage.signOutConfirm);
        ReusableMethods.waitForSecond(5);



    }
}
