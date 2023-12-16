package allovercommerce_com.tests.us09;



import allovercommerce_com.pages.OrdersPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class TC01 {
    ReusableMethods reusableMethods = new ReusableMethods();
    SignUpInPage signUpInPage=new SignUpInPage();
    @Test
    public void TC01() throws InterruptedException {
        ReusableMethods.extentReportCreate("Muammer","US09-Vendor (Satıcı) olarak, siteye kayıt yapılabilmeli(Vendor Registration)","TC01 Kayıtlı olmayan bir e-mail adresi ile Vendor olarak siteye kayıt yapılabilmeli");

//      Verilen URL'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen URL'e gidildi");

//      Register linkine tıklanır
        signUpInPage.registerMU.click();
        ReusableMethods.extentTestInfo("Register linkine tıklandı");

//      Become a Vendor butonuna tıklanır
        signUpInPage.BecomeAVendorMU.click();
        ReusableMethods.extentTestInfo("Become a Vendor butonuna tıklandı");

//      E-mail kutusuna bir eposta girilir
        Driver.getDriver().get(ConfigReader.getProperty("fakemailUrl"));
        String fakemail=Driver.getDriver().findElement(By.id("email")).getText();
        Driver.getDriver().navigate().back();
        signUpInPage.emailBoxMU.sendKeys(fakemail);
        ReusableMethods.extentTestInfo("E-mail kutusuna bir eposta girildi");

//      Verification Code butonuna tıklanır
        signUpInPage.verificationCodeButtonMU.click();
        Driver.getDriver().navigate().forward();
        Thread.sleep(10000);
        signUpInPage.fakeMailButtonMU.click();
        ReusableMethods.extentTestInfo("Verification Code butonuna tıklandı");

//      Mail adresine gelen kod Verification Code kutusuna girilir
        String verificationCodeCamingToFakemailFromAlloverCommmence=signUpInPage.fakemailVerificationCodeMU.getText();
        Thread.sleep(2000);
        Driver.getDriver().navigate().back();
        Thread.sleep(3000);
        String words = verificationCodeCamingToFakemailFromAlloverCommmence.trim().split(" ")[6];
        signUpInPage.verificationCodeButtonMU.sendKeys(words);
        ReusableMethods.extentTestInfo("Mail adresine gelen kod Verification Code kutusuna girildi");

//      Password kutusuna şifre girilir
        WebElement password =signUpInPage.passwordBoxAlloverCommerMU;
        password.sendKeys("vendor123.");
        ReusableMethods.extentTestInfo("Password kutusuna şifre girildi");

//      Confirm Password  kutusuna aynı şifre tekrar girilir ve Register butonuna tıklanır
        WebElement confirmPassword =Driver.getDriver().findElement(By.xpath("//input[@id='confirm_pwd']"));
        confirmPassword.sendKeys("vendor123.", Keys.ENTER);
        ReusableMethods.extentTestInfo("Confirm Password  kutusuna aynı şifre tekrar girildi ve Register butonuna tıklandı");

//      Kayıt yapıldığı doğrulanır
        Driver.getDriver().findElement(By.xpath("//h1[text()='Welcome to Allover Commerce!']")).isDisplayed();
        ReusableMethods.extentTestPass("Kayıt yapıldığı doğrulandı");

//      sayfayı kapatalim
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();
    }
}
