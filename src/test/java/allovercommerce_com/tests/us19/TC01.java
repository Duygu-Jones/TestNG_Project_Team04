package allovercommerce_com.tests.us19;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {

    SignUpInPage signUpInPage = new SignUpInPage();
    HomePage homePage = new HomePage();
    @Test
    public void testCustomerButWithCoupon() {

        ReusableMethods.extentReportCreate("Ibrahim",
                "US_19 || Oluşturulan Coupon ile müşteri olarak alışveriş yapılabilmeli",
                "TC_01 || Kullanıcı search box tan istediği bir ürünü arayabilmeli");

        Actions actions = new Actions(Driver.getDriver());
        //Verilen URL' ye gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen siteye gidildi.");

        //Sign-In butonuna tıklanır
        signUpInPage.signInIbrahim.click();

        //Kullanıcı adı girilir
        //Şifre girilir
        //Home page'e gidilir
        String customerEmail = ConfigReader.getProperty("musteriEmail");
        String customerPassword = ConfigReader.getProperty("musteriPassword");
        signUpInPage.userNameTextBoxIbrahim.sendKeys(customerEmail, Keys.TAB, customerPassword, Keys.ENTER);
        ReusableMethods.extentTestInfo("Müsteri hesabına giris yapildi");

        //Search kısmından ürün aratılır
        ReusableMethods.waitForSecond(3);
        String searchProduct = "Vintage Toy Car";
        homePage.searchBoxIbrahim.sendKeys(searchProduct, Keys.ENTER);
        ReusableMethods.waitForSecond(2);
        ReusableMethods.extentTestInfo("Ürün aratildi");

        //doğrulama
        Assert.assertTrue(Driver.getDriver().getTitle().contains(searchProduct));
        ReusableMethods.extentTestPass("Sonuc sayfasinin ürünü icerdigi dogrulandi.");

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }
}
