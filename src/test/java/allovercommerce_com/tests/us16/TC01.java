package allovercommerce_com.tests.us16;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.pages.StoreManagerPage;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {

    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Faker faker = new Faker();


    @Test
    public void test01() throws InterruptedException {

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
        Thread.sleep(3000);
        //Categories ten araba seçilir
        ReusableMethods.jsClick(storeManagerPage.categoriesFk);
        Assert.assertTrue(storeManagerPage.categoriesFk.isSelected());
        ReusableMethods.extentTestInfo("Categories kısmına tıklanır");

        ReusableMethods.jsClick(storeManagerPage.featuredImgFk);
        ReusableMethods.jsClick(storeManagerPage.mediaLibraryFk);
        ReusableMethods.jsClick(storeManagerPage.firstImageFk);
        ReusableMethods.jsClick(storeManagerPage.selectFk);
        Assert.assertTrue(storeManagerPage.featuredImgFk.isEnabled());

        ReusableMethods.jsClick(storeManagerPage.galleryImagesFk);
        ReusableMethods.jsClick(storeManagerPage.secondImageFk);
        ReusableMethods.jsClick(storeManagerPage.addToGalleryFk);
        Assert.assertTrue(storeManagerPage.galleryImagesFk.isEnabled());

        ReusableMethods.jsScroll(storeManagerPage.submitFk);
        ReusableMethods.jsClick(storeManagerPage.submitFk);

        ReusableMethods.jsScroll(storeManagerPage.searchBoxFk);
        ReusableMethods.jsSendKeys(storeManagerPage.searchBoxFk,"ToyCar"+Keys.ENTER);






    }
}
