package allovercommerce_com.tests.test_ornekleri_duygu.ornekPages;


import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPageTry {





    public MyAccountPageTry(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

//Selma Simsek (satir baslangici: 20)

















































//Salih Turkmen (70)
    @FindBy(xpath = "//a[text()='Addresses']") public WebElement addressLink;
    @FindBy(xpath = "//main[@id=\"main\"]//div[2]//div[1]//a[1]")  public WebElement shippingAddressAddLink;
    @FindBy(xpath = "//input[@id='shipping_first_name']") public WebElement shippingAddressFirstnameBox;
    @FindBy(xpath = "//input[@id='shipping_last_name']") public WebElement shippingAddressLastnameBox;
    @FindBy(xpath = "//input[@id='shipping_address_1']") public WebElement shippingAddressStreetAddressBox;
    @FindBy(xpath = "//input[@id='shipping_postcode']") public WebElement shippingAddressPostcodeZIPBox;
    @FindBy(xpath = "//input[@id='shipping_city']") public WebElement shippingAddressTownCityBox;
    @FindBy(xpath = "//button[text()='Save address']") public WebElement shippingAddressSaveAddressButton;
    @FindBy(xpath = "//div[@role='alert']") public WebElement addressChangedSuccessfully;








































//Duygu Jones (120)

















































//Muammer Ucar (170)

















































//Ismail Sap (220)

















































//Selma Aslan (270)

















































//Kadir Furkan Kilic (320)

















































//Ibrahim Akar (370)




































































































}
