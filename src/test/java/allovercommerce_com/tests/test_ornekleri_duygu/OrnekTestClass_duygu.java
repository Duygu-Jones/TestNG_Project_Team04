package allovercommerce_com.tests.test_ornekleri_duygu;

import allovercommerce_com.tests.test_ornekleri_duygu.ornekPages.HomePageTry;
import allovercommerce_com.tests.test_ornekleri_duygu.ornekPages.MyAccountPageTry;
import allovercommerce_com.tests.test_ornekleri_duygu.ornekPages.SignUpInPageTry;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class OrnekTestClass_duygu {


    @Test
    public void test01() {

        //Test icerisinde kullanilacak class'lardan objeler olusturuldu
        HomePageTry homePage = new HomePageTry();
        SignUpInPageTry signUpInPage = new SignUpInPageTry();
        MyAccountPageTry myAccountPage=new MyAccountPageTry();
        Faker faker = new Faker();

        //Rapor olusturmak icin ilk olarak ExtentReport methodu cagrildi ve gerekli parametreler girildi
             //  => 4 adet Parametre var: ( 1)yourName,   2)US_NOveBaslik,    3) TC_NoBaslik )

        ReusableMethods.extentReportCreate("duygu", "US01-Siteye kayit olunabilmeli",
                                        "TC01-Siteye, kullanıcı (Müşteri) olarak kayıt yapılabilmeli (Register)");


        //1	Verilen URL'e git
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
       ReusableMethods.extentTestInfo("Verilen URL'e gidildi");     //TC01 adimlari Info methodu kullanilarak girildi

        //2	Register linkine tıkla
        homePage.registerButton.click();
        ReusableMethods.extentTestInfo("Register linkine tıklandi");

        ReusableMethods.waitForSecond(2);

        //3	Username kutusuna bir kulanıcı adı gir
        signUpInPage.registerUserNameBox.sendKeys(faker.name().username());
        ReusableMethods.extentTestInfo("Username kutusuna bir kulanıcı adı girildi");

        //4	Your Email address kutusuna bir eposta gir
        signUpInPage.registerEmailBox.sendKeys(faker.internet().emailAddress());
        ReusableMethods.extentTestInfo("Your Email address kutusuna bir eposta girildi");

        //5	Password kutusuna şifre gir
        signUpInPage.registerPasswordBox.sendKeys(faker.internet().password());
        ReusableMethods.extentTestInfo("Password kutusuna şifre girildi");

        //6	I agree to the privacy policy kutusunu işaretle
        signUpInPage.registerPolicyBox.click();
        ReusableMethods.extentTestInfo("I agree to the privacy policy kutusunu işaretlendi");

        //7	SIGN UP butonuna tıkla
        signUpInPage.registerSignUpButton.click();
        ReusableMethods.extentTestInfo("SIGN UP butonuna tıklandi");

        //8	Kayıt işleminin gerçekleştiğini doğrula
        if (homePage.signInButton.isDisplayed()){
            ReusableMethods.extentTestPass("Siteye Kayit isleminiz gerceklesti");
            ReusableMethods.waitForSecond(1);
            ReusableMethods.screenShotOfWebElement(signUpInPage.signInButton,"signInButtonElementSS", "duygu"); //WebElement SS methodu kullanildi
        }else {
            ReusableMethods.extentTestFail("Siteye Kayıt işleminiz gerçekleşmedi. Test fail oldu");
            ReusableMethods.waitForSecond(1);
            ReusableMethods.screenShot("singInPageSS", "duygu");    //Full SS methodu kullanildi
        }


        ReusableMethods.extentReportFlush();                        //Rapor'u kayit edebilmek icin flush methodu cagrilir


        Driver.closeDriver();                                       //Driver kapatilir

    }

}
