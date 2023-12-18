package allovercommerce_com.tests.us05;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC01 {

    @Test
    public void test01() {
        HomePage homePage = new HomePage();
        MyAccountPage myAccountPage = new MyAccountPage();
        Faker faker = new Faker();
        ReusableMethods.extentReportCreate("Salih","US05-Kullanıcı Hesap Detaylarını Değiştirebilmeli","TC01-Kullanıcı Hesap Detaylarını Değiştirebilmeli");

        //1	https://allovercommerce.com Sitesine Git ve Login Ol
        homePage.performLoginSalih();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildi ve Log in Olundu");

        //2	My Account Linkine Tıkla
        ReusableMethods.waitForSecond(3);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitForSecond(3);
        homePage.myAccountLinkST.click();

        ReusableMethods.extentTestInfo("My Account Linkine Tıklandı.");

        //3	edit your password and account details Linkine Tıkla
        myAccountPage.editYourPasswordAndAccountDetailsLinkST.click();
        ReusableMethods.extentTestInfo("edit your password and account details Linkine Tıklandı.");

        //4	First name Kutusuna Yeni Değer Gir
        myAccountPage.accountFirstNameBoxST.clear();
        myAccountPage.accountFirstNameBoxST.sendKeys("Sada");
        ReusableMethods.extentTestInfo("First name Kutusuna Yeni Değer Girildi.");

        //5	Last name Kutusuna Yeni Değer Gir
        actions.sendKeys(Keys.TAB).sendKeys("Biri").perform();
        ReusableMethods.extentTestInfo("Last name Kutusuna Yeni Değer Girildi.");

        //6	Display name Kutusuna Yeni Değer Gir
        actions.sendKeys(Keys.TAB).sendKeys("gakky08").perform();
        ReusableMethods.extentTestInfo("Display name Kutusuna Yeni Değer Girildi.");

        //7	Email address Kutusuna Yeni Değer Gir
        actions.sendKeys(Keys.TAB).sendKeys("takumi.burech@falkcia.com").perform();
        ReusableMethods.extentTestInfo("Email address Kutusuna Yeni Değer Girildi.");

        //8	Biography Kutusuna Yeni Değer Gir
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.lorem().paragraph()).perform();
        ReusableMethods.extentTestInfo("Biography Kutusuna Yeni Değer Girildi.");

        //9	Current password Kutusuna Mevcut Parolayı Gir
        actions.sendKeys(Keys.TAB).sendKeys("Alice123456*").perform();
        ReusableMethods.extentTestInfo("Current password Kutusuna Mevcut Parola Girildi.");

        //10	New password Kutusuna Yeni Parola Gir
        actions.sendKeys(Keys.TAB).sendKeys("gakky1234*").perform();
        ReusableMethods.extentTestInfo("New password Kutusuna Yeni Değer Girildi.");

        //11	Confirm password Kutusuna Yeni Parolayı Tekrar Gir
        actions.sendKeys(Keys.TAB).sendKeys("gakky1234*").perform();
        ReusableMethods.extentTestInfo("Confirm password Kutusuna Yeni Parola Tekrar Girildi.");

        //12	Save changes Butonuna Tıkla
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReusableMethods.extentTestInfo("Save changes Butonuna Tıklandı.");

        //13	Account details changed successfully. Yazısının Görünür Olduğunu Doğrula
        String expectedData = "Account details changed successfully.";
        ReusableMethods.verifyData(myAccountPage.accountDetailsChangedSuccessfullyTextST, expectedData);
        ReusableMethods.extentTestInfo("Account details changed successfully. Yazısının Görünür Olduğunu Doğrulandı.");

        ReusableMethods.extentTestPass("Kullanıcı Hesap Detaylarını Değiştirebildi");
        ReusableMethods.extentReportFlush();

        //4	First name Kutusuna Eski Değer Gir
        myAccountPage.accountFirstNameBoxST.clear();
        myAccountPage.accountFirstNameBoxST.sendKeys("Alice");
        //5	Last name Kutusuna Eski Değer Gir
        actions.sendKeys(Keys.TAB).sendKeys("Kerry").perform();

        //	Display name Kutusuna eski  Değer Gir
        ReusableMethods.deleteAll(myAccountPage.accountDisplayNameBoxST);
        myAccountPage.accountDisplayNameBoxST.sendKeys("Alice");


        //7	Email address Kutusuna Eski Değer Gir
        actions.sendKeys(Keys.TAB).sendKeys("jeramyah.alice@falkcia.com").perform();


        //8	Biography Kutusuna Yeni Değer Gir
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.lorem().paragraph()).perform();


        //9	Current password Kutusuna Mevcut Parolayı Gir
        actions.sendKeys(Keys.TAB).sendKeys("gakky1234*").perform();


        //10	New password Kutusuna Eski Parola Gir
        actions.sendKeys(Keys.TAB).sendKeys("Alice123456*").perform();


        //11	Confirm password Kutusuna Eski Parolayı Tekrar Gir
        actions.sendKeys(Keys.TAB).sendKeys("Alice123456*").perform();


        //12	Save changes Butonuna Tıkla
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


         Driver.closeDriver();

    }
}




