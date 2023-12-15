package allovercommerce_com.tests.us07;

import allovercommerce_com.pages.ComparePage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 {


    @Test
    public void test01() {  //Positive Scenario-------------------------------------------------------------------------

        HomePage homePage=new HomePage();
        ComparePage comparePage=new ComparePage();
        ProductPage productPage=new ProductPage();

        ReusableMethods.extentReportCreate("duygu",
                "US_07 -Kullanıcı seçtiği ürünleri karşılaştırabilmeli (Compare)",
                "TC_04 -Kullanıcı seçtiği ürünleri karşılaştırma sayfasinda goruntuleyebilimeli ve silebilmeli (Compare)");

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
        //4- Compare POP-UP penceresini kapatmak icin sayfa uzerine bir alana tikla ve
        comparePage.comparePopUp_CloseDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UP penceresini kapatmak icin sayfa uzerine bir alana tiklandi");

        //5- İkinci Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        ReusableMethods.waitForSecond(2);
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(1));
        productPage.addToCompareListDuygu.get(1).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 2. ürün secildi");

        ReusableMethods.waitForSecond(2);

        //6- Compare POP-UP penceresinde Start Compare butonuna tikla
        comparePage.startCompareAllDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UP penceresinde Start Compare butonuna tiklandi");
        //Compare/karsilastirma ANA-SAYFAsinin acildigini dogrula
        Assert.assertTrue(comparePage.comparePageHeadDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinin acildigi dogrulandi");

        //7-Karşılaştırmak İçin Seçilen Ürünlerin Listelendiğini Doğrula
        Assert.assertEquals(comparePage.compareListDuygu.size(),2);
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinda karsilastirmak icin secilen urunlerin listelendigi dogrulandi");
        ReusableMethods.extentTestPass("Secilen urunlerin karsilastirilabildigi dogrulandi");

        //8- Compare ANA-SAYFAsinda eklenmis urunlerin uzerinde bulunan sil (X) butonuna tikla urunleri sil
        comparePage.removeFromCompareListButtonDuygu.click();
        ReusableMethods.waitForSecond(2);
        comparePage.removeFromCompareListButtonDuygu.click();
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinda eklenmis tum urunler silindi");
        //Compare ANA-SAYFAsinda sil(X) butonu ile urunun silindigini dogrula
        Assert.assertTrue(comparePage.noProductsAddedToTheCompareTextDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Compare sayfasinda eklenen tum urunlerin silindigi dogrulandi");

        //9- Compare ANA-SAYFAsindan cikis yapmak icin Home sekmesine tikla
        comparePage.homeButtonDuygu.click();
        ReusableMethods.extentTestPass("Compare Ana sayfasindan cikis yapildi");
        //Ana-Sayfanin acildigini dogrula
        Assert.assertTrue(homePage.electronicsCategoryLinkDuygu.isDisplayed());

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }


}
