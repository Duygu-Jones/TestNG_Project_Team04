package allovercommerce_com.tests.us08;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.pages.WishlistPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 {

    //-------US_08 acceptance criteria---
    //Kullanıcı beğendiği ürünleri wishlist'e ekleyebilmeli+
    //Wishlist'e eklediği ürünleri görebilmeli+
    //Wishlistteki ürünlerin özelliklerini görüntüleyebilmeli (QUICK VIEW)+
    //Whishlisteki ürünü sepete ekleyebilmeli ve satın alabilmeli



    @Test
    public void test01() {  //Positive Scenario-------------------------------------------------------------------------

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        WishlistPage wishlistPage=new WishlistPage();
        Actions actions=new Actions(Driver.getDriver());


        ReusableMethods.extentReportCreate("duygu",
                "US_08 || Kullanıcı seçtiği ürünleri istek listesine ekleyebilmeli (WhishList)",
                "TC_05 || Istek Listesine urun ekleyebilmeli ve ekledigi urunleri goruntuleyebilmeli (WhishList)");

        //1- https://allovercommerce.com/  adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        ReusableMethods.extentTestInfo("Verilen URL'ye gidildi");

        //2- Istek Listesine eklemek İçin Kategori Seç
        homePage.homeAndGardenCategoryLink.click();
        ReusableMethods.extentTestInfo("Home and Garden Urunler kategorisi seçildi");

        //3- Birinci Ürün Üzerine Gel ve Wishlist  Simgesine Tıkla
        actions.moveToElement(productPage.addToWishlistListDuygu.get(0)).perform();
        productPage.addToWishlistListDuygu.get(0).click();
        ReusableMethods.extentTestInfo("1. urunun uzerinde bulunan 'WishList' iconuna tiklandi");

        ReusableMethods.waitForSecond(2);

        //5- Wishliste eklenen urunu goruntulemek icin sayfanin sag ust kosesinde Wishlist butonuna tıkla ve
        productPage.wishlistButtonDuygu.click();
        ReusableMethods.extentTestInfo("Wishlist Butonuna Tıklandi");

        //6- Wishlist sayfasinin acildigini dogrula
        Assert.assertTrue(wishlistPage.wishlistPageHeadLineDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Wishlish sayfasinin acildigi dogrulandi");
        ReusableMethods.waitForSecond(2);

        //7- Wishliste eklenen urunun ozelliklerini goruntuleyebilmek icin yaninda bulunan Quickview butonu tıklar
        ReusableMethods.actionScrollDown();
        wishlistPage.quickViewButtonDuygu.get(0).click();
        ReusableMethods.extentTestInfo("Wishlist sayfasina eklenen urun ozelliklerini goruntulemek icin Quickview butonuna tiklandi ");

        //8- Quickview pop-up sayfasinda goruntulenen urunu sepete eklemek icin Add To Cart butonuna tiklar ve
        wishlistPage.quickViewAddToCartButtonDuygu.click();
        ReusableMethods.extentTestInfo("QuickView popup penceresinde acilan urun sepete eklendi");

        //Urunun sepete eklendigini dogrulayan checkout penceresinin goruntulendigini dogrula
        ReusableMethods.screenShot("ComPopupAddedToCart","duygu");
        ReusableMethods.extentTestPass("QuickView Checkout PopUp ile urunun sepete eklendigini gosteren mesajinin enkran goruntusu alindi");
        ReusableMethods.waitForSecond(2);

        //9- Quickview pop-up sayfasini kapatmak icin sag-ust kosede bulunan Kapat (X) iconuna tiklar
        wishlistPage.quickViewPopUpCloseDuygu.click();
        ReusableMethods.extentTestInfo("QuickView popup penceresi kapatildi");

        ReusableMethods.waitForSecond(4);

        //10- Wishlist sayfasindan bir urunu sepete eklemek icin "Add To Cart" butonuna tiklar ve
        wishlistPage.wishlistAddToCartButtonDuygu.click();
        ReusableMethods.extentTestInfo("Wishlist sayfasindan urunu sepete eklemek icin Add To Cart butonuna tiklandi");

        ReusableMethods.waitForSecond(3);

        //11- Urunun sepete eklendigini dogrula;  ( “Blue Ski Boots” has been added to your cart.) mesajinin goruntulendigini dogrula
        String expectedTextMessage="VIEW CART “Blue Ski Boots” has been added to your cart.";
        String actualTextMessage= wishlistPage.wishlistSepeteEklendiMesajiDuygu.getText();
        Assert.assertEquals(actualTextMessage,expectedTextMessage);
        ReusableMethods.extentTestPass("Wishlist sayfasindan Urunun sepete eklendigi dogrulandi");

        ReusableMethods.waitForSecond(2);

        ReusableMethods.extentReportFlush();
        Driver.closeDriver();

    }

}
