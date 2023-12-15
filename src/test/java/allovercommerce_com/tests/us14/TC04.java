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

public class TC04 {

    SoftAssert softAssert = new SoftAssert();
    @Test
    public void test01() {
        StoreManagerPage storeManagerPage = new StoreManagerPage();
        ProductPage alloverPage = new ProductPage();
        ReusableMethods.extentReportCreate("Fatma",
                "Product Title kutusuna bir veri girilebilmeli.",
                "Product Title kutusuna bir veri girilebildiği doğrulanır. ");


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
        ReusableMethods.extentTestInfo("Add New'e tıklandı.");


        //Product Title kutusuna bir veri gir.
        storeManagerPage.productTitle.sendKeys("Kitap");
        softAssert.assertTrue(storeManagerPage.productTitle.getText().contains("Kitap"));
        ReusableMethods.extentTestInfo("Product Title kutusuna bir veri girildiği doğrulanır");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }



}
