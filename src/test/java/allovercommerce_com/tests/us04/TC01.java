package allovercommerce_com.tests.us04;

import allovercommerce_com.pages.HomePage;
import allovercommerce_com.pages.MyAccountPage;
import allovercommerce_com.pages.SignUpInPage;
import allovercommerce_com.utilities.Driver;
import allovercommerce_com.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC01 {

    @Test
    public void test01() {
        HomePage homePage=new HomePage();
        MyAccountPage myAccountPage=new MyAccountPage();
        Faker faker=new Faker();
        ReusableMethods.extentReportCreate("Salih","US04-Kullanıcı Shipping Adress ekleyebilmeli","TC01 Kullanıcı Shipping Adress ekleyebilmeli");


        //1	https://allovercommerce.com Sitesine Git ve Login Ol
        homePage.performLoginSalih();
        ReusableMethods.extentTestInfo("Web Sitesine Gidildi ve Log in Olundu");

        //2	Anasayfasında en alt kısımda yer alan "my account" tıkla.
        ReusableMethods.waitForSecond(3);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitForSecond(3);
        homePage.myAccountLinkST.click();
        ReusableMethods.extentTestInfo("My Account Linkine Tıklandı.");

        //4	"Addresses" butonuna tıklanır.
        myAccountPage.addressLinkST.sendKeys(Keys.ENTER);
        ReusableMethods.extentTestInfo("'Addresses' butonuna tıklandi");

        //Shipping Adress kısmının altındaki ADD kısmı tıkla.
        ReusableMethods.waitForSecond(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForSecond(3);
        myAccountPage.shippingAddressAddLinkST.click();
        ReusableMethods.extentTestInfo("Shipping Adress kısmının altındaki ADD kısmı tıklandi.");

        //"First name" kutusunu doldur.
        ReusableMethods.deleteAll(myAccountPage.shippingAddressFirstnameBoxST);
        myAccountPage.shippingAddressFirstnameBoxST.sendKeys(faker.name().firstName());
        ReusableMethods.extentTestInfo("'First name' kutusu dolduruldu");

        //"Last name" kutusunu doldur.
        ReusableMethods.deleteAll(myAccountPage.shippingAddressLastnameBoxST);
        myAccountPage.shippingAddressLastnameBoxST.sendKeys(faker.name().lastName());
        ReusableMethods.extentTestInfo("'Last name' kutusu dolduruldu");

        //Country/Region kısmını "Turkey" seç
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("Turkey").sendKeys(Keys.TAB).perform();
        ReusableMethods.extentTestInfo("Country/Region kısmını 'Turkey' seçildi");

        //Street address kısmında street adı gir
        ReusableMethods.deleteAll(myAccountPage.shippingAddressStreetAddressBoxST);
        myAccountPage.shippingAddressStreetAddressBoxST.sendKeys("28 Papatya");
        ReusableMethods.extentTestInfo("Street address kutusu dolduruldu.");

        //Street address kısmında apartman adı gir
        actions.sendKeys(Keys.TAB).sendKeys("Kuşcular").sendKeys(Keys.TAB).perform();
        ReusableMethods.extentTestInfo("Street address kısmında apartman adı girildi");

        //Postcode / ZIP gir
        ReusableMethods.deleteAll(myAccountPage.shippingAddressPostcodeZIPBoxST);
        myAccountPage.shippingAddressPostcodeZIPBoxST.sendKeys("467642");
        ReusableMethods.extentTestInfo("Postcode / ZIP kutusu dolduruldu.");

        //Town  / City gir
        //Province' de"Istanbul"'u seç
        ReusableMethods.deleteAll(myAccountPage.shippingAddressTownCityBoxST);
        myAccountPage.shippingAddressTownCityBoxST.sendKeys("Besiktaş");
        actions.sendKeys(Keys.TAB)
                .sendKeys("İstanbul").sendKeys(Keys.ENTER).sendKeys(Keys.TAB).perform();
        ReusableMethods.extentTestInfo("Town / City kutusu dolduruldu.");

        //SAVE ADDRESS butonuna tıklanır
        myAccountPage.shippingAddressSaveAddressButtonST.sendKeys(Keys.ENTER);
        ReusableMethods.extentTestInfo("SAVE ADDRESS butonuna tıklandi.");

        //Kayıdın gerçekleştiği doğrulanır
        String expectedData ="Address changed successfully.";
        ReusableMethods.verifyData(myAccountPage.addressChangedSuccessfullyST,expectedData);
        ReusableMethods.extentTestInfo("Kayıdın gerçekleştiği doğrulandi");

        ReusableMethods.extentTestPass("Kullanıcı Shipping Adress ekleyebildi");
        ReusableMethods.extentReportFlush();
        Driver.closeDriver();



    }
}
