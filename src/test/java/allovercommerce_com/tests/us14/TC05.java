package allovercommerce_com.tests.us14;

import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.pages.StoreManagerPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC05 {

    SoftAssert softAssert = new SoftAssert();



    @Test
    public void test01() {
        ProductPage alloverPage = new ProductPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();
        ReusableMethods.extentReportCreate("Fatma",
                "Short Description alanına bir metin girilebilmeli..",
                "Short Description alanına bir metin girilebildiği doğrulanır. ");

        //https://allovercommerce.com Sitesine Git.
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Driver.getDriver().navigate().refresh();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildi.");


        //Sign in'e tıkla.
        alloverPage.signIn.click();
        ReusableMethods.extentTestInfo("Sign in'e tıklandı.");


        //E-mail address gir.
        String storeManagerEmail = ConfigReader.getProperty("storeManagerMail");
        alloverPage.userName1.sendKeys(storeManagerEmail);
        ReusableMethods.extentTestInfo("E-mail address girildi.");

        //Password gir.
        String storeManagerPassword = ConfigReader.getProperty("storeManagerPassword");
        alloverPage.password1.sendKeys(storeManagerPassword, Keys.TAB);
        ReusableMethods.extentTestInfo("Password girildi.");

        //Signİn'e tıkla.
        alloverPage.signInol.click();
        ReusableMethods.extentTestInfo("Sign in'e tıklandı.");

        //Sign Out'a tıkla.
        alloverPage.signout1.click();
        ReusableMethods.extentTestInfo("Sign Out'a tıklandı.");

        //Store Manager'a tıkla.
        storeManagerPage.storeManager.click();
        ReusableMethods.extentTestInfo("Store Manager'a tıklandı.");

        //Product seçeneğine tıkla.
        storeManagerPage.product.click();
        ReusableMethods.extentTestInfo("Product Seçeneğine tıklandı..");

        //Add New'e tıkla.
        storeManagerPage.addNew.click();
        storeManagerPage.addNew.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB);
        ReusableMethods.extentTestInfo("Add New'e tıklandı.");

        //İframe geç.
        Driver.getDriver().switchTo().frame("excerpt_ifr");
        ReusableMethods.extentTestInfo("Iframe'e gecildi.");



        //"Short Description" alanına bir metin gir.
        storeManagerPage.shortDescription.sendKeys("How are you,today?");
        ReusableMethods.extentTestInfo("Short Description alanına bir metin girildi.");

         //"Short Description" alanına bir metin girildiğini doğrula.
        softAssert.assertTrue(storeManagerPage.shortDescription.getText().contains("How are you,today"));
        ReusableMethods.extentTestInfo("Short Description alanına bir metin girildiği doğrulanır.");

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();







    }





}
