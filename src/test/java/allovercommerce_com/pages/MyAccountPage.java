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

















































//Salih Turkmen (70)






































//Duygu Jones (120)

















































//Muammer Ucar (170)

















































//Ismail Sap (220)

















































//Selma Aslan (270)
    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signIn;
    @FindBy(xpath = "(//*[@data-toggle='tab'])[2]")
    public WebElement signUp;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement userName1;
    @FindBy(xpath = "(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[2]")
    public WebElement password1;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInol;
    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signout1;
    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement address;
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement add;
    @FindBy(xpath = "//*[@id='shipping_first_name']")
    public WebElement firstName;
    @FindBy(xpath = "//*[@id='shipping_last_name']")
    public WebElement lastName;
    @FindBy(xpath = "//*[@id='shipping_company']")
    public WebElement company;
    @FindBy(xpath = "//select[@data-placeholder='Select a country / region…']")
    public WebElement country1;
    @FindBy(xpath = "//*[@name='shipping_address_1']")
    public WebElement streetAddress1;
    @FindBy(xpath = "//*[@name='shipping_address_2']")
    public WebElement streetAddress2;
    @FindBy(xpath = "//*[@name='shipping_city']")
    public WebElement city;
    @FindBy(xpath = "//select[@data-placeholder='Select an option…']")
    public WebElement state;
    @FindBy(xpath = "//input[@name='shipping_postcode']")
    public WebElement zipCode;
    @FindBy(xpath = "//*[@name='save_address']")
    public WebElement saveAddress;
    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManager;
    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement product;
    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement addNew;
    @FindBy(linkText = "Province is a required field.")
    public WebElement province;
    @FindBy(linkText = "First name is a required field.")
    public WebElement textFirst;
    @FindBy(xpath = "(//*[@class='fas fa-exclamation-triangle'])[1]")
    public WebElement textLast;
    @FindBy(xpath = "//*[@class='fas fa-exclamation-triangle']")
    public WebElement textCountry;
    @FindBy(xpath = "//*[@class='fas fa-exclamation-triangle']")
    public WebElement textPostcode;
    @FindBy(xpath = "//*[@class='fas fa-check']")
    public WebElement textSuccessfully;
    @FindBy(xpath = "//h3[.='Shipping address']")
    public WebElement shipping;
    @FindBy(linkText = "Town / City is a required field.")
    public WebElement textTown;

    @FindBy(xpath = "//*[@class='register inline-type']")
    public WebElement register;
    















































//Kadir Furkan Kilic (320)

















































//Ibrahim Akar (370)




































































































}
