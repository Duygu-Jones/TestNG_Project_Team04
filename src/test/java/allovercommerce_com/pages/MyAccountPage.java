package allovercommerce_com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage {





    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


//Selma Simsek (satir baslangici: 20)

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addressButtonSS;














































//Salih Turkmen (70)
    @FindBy(xpath = "//a[text()='Addresses']") public WebElement addressLinkST;
    @FindBy(xpath = "//main[@id='main']//div[2]//div[1]//a[1]")  public WebElement shippingAddressAddLinkST;
    @FindBy(xpath = "//input[@id='shipping_first_name']") public WebElement shippingAddressFirstnameBoxST;
    @FindBy(xpath = "//input[@id='shipping_last_name']") public WebElement shippingAddressLastnameBoxST;
    @FindBy(xpath = "//input[@id='shipping_address_1']") public WebElement shippingAddressStreetAddressBoxST;
    @FindBy(xpath = "//input[@id='shipping_postcode']") public WebElement shippingAddressPostcodeZIPBoxST;
    @FindBy(xpath = "//input[@id='shipping_city']") public WebElement shippingAddressTownCityBoxST;
    @FindBy(xpath = "//button[text()='Save address']") public WebElement shippingAddressSaveAddressButtonST;
    @FindBy(xpath = "//div[@role='alert']") public WebElement addressChangedSuccessfullyST;
    @FindBy(xpath = "//li[contains(@class,'alert alert-simple alert-icon alert-close-top alert-danger')]") public WebElement verifyAddressNotChangedST;
    @FindBy(xpath = "//li[contains(@class,'alert alert-simple alert-icon alert-close-top alert-danger')]") public WebElement addressNotChangedLastNameRequiredST;
    @FindBy(xpath = "//li[contains(@class,'alert alert-simple alert-icon alert-close-top alert-danger')]") public WebElement addressNotChangedPostCodeRequiredST;





































    //Duygu Jones (120)

















































//Muammer Ucar (170)

















































//Ismail Sap (220)
@FindBy(xpath = "//a[.='My Account']") public  WebElement myAccountButtonIsmail;
@FindBy(xpath = "//h2[@class='page-title']") public WebElement myAccountPageVerifyIsmail;
@FindBy(xpath = "//*[.='Store Manager']") public WebElement storeManagerIsmail;
@FindBy(xpath = "//a[.='Orders']") public WebElement ordersIsmail;
@FindBy(xpath = "//a[.='Downloads']") public WebElement downloadsIsmail;
@FindBy(xpath = "//a[.='Addresses']") public WebElement addressesIsmail;
@FindBy(xpath = "//a[.='Account details']") public WebElement accountDetailsIsmail;
@FindBy(xpath = "(//a[.='Wishlist'])[1]") public WebElement wishlistIsmail;
@FindBy(xpath = "//a[.='Support Tickets']") public WebElement supportTicketsIsmail;
@FindBy(xpath = "//a[.='Followings']") public WebElement followingsIsmail;
@FindBy(xpath = "//a[.='Logout']") public WebElement logOutIsmail;
@FindBy(xpath = "//h2[.='Store Manager']") public WebElement storeManagerVerifyIsmail;
@FindBy(xpath = "//h4[.='Orders']") public WebElement ordersVerifyIsmail;
@FindBy(xpath = "//h4[.='Downloads']") public  WebElement downloadsVerifyIsmail;
@FindBy(xpath = "//h4[.='Addresses']") public  WebElement adressesVerifyIsmail;
@FindBy(xpath = "//h4[.='Account Details']") public WebElement accountDetailsVerifyIsmail;
@FindBy(xpath = "//h2[.='Wishlist']") public WebElement wishlistVerifyIsmail;
@FindBy(xpath = "//span[.='Status']") public WebElement supportTicketsVerifyIsmail;
@FindBy(xpath = "//span[.='Store']") public WebElement followingsVerifyIsmail;
@FindBy(xpath = "//span[.='Remember me']") public WebElement logoutVerifyIsmail;





























//Selma Aslan (270)

















































//Kadir Furkan Kilic (320)


    @FindBy(xpath = "//*[@href='https://allovercommerce.com/store-manager/']")
    public WebElement storeManagerFk;













































//Ibrahim Akar (370)




































































































}
