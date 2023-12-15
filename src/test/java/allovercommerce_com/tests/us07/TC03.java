package allovercommerce_com.tests.us07;

import allovercommerce_com.pages.ComparePage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 {


    @Test
    public void test01() {  //Positive Scenario-------------------------------------------------------------------------

        HomePage homePage = new HomePage();
        ComparePage comparePage = new ComparePage();
        ProductPage productPage = new ProductPage();


        ReusableMethods.extentReportCreate("duygu",
                "US_07 -Kullanıcı seçtiği ürünleri karşılaştırabilmeli (Compare)",
                "TC_03 -Karsilastirmak icin sectigi urunleri silebilmeli ve yeni urunler ekleyebilmeli (Compare)");

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
        ReusableMethods.waitForSecond(2);

        //4- İkinci Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(1));
        productPage.addToCompareListDuygu.get(1).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 2. ürün secildi");
        ReusableMethods.waitForSecond(2);

        //5- Compare POP-UP penceresinde Start Compare butonuna tikla
        comparePage.startCompareAllDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UP penceresinde Start Compare butonuna tiklandi");
        //Compare/karsilastirma ANA-SAYFAsinin acildigini dogrula
        Assert.assertTrue(comparePage.comparePageHeadDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinin acildigi dogrulandi");

        //6-Karşılaştırmak İçin Seçilen Ürünlerin Listelendiğini Doğrula
        Assert.assertEquals(comparePage.compareListDuygu.size(),2);
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinda karsilastirmak icin secilen urunlerin listelendigi dogrulandi");
        ReusableMethods.extentTestPass("Secilen urunlerin karsilastirilabildigi dogrulandi");

        //7- Compare SAYFAsinda eklenmis urunlerin uzerinde bulunan sil (X) butonuna tikla ve urunleri sil
        comparePage.removeFromCompareListButtonDuygu.click();
        ReusableMethods.waitForSecond(2);
        comparePage.removeFromCompareListButtonDuygu.click();
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinda 2 adet urun silindi");
        ReusableMethods.waitForSecond(2);

        //8- Karsilastirmak icin ana sayfaya don ve yeni urunler ekle
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(0));
        productPage.addToCompareListDuygu.get(0).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 1. urun secildi");
        ReusableMethods.waitForSecond(2);

        //9-Karsilastirmak icin ana sayfaya don ve yeni urunler ekle
        Driver.getDriver().navigate().refresh();
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(1));
        productPage.addToCompareListDuygu.get(1).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 2.urun secildi");
        ReusableMethods.waitForSecond(2);

        //10-Karsilastirmak icin ana sayfaya don ve yeni urunler ekle
        Driver.getDriver().navigate().refresh();
        ReusableMethods.actionScrollDown();
        ReusableMethods.waitForSecond(2);
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(3));
        productPage.addToCompareListDuygu.get(3).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 3.urun secildi");
        ReusableMethods.waitForSecond(2);

        //11- Compare POP-UP penceresinde Start Compare butonuna tikla
        comparePage.startCompareAllDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UP penceresinde Start Compare butonuna tiklandi");
        //Compare/karsilastirma ANA-SAYFAsinin acildigini dogrula
        Assert.assertTrue(comparePage.comparePageHeadDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinin acildigi dogrulandi");
        ReusableMethods.waitForSecond(2);

        //12-Karşılaştırmak İçin Seçilen Ürünlerin Listelendiğini Doğrula
        Assert.assertEquals(comparePage.compareListDuygu.size(),3);
        ReusableMethods.extentTestInfo("Karsilastirma SAYFAsinda secilen urunlerin listelendigi dogrulandi");
        ReusableMethods.extentTestPass("Secilen urunlerin karsilastirilabildigi dogrulandi");

        ReusableMethods.actionScrollDown();
        ReusableMethods.waitForSecond(2);

        ReusableMethods.actionScrollUp();
        ReusableMethods.waitForSecond(2);

        //13- Compare ANA-SAYFAsindan cikis yapmak icin Home sekmesine tikla
        comparePage.homeButtonDuygu.click();
        ReusableMethods.extentTestPass("Compare Ana sayfasindan cikis yapildi");
        //Ana-Sayfanin acildigini dogrula
        Assert.assertTrue(homePage.electronicsCategoryLinkDuygu.isDisplayed());

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();


    }





}
