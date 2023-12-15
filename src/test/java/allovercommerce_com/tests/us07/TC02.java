package allovercommerce_com.tests.us07;

import allovercommerce_com.pages.ComparePage;
import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 {


    @Test
    public void test01() {  //Positive Scenario-------------------------------------------------------------------------

        HomePage homePage = new HomePage();
        ComparePage comparePage = new ComparePage();
        ProductPage productPage = new ProductPage();


        ReusableMethods.extentReportCreate("duygu",
                "US_07 || Kullanıcı seçtiği ürünleri karşılaştırabilmeli (Compare)",
                "TC_02 || Karşılaştırmak icin sectigi urunleri Pop-Up penceresinden silebilmeli");

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

        ReusableMethods.screenShot("ComparePopUpSlideBar","duygu");

        //Karsilastirma POP-UP penceresinde 4 adet secili urunden en sagdaki urunu silmek icin pencere alt bar cubugunu saga kaydır
        Actions actions=new Actions(Driver.getDriver());
        actions.clickAndHold(comparePage.comparePopUpSlideBarDuygu).moveByOffset(-5,0).release().perform();
        ReusableMethods.waitForSecond(2);

        //Karsilastirma POP-UP penceresinde 4.urunu sil
        comparePage.removeFromComparePopUpDuygu.get(3).click();

        //11- Compare POP-UP penceresinde Start Compare butonuna tikla
        comparePage.startCompareAllDuygu.click();
        ReusableMethods.extentTestInfo("Compare POP-UP penceresinde Start Compare butonuna tiklandi");
        //Compare/karsilastirma ANA-SAYFAsinin acildigini dogrula
        Assert.assertTrue(comparePage.comparePageHeadDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Compare ANA-SAYFAsinin acildigi dogrulandi");
        ReusableMethods.waitForSecond(2);

        //12-Karşılaştırmak İçin Seçilen Ürünlerin Listelendiğini Doğrula
        int expectedResult=3;                                   // Kıyaslama için 3 adet ürün kaldi
        int actualResult=comparePage.compareListDuygu.size();
        Assert.assertNotEquals(actualResult,expectedResult);
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
