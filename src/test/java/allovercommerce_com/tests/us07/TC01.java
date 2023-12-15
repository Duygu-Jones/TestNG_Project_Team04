package allovercommerce_com.tests.us07;

import allovercommerce_com.pages.ComparePage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC01 {

    //-------US_07 acceptance criteria---//
    //Kullanıcı en fazla 4 ürünü karşılaştırmak için seçebilmeli +tc1
    //Karşılaştıracağı ürünleri silip yeni ürünleri ekleyebilmeli +tc3
    //Seçtiği ürünleri karşılaştırabilmeli + tc2
    //Katşılatırma ekranından ürünleri silebilmeli +tc2

    @Test
    public void test01() {  //Positive Scenario-------------------------------------------------------------------------




        HomePage homePage=new HomePage();
        ComparePage comparePage=new ComparePage();
        ProductPage productPage=new ProductPage();


        ReusableMethods.extentReportCreate("US_07_duygu",
                                            "US_07 -Kullanıcı seçtiği ürünleri karşılaştırabilmeli (Compare)",
                                            "TC_01 -Kullanıcı seçtiği ürünleri karsilastirma Pop-up penceresinde goruntuleyebilmeli");

        //1- https://allovercommerce.com/  adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen URL'ye gidildi");

        //2- Karşılaştırma Yapmak İçin Kategori Seç
        homePage.electronicsCategoryLinkDuygu.click();
        ReusableMethods.extentTestInfo("Karşılaştırma yapmak için kategori seçildi");

        //3- Birinci Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(0));
        productPage.addToCompareListDuygu.get(0).click();
        ReusableMethods.extentTestInfo("gelen ilk urunun uzerinde bulunan 'Compare' iconuna tiklandi");
        //Compare POP-UP penceresinin secili urun ile acildigini dogrula
        Assert.assertTrue(comparePage.comparePopUpWindowDuygu.isDisplayed());
        ReusableMethods.extentTestInfo("Compare POP-UP penceresinin secili urun ile acildigi dogrulanir");
        ReusableMethods.extentTestPass("Compare Pop-Up penceresi secili urunler ile acildi");

        ReusableMethods.waitForSecond(2);

        //4- Compare POP-UP penceresini kapatmak icin sayfa uzerine bir alana tikla ve
        comparePage.comparePopUp_CloseDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UP penceresini kapatmak icin sayfa uzerine bir alana tiklandi");

        //5- İkinci Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        ReusableMethods.waitForSecond(2);
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(1));
        productPage.addToCompareListDuygu.get(1).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 2. ürün secildi");
        ReusableMethods.waitForSecond(2);
        //Secilen urunlerin compare Pop-Up penceresinde goruntulendigini dogrula
        Assert.assertEquals(comparePage.comparePopUp_ProductsList.size(),2);
        ReusableMethods.extentTestPass("Secilen urunlerin compare Pop-Up penceresinde goruntulendigini dogrula");

        ReusableMethods.waitForSecond(2);

        //6- Compare POP-UPpenceresinden secilen tum urunleri sil; Clean All butonuna tikla
        comparePage.cleanAllComparePopUpDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UPpenceresinden secilen tum urunleri sil; Clean All butonuna tiklandi");

        ReusableMethods.waitForSecond(2);

        //7- Compare POP-UP penceresini kapatmak icin sayfa uzerine bir alana tikla ve
        comparePage.comparePopUp_CloseDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UP penceresini kapatmak icin sayfa uzerine bir alana tiklandi");

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }







}
