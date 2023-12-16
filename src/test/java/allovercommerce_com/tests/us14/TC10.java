package allovercommerce_com.tests.us14;

import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.pages.StoreManagerPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC10 {

    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test01() {
        ProductPage alloverPage = new ProductPage();
        StoreManagerPage storeManagerPage = new StoreManagerPage();
        ReusableMethods.extentReportCreate("Fatma",
                "New Product brands eklenebilmeli",
                "New Product Brands eklendiği doğrulanır.");

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
        ReusableMethods.extentTestInfo("Product Seçeneğine tıklandı.");
        //Add New'e tıkla.
        storeManagerPage.addNew.click();

        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForSecond(3);
        ReusableMethods.extentTestInfo("Add New'e tıklandı.");


        //Add New Product Category'e tıklandı.
        storeManagerPage.addNewProductBrands.click();
        ReusableMethods.extentTestInfo("Add New Category'e tıklandı.");


        //Product Brands Name kutusuna bir veri gir.
        storeManagerPage.productBrandName.sendKeys("Opel");
        ReusableMethods.extentTestInfo("Product Brands Name kutusuna bir veri girildi");


        //Add'e tıkla.
        storeManagerPage.add2.click();
        ReusableMethods.extentTestInfo("Add butonuna tıklandı.");


        //"New Product Brands" ekleme yapılabilmeli.
        softAssert.assertTrue(storeManagerPage.opel.isDisplayed());
        ReusableMethods.extentTestInfo("New Product Brands alanından ekleme yapıldığı doğrulanır.");

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();



    }

}



