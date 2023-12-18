package allovercommerce_com.tests.us14;

import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.pages.StoreManagerPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TC02 {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void test01() throws AWTException {

        StoreManagerPage storeManagerPage = new StoreManagerPage();
        ProductPage alloverPage = new ProductPage();
        ReusableMethods.extentReportCreate("Fatma",
                "Ürüne ait büyük fotoğraf eklenebilmeli",
                "Büyük ürün fotoğrafının eklendiği doğrulanır.");


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


        //Big Foto yükle.
       storeManagerPage.bigFoto.click();
        ReusableMethods.extentTestInfo("Big Foto tıklandığı doğrulanır.");


        //Select Files'a tıkla.
        storeManagerPage.selectLoad.click();
        ReusableMethods.extentTestInfo("Select Files'a tıklandığı doğrulanır.");



        //Fotoğraf seç.
        String userHome = System.getProperty("user.home");
        String allPath="\\Onedrive\\Masaüstü\\logo.jpeg.gif";
        String path = userHome + allPath;
        ReusableMethods.uploadFileWithRobot(path);
        ReusableMethods.waitForSecond(5);
        ReusableMethods.extentTestInfo("Fotoğraf seçildi");


        //Ürünün eklendiği doğrula.
       softAssert.assertTrue(storeManagerPage.filterMedia.isDisplayed());
        ReusableMethods.extentTestInfo("Fotoğrafın eklendiği doğrulanır");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();








    }





}

