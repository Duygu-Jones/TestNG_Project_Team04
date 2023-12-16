package allovercommerce_com.tests.us16;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.StoreManagerPage;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;

public class TC01 {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Faker faker = new Faker();


    @Test
    public void test01() throws InterruptedException, AWTException {
        ReusableMethods.extentReportCreate("Furkan", "US16","TC01");
        //Verilen URL'e gidilir Sign In linkine tıklanır Username or email address kutusuna eposta adresini girilir
        // SIGN IN butonuna tıklanır
        HomePage.vendorLogginFk();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildilir");

        //My Account butonuna tıklanır
        actions.scrollToElement(homePage.myAccountFk).perform();
        ReusableMethods.jsClick(homePage.myAccountFk);
        ReusableMethods.extentTestInfo("My Account Linkine Tıklanır");

        //Store Manager butonuna tıklanır
        myAccountPage.storeManagerFk.click();
        ReusableMethods.extentTestInfo("Store Manager Linkine Tıklanır");
        ReusableMethods.waitForInVisible(myAccountPage.storeManagerFk,15);

        //Products butonuna tıklanır
        storeManagerPage.productFk.click();
        ReusableMethods.extentTestInfo("Products a tıklanır.");

        //Add New butonuna tıklanır
        storeManagerPage.addNewFk.click();
        ReusableMethods.extentTestInfo("Add new butonuna tıklanır.");

        ReusableMethods.jsScroll(storeManagerPage.necessaryScrollFK);


        //Virtual  kutucusu işaretlenir
        storeManagerPage.virtualBoxFk.click();
        ReusableMethods.extentTestInfo("Virtual kutusu seçilir");

        //Product Title'a veri girilir
        //Price sütununa veri girilir
        //Sale price sütununa veri girilir
        storeManagerPage.productTitleFk.sendKeys("ToyCar" , Keys.TAB , "200.000" , Keys.TAB , "150.000");
        ReusableMethods.extentTestInfo("Product Title, Price, Sale Price kısımları doldurulur");
        ReusableMethods.waitForSecond(3);

        //Categories ten araba seçilir
        ReusableMethods.jsClick(storeManagerPage.categoriesFk);
        Assert.assertTrue(storeManagerPage.categoriesFk.isSelected());
        ReusableMethods.extentTestInfo("Categories kısmına tıklanır");
        //Featured Image (sağdaki büyük resim kutusu) seçeneğine tıklanır
        ReusableMethods.jsClick(storeManagerPage.featuredImgFk);
        ReusableMethods.extentTestInfo("Featured Image (sağdaki büyük resim kutusu) seçeneğine tıklanır");

        //Choose Image sayfasında Upload files linkine tıklanır
        ReusableMethods.jsClick(storeManagerPage.selectFilesButtonFK);
        ReusableMethods.extentTestInfo("Choose Image sayfasında Upload files linkine tıklanır");

        //Ürün resmini seç ve SELECT butonuna tıklanır
        String path="C:\\Users\\hpvic\\OneDrive\\Masaüstü\\aaapicture.webp";
        ReusableMethods.uploadFileWithRobot(path);
        ReusableMethods.waitForSecond(3);
        ReusableMethods.jsClick(storeManagerPage.selectFk);
        ReusableMethods.extentTestInfo("Ürün resmini seç ve SELECT butonuna tıklanır");
        //Gallery Image(sağdaki küçük resim kutusu) seçeneğine tıklanır
        ReusableMethods.jsClick(storeManagerPage.galleryImagesFk);
        ReusableMethods.extentTestInfo("Gallery Image(sağdaki küçük resim kutusu) seçeneğine tıklanır");
        //Choose Image sayfasında Upload files linkine tıklanır
        ReusableMethods.jsClick(storeManagerPage.uploadFilesFk);
        ReusableMethods.extentTestInfo("Choose Image sayfasında Upload files linkine tıklanır");
        //SELECT FILES butonuna tıklanır
        ReusableMethods.jsClick(storeManagerPage.selectFilesButton2Fk);
        ReusableMethods.extentTestInfo("SELECT FILES butonuna tıklanır");

        //Ürün resmi seçilir ve ADD TO GALLERY butonuna tıklanır
        String path2="C:\\Users\\hpvic\\OneDrive\\Masaüstü\\aaapicture2.webp";
        ReusableMethods.uploadFileWithRobot(path2);
        ReusableMethods.waitForSecond(3);
        ReusableMethods.jsClick(storeManagerPage.addToGalleryFk);
        ReusableMethods.extentTestInfo("Ürün resmi seçilir ve ADD TO GALLERY butonuna tıklanır");
        //SUBMIT butonuna basılır
        ReusableMethods.jsScroll(storeManagerPage.scrollEnd);
        ReusableMethods.jsClick(storeManagerPage.submitFk);
        ReusableMethods.extentTestInfo("SUBMIT butonuna basılır");
        ReusableMethods.waitForSecond(5);
        //Ürün arama kısmında ismi ile aratılır
        ReusableMethods.jsScroll(storeManagerPage.searchBoxFk);
        ReusableMethods.jsSendKeys(storeManagerPage.searchBoxFk,"ToyCar");
        ReusableMethods.extentTestInfo("Ürün arama kısmında ismi ile aratılır");
        //Ürünün PRODUCTS kısmında olduğu doğrulanır
        ReusableMethods.jsClick(storeManagerPage.searchButton);
        ReusableMethods.extentTestInfo("Ürünün PRODUCTS kısmında olduğu doğrulanır");
        ReusableMethods.extentTestPass("Ürün başarılı bir şekilde eklendi");
        ReusableMethods.extentReportFlush();
        ReusableMethods.waitForSecond(3);
        ReusableMethods.screenShot("uploadedCar","Furkan");
        Driver.getDriver().close();
        




    }
}
