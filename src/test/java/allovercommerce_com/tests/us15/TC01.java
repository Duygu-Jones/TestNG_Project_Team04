package allovercommerce_com.tests.us15;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.pages.StoreManagerPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {

    HomePage homePage = new HomePage();
    SignUpInPage signUpInPage = new SignUpInPage();
    Actions actions = new Actions(Driver.getDriver());
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Faker faker = new Faker();


    @Test
    public void test01() throws InterruptedException {

        ReusableMethods.extentReportCreate("Furkan", "US15","TC01");

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

        //Inventory, Shipping, Attributes, Linked, Seo, Advanced menülerinin görüldüğü doğrulanır
        ReusableMethods.jsScroll(storeManagerPage.scrollEnd);
        Assert.assertTrue(storeManagerPage.inventoryFk.isDisplayed());
        Assert.assertTrue(storeManagerPage.shippingFk.isDisplayed());
        Assert.assertTrue(storeManagerPage.atteributesFk.isDisplayed());
        Assert.assertTrue(storeManagerPage.linkedFk.isDisplayed());
        Assert.assertTrue(storeManagerPage.seoFk.isDisplayed());
        Assert.assertTrue(storeManagerPage.advencedFk.isDisplayed());
        ReusableMethods.extentTestInfo("Inventory, Shipping, Attributes, Linked, Seo, Advanced menülerinin görüldüğü doğrulanır");

        storeManagerPage.skuFk.sendKeys(faker.number().digits(2));
        ReusableMethods.extentTestInfo("Sku sütununa veri girilir.");

        //Sku alanına veri girildiği doğrulanır
        Assert.assertTrue(storeManagerPage.skuFk.isEnabled(),"SKU kutusuna veri girildi");
        ReusableMethods.extentTestInfo("Sku sürununa veri girildiği doğrulanır");

        //Manage Stock kutusuna tıklanır ve Stock Qty adet girilir
        ReusableMethods.jsClick(storeManagerPage.manageStockCheckBoxFk);
        //storeManagerPage.manageStockCheckBoxFk.click();
        ReusableMethods.extentTestInfo("Manage Stock kutusuna tıklanır");
        ReusableMethods.waitForSecond(3);
        storeManagerPage.stockQtyCheckBoxFk.clear();
        storeManagerPage.stockQtyCheckBoxFk.sendKeys(faker.number().digits(5));
        ReusableMethods.extentTestInfo("Stock Qty adet girilir");

        //Allowbackorders kısmında allow seçeneği seçilir
        ReusableMethods.jsClick(storeManagerPage.allowBackorders);
        ReusableMethods.ddmIndex(storeManagerPage.allowBackorders,2);
        storeManagerPage.allowBackorders.click();
        ReusableMethods.extentTestInfo("Allowbackorders kısmında allow seçeneği seçilir");

        //Sold Individually seçeneğine tıklanır
        if (!storeManagerPage.soldCheckboxFk.isSelected()){

        ReusableMethods.jsClick(storeManagerPage.soldCheckboxFk);

        }
        ReusableMethods.extentTestInfo("Sold Individually seçeneğine tıklanır");

        ReusableMethods.waitForSecond(3);

        //Sold Individually kutusunun seçildiğini doğrulanır
        Assert.assertTrue(storeManagerPage.soldCheckboxFk.isSelected());
        ReusableMethods.extentTestInfo("Sold Individually kutusunun seçildiğini doğrulanır");


        //Shipping seçeneğine tıklayınız seçeneğine tıklanır
        ReusableMethods.jsScroll(storeManagerPage.scrollEnd);
        ReusableMethods.jsClick(storeManagerPage.shippingFk);
        ReusableMethods.extentTestInfo("Shipping seçeneğine tıklayınız seçeneğine tıklanır");

        //Weight sütununa veri girilir
        storeManagerPage.weightFk.sendKeys(faker.number().digits(3));
        ReusableMethods.jsClick(storeManagerPage.shippingFk);
        ReusableMethods.extentTestInfo("Weight sütununa veri girilir");

        //Dimensions kısmına sırasıyla verileri girilir
        storeManagerPage.lengthFk.sendKeys(faker.number().digits(2),Keys.TAB,
                faker.number().digits(2),Keys.TAB,faker.number().digits(2));
        ReusableMethods.extentTestInfo("Dimensions kısmına sırasıyla verileri girilir");


        //Shipping class seçeneğine tıklanır
        ReusableMethods.jsClick(storeManagerPage.shippingFk);
        ReusableMethods.ddmVisibleText(storeManagerPage.shippingClassFk,"No shipping class");
        ReusableMethods.jsClick(storeManagerPage.shippingFk);
        ReusableMethods.extentTestInfo("Shipping class seçeneğine tıklanır");

        //1-2 business days seçeneği seçilir
        ReusableMethods.jsClick(storeManagerPage.processingTimeFk);
        ReusableMethods.ddmIndex(storeManagerPage.processingTimeFk,5);
        storeManagerPage.processingTimeFk.click();
        Assert.assertTrue(storeManagerPage.processingTimeFk.isEnabled(),"Ready to ship in... görülmez");
        ReusableMethods.extentTestInfo("1-2 business days seçeneği seçilir");

        ReusableMethods.jsScroll(storeManagerPage.scrollEnd);

        ReusableMethods.waitForSecond(3);

        //Color kutusuna tıklanır
        ReusableMethods.jsClick(storeManagerPage.attributeFk);
        ReusableMethods.jsClick(storeManagerPage.colorFk);
        Assert.assertTrue(storeManagerPage.colorFk.isSelected());
        ReusableMethods.extentTestInfo("Color kutusuna tıklanır");


        //Black seçeneği seçilir
        storeManagerPage.colorDdmFk.click();
        storeManagerPage.colorDdmFk.sendKeys("Black",Keys.TAB,Keys.ENTER);
        Assert.assertTrue(storeManagerPage.colorDdmFk.isEnabled(),"Black seçeneği görülür");
        ReusableMethods.extentTestInfo("Black seçeneği seçilir");

        ReusableMethods.waitForSecond(3);


        //Attributes seçeneğine tıklayınız
        ReusableMethods.jsClick(storeManagerPage.attributeFk);

        //Size kutusuna tıklanır
        ReusableMethods.jsClick(storeManagerPage.sizeFk);
        Assert.assertTrue(storeManagerPage.sizeFk.isSelected());
        ReusableMethods.extentTestInfo("Attributes seçeneğine tıklanır");
        ReusableMethods.extentTestInfo("Size kutusuna tıklanır");

        //Large seçeneği seçilir
        storeManagerPage.ddmSizeFk.sendKeys("Large",Keys.TAB,Keys.ENTER);
        Assert.assertTrue(storeManagerPage.colorDdmFk.isEnabled(),"Large seçeneği görülür");
        ReusableMethods.extentTestInfo("Large seçeneği seçilir");

        ReusableMethods.extentTestPass("Vendor olarak ürün ekleme seçeneklerini görebilmeli 2 testi geçti");
        ReusableMethods.extentReportFlush();
        Driver.getDriver().close();

    }
}
