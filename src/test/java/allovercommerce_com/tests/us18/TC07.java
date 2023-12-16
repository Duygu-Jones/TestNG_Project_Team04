package allovercommerce_com.tests.us18;

import allovercommerce_com.pages.CouponManagerPage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07 {
    SignUpInPage signUpInPage = new SignUpInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    CouponManagerPage couponManagerPage = new CouponManagerPage();
    @Test
    public void testCouponCreate() {
        Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir  https://allovercommerce.com/
        Driver.getDriver().get(" https://allovercommerce.com/");

        //Sign-In butonuna tıklanır
        signUpInPage.signInIbrahim.click();

        //Kullanıcı adı girilir vendorvendoring@gmail.com
        //Şifre girilir vendor123.
        //Home page'e gidilir
        signUpInPage.userNameTextBoxIbrahim.sendKeys("vendorvendoring@gmail.com", Keys.TAB, "vendor123.", Keys.ENTER);

        //Home page de olunduğu doğrulanır
        String expectedTitle = "Allover Commerce";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        ReusableMethods.waitForSecond(2);

        //myaccount
        actions.sendKeys(Keys.END).perform();
        WebElement myAccount = Driver.getDriver().findElement(By.linkText("My Account"));
        myAccountPage.myAccountButtonIsmail.click();

        //store manager
        myAccountPage.storeManagerIsmail.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //coupons button
        ReusableMethods.waitForSecond(3);
        couponManagerPage.couponsButton.click();

        //new coupon
        couponManagerPage.newCouponIbrahim.click();

        //coupon code
        String coupon = "dsc18904";
        couponManagerPage.couponCodeBoxIbrahim.sendKeys(coupon);

        //description
        couponManagerPage.descriptionBox.sendKeys("%10 discount");

        //Percentage
        Select select = new Select(couponManagerPage.discountType);
        select.getFirstSelectedOption();

        //coupon amount
        ReusableMethods.deleteAll(couponManagerPage.couponAmount);
        couponManagerPage.couponAmount.sendKeys("10");

        //Amount dogrulama
        String expectedAmount = "10";
        String actualAmount = couponManagerPage.couponAmount.getAttribute("value");
        Assert.assertEquals(actualAmount,expectedAmount);

        //ileri tarih girilir
        String validExpiryDate = "2024-12-31";
        couponManagerPage.expiryDate.sendKeys(validExpiryDate,Keys.ENTER);

    }
}
