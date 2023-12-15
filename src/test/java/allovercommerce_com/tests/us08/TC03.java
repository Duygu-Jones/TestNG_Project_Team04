package allovercommerce_com.tests.us08;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.ProductPage;
import allovercommerce_com.pages.WishlistPage;
import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03 {

    @Test
    public void test03() {  //Negative Scenario-------------------------------------------------------------------------

        HomePage homePage = new HomePage();
        ProductPage productPage = new ProductPage();
        WishlistPage wishlistPage=new WishlistPage();
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();


        ReusableMethods.extentReportCreate("duygu",
                "US_08 || Kullanıcı seçtiği ürünleri istek listesine ekleyebilmeli (WhishList)",
                "TC_02 || Kullanici (Fatura Adresi) Last Name (Soy isim) boş bırakılarak satin alma islemini gerceklestirememeli; (WhishList)");

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

        //4- Wishliste eklenen urunu goruntulemek icin sayfanin sag ust kosesinde Wishlist butonuna tıkla ve
        productPage.wishlistButtonDuygu.click();
        ReusableMethods.extentTestInfo("Wishlist Butonuna Tıklandi");
        //5- Wishlist sayfasinin acildigini dogrula
        Assert.assertTrue(wishlistPage.wishlistPageHeadLineDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Wishlish sayfasinin acildigi dogrulandi");
        ReusableMethods.waitForSecond(2);

        //6- Wishlist sayfasindan bir urunu sepete eklemek icin "Add To Cart" butonuna tiklar ve
        ReusableMethods.actionScrollDown();
        actions.scrollToElement(wishlistPage.wishlistAddToCartButtonDuygu);
        ReusableMethods.waitForSecond(1);
        wishlistPage.wishlistAddToCartButtonDuygu.click();
        ReusableMethods.extentTestInfo("Wishlist sayfasindan urunu sepete eklemek icin Add To Cart butonuna tiklandi");

        ReusableMethods.waitForSecond(2);
        //Urunun sepete eklendigini dogrula;  ( “Blue Ski Boots” has been added to your cart.) mesajinin goruntulendigini dogrula
        String expectedTextMessage="VIEW CART “Blue Ski Boots” has been added to your cart.";
        String actualTextMessage= wishlistPage.wishlistSepeteEklendiMesajiDuygu.getText();
        Assert.assertEquals(actualTextMessage,expectedTextMessage);
        ReusableMethods.extentTestPass("Wishlist sayfasinda Urunun sepete eklendigi dogrulandi");
        ReusableMethods.waitForSecond(2);

        //7- Sepette eklenen urunleri goruntulemek icin anasayfada sag-ust kosedeki Cart butonuna tiklar ve
        wishlistPage.shoppingCartButtonDuygu.click();
        ReusableMethods.extentTestInfo("Sepette eklenen urunleri goruntulemek icin Shopping Cart Buttonuna tiklandi");
        //Shopping Cart penceresinin goruntulendigini dogrula
        Assert.assertTrue(wishlistPage.shoppingCartPopUpDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Shopping Cart popup penceresinin goruntulendigi dogrulandi");

        //8- Shopping Cart'a eklenen urunleri satin almak icin CheckOut butonuna tiklar ve
        wishlistPage.shoppingCartPopUpCheckoutDuygu.click();
        ReusableMethods.extentTestInfo("Shopping Cart'a eklenen urunleri satin almak icin CheckOut butonuna tiklandi");
        // Siparis ozetinin goruntulendigini dogrula
        ReusableMethods.actionScrollDown();
        Assert.assertTrue(wishlistPage.totalOrderPriceDuygu.isDisplayed());
        ReusableMethods.extentTestPass("Siparis ozeti ve toplam fiyatin goruntulendigi dogrulandi");

        ReusableMethods.waitForSecond(2);

        //9- Satin alma islemini tamamlamak icin Fatura bilgileri girilir;
        //First Name kutusuna veri gir
        wishlistPage.shoppingFirstNameBoxDuygu.sendKeys(faker.name().firstName());

        //Last Name kutusuna BOS BIRAKILIR

        //Country kutusunda bulundugunuz Ulke secilir
        ReusableMethods.ddmVisibleText(wishlistPage.selectCountryDDMDuygu, "Turkey");

        //Street Address kutusuna mahalle bilgisi girilir
        wishlistPage.streetAddressDuygu.sendKeys(faker.address().streetAddress());

        //Zip code kutusuna veri girilir
        wishlistPage.zipCodeBoxDuygu.sendKeys(faker.address().zipCode());

        //Town/ City kutusuna veri girilir
        wishlistPage.townCityBoxDuygu.sendKeys("İzmir");

        //Province kutusunda Sehir secilir
        ReusableMethods.ddmVisibleText(wishlistPage.selectProvinceDDMDuygu,"İzmir");

        //Phone kutusuna telefon bilgisi girilir
        wishlistPage.phoneBoxDuygu.sendKeys(faker.phoneNumber().cellPhone());

        //email adresi girilir
        wishlistPage.emailBoxDuygu.sendKeys(faker.internet().emailAddress());

        //Payment methodu secilir; Wire transfer/EFT checkbox'i secilir
        if (!wishlistPage.checkBoxWireTransferDuygu.isSelected()){
            wishlistPage.checkBoxWireTransferDuygu.click();
        }
        ReusableMethods.extentTestInfo("Satin alma islemini tamamlamak icin Fatura Adress bilgileri girildi");

        //10- Place Order butonuna tıklanır
        ReusableMethods.actionScrollDown();
        ReusableMethods.waitForSecond(1);
        wishlistPage.placeOrderButtonDuygu.click();
        ReusableMethods.extentTestInfo("Siparis olsuturmak icin Place Order buttonuna tiklandi ");

        //Satin alma isleminin gerceklestirilemedigi dogrulanir (-)
        //"BILLING LAST NAME is a required field." mesajinin goruntulendigini dogrula
        Assert.assertTrue(wishlistPage.fieldIsRequiredMessageDuygu.getText().contains(" is a required field."));
        ReusableMethods.extentTestPass("Satin alma isleminin gerceklestirilemedigi dogrulandi");

    }

}
