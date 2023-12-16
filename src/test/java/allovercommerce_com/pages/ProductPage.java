package allovercommerce_com.pages;

import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductPage {




    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    //Selma Simsek (20)














































   
  
  
  //Salih Turkmen (70)

















































    //Duygu Jones (120)

    @FindBy(xpath = "//a[@class='compare btn-product-icon']")                   public List<WebElement> addToCompareListDuygu;
    @FindBy(xpath = "//a[@class='add_to_wishlist single_add_to_wishlist']")     public List<WebElement> addToWishlistListDuygu;
    @FindBy(xpath = "//a[@class='wishlist block-type']")                        public WebElement wishlistButtonDuygu;









































  
  
  
  
    //Muammer Ucar (170)

















































    //Ismail Sap (220)

















































    //Selma Aslan (270)
    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signIn;
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
    @FindBy(xpath = "//*[@class='btn btn-dark btn-rounded btn-sm']")
    public WebElement saveAddress;















    //Kadir Furkan Kilic (320)

















































    //Ibrahim Akar (370)
@FindBy(xpath = "//*[@name='add-to-cart']")
    public WebElement addToCartIbrahim;
@FindBy(xpath = "//i[@class='w-icon-cart']")
    public WebElement cartSymolIbrahim;
@FindBy(xpath = "//a[@class ='button checkout wc-forward']")
    public WebElement checkOutButtonIbrahim;
@FindBy(xpath = "//tr//td[@class='product-name']")
    public WebElement productListIbrahim;





























































































}