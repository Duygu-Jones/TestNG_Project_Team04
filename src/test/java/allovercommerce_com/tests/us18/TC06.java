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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06 {
    SignUpInPage signUpInPage = new SignUpInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    CouponManagerPage couponManagerPage = new CouponManagerPage();
    @Test
    public void testCouponCreate() {

        ReusableMethods.extentReportCreate("Ibrahim",
                "US_18 || Vendor olarak Coupons oluşturabilmeliyim",
                "TC_06 || Coupon Amount yazılabilmeli");

        Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir  https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen siteye gidildi.");

        //Sign-In butonuna tıklanır
        signUpInPage.signInIbrahim.click();

        //Kullanıcı adı girilir
        //Şifre girilir
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

        //coupon code
        String coupon = "dsc18910";
        couponManagerPage.couponCodeBoxIbrahim.sendKeys(coupon);
        ReusableMethods.extentTestInfo("Kupon kodu yazildi");

        //description
        couponManagerPage.descriptionBox.sendKeys("%10 discount");
        ReusableMethods.extentTestInfo("Kupon description yazildi");

        //Percentage
        Select select = new Select(couponManagerPage.discountType);
        select.getFirstSelectedOption();
        ReusableMethods.extentTestInfo("Indirim turu secildi");

        //coupon amount
        ReusableMethods.deleteAll(couponManagerPage.couponAmount);
        couponManagerPage.couponAmount.sendKeys("10");
        ReusableMethods.extentTestInfo("Kupon miktari girildi.");


        ReusableMethods.extentReportFlush();
        ReusableMethods.waitForSecond(5);
        ReusableMethods.jsClick(signUpInPage.signOutIbrahim);
        ReusableMethods.jsClick(signUpInPage.signOutConfirm);
        ReusableMethods.waitForSecond(5);



    }
}
