package allovercommerce_com.tests.us07;

import allovercommerce_com.pages.ComparePage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05 {

    @Test
    public void test01() {  //Negative Scenario-------------------------------------------------------------------------

        HomePage homePage = new HomePage();
        ComparePage comparePage = new ComparePage();
        ProductPage productPage = new ProductPage();


        ReusableMethods.extentReportCreate("duygu",
                "US_07 -Kullanıcı seçtiği ürünleri karşılaştırabilmeli (Compare)",
                "TC_05 -karşılaştırmak icin 4 adetten Fazla urun secimi Yapilamamali (Can Not Compare)");

        //1- https://allovercommerce.com/  adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen URL'ye gidildi");

        //2- Karşılaştırma Yapmak İçin Kategori Seç
        homePage.electronicsCategoryLinkDuygu.click();
        ReusableMethods.extentTestInfo("Karşılaştırma yapmak için kategori seçildi");

        //3- Karsilatirmak icin 5 adet urun sec;

        //Birinci Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(0));
        productPage.addToCompareListDuygu.get(0).click();
        ReusableMethods.extentTestInfo("gelen ilk urunun uzerinde bulunan 'Compare' iconuna tiklandi");


        //4- İkinci Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitForSecond(2);
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(1));
        productPage.addToCompareListDuygu.get(1).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 2. ürün secildi");
        ReusableMethods.waitForSecond(2);

        //5- Ucuncu Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.actionScrollDown();
        ReusableMethods.waitForSecond(2);
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(3));
        productPage.addToCompareListDuygu.get(3).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 3. ürün secildi");
        ReusableMethods.waitForSecond(2);

        //6- Dorduncu Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.actionScrollDown();
        ReusableMethods.actionScrollDown();
        ReusableMethods.waitForSecond(2);
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(5));
        productPage.addToCompareListDuygu.get(5).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 4. ürün secildi");
        ReusableMethods.waitForSecond(2);

        //7- Besinci Ürün Üzerine Gel ve Compare  Simgesine Tıkla
        Driver.getDriver().navigate().refresh();
        ReusableMethods.actionScrollDown();
        ReusableMethods.waitForSecond(2);
        ReusableMethods.actionComeOnTheElement(productPage.addToCompareListDuygu.get(6));
        productPage.addToCompareListDuygu.get(6).click();
        ReusableMethods.extentTestInfo("Karsilastirmak icin 5. ürün secildi");
        ReusableMethods.waitForSecond(2);

        //8- Compare POP-UP penceresinde Start Compare butonuna tikla
        comparePage.startCompareAllDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UP penceresinde Start Compare butonuna tiklandi");
        //Compare/karsilastirma ANA-SAYFAsinin acildigini dogrula
        Assert.assertTrue(comparePage.comparePageHeadDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinin acildigi dogrulandi");
        ReusableMethods.waitForSecond(2);


        ReusableMethods.actionScrollDown();
        ReusableMethods.waitForSecond(2);

        ReusableMethods.screenShot("CompareProducts","duygu");
        ReusableMethods.extentTestInfo("Karsilastirmak icin eklenen tum urunlerin listeye eklenmedigini gosteren ekran goruntusu alindi");
        ReusableMethods.actionScrollUp();
        ReusableMethods.waitForSecond(2);


        //9-Karşılaştırmak İçin Seçilen Tum Ürünlerin Listelenmediğini Doğrula
        int expectedResult=5;                                   // Kıyaslama için 5 adet ürün secildi
        int actualResult=comparePage.compareListDuygu.size();
        Assert.assertNotEquals(actualResult,expectedResult);
        ReusableMethods.extentTestPass("5 adet seçilen ürünlerden 4 adedinin karsilastirma sayfasinda listelendiği doğrulandı");


        //10- Compare ANA-SAYFAsindan cikis yapmak icin Home sekmesine tikla
        comparePage.homeButtonDuygu.click();
        ReusableMethods.extentTestPass("Compare Ana sayfasindan cikis yapildi");
        //Ana-Sayfanin acildigini dogrula
        Assert.assertTrue(homePage.electronicsCategoryLinkDuygu.isDisplayed());

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }


}
