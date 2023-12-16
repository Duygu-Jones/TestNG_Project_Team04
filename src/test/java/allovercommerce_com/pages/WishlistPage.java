package allovercommerce_com.pages;


import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class WishlistPage {

    public WishlistPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    //Selma Simsek (20)

















































    //Salih Turkmen (70)

















































    //Duygu Jones (120)
    @FindBy(xpath = "//tbody//tr")      public List<WebElement> wishlistListDuygu;
    @FindBy(xpath = "//button[@title='Quick View']")        public List<WebElement> quickViewButtonDuygu;
    @FindBy (xpath = "//button[@title='Close (Esc)']")      public WebElement quickViewPopUpCloseDuygu;
    @FindBy (xpath = "//button[@name='add-to-cart']")       public WebElement quickViewAddToCartButtonDuygu;
    @FindBy(xpath = "//a[@class='btn btn-sm btn-dark btn-rounded']")    public WebElement quickViewCheckoutPopUpDuygu;
    @FindBy (xpath = "//a[.='Add to cart']")            public WebElement wishlistAddToCartButtonDuygu;
    @FindBy(xpath = "//div[@role='alert']")             public WebElement wishlistSepeteEklendiMesajiDuygu;
    @FindBy(xpath = "//div[@class='product-meta-inner']")       public WebElement wishlistProductFeaturesTextDuygu;
    @FindBy (xpath = "(//h2[.='Wishlist'])[1]")     public WebElement wishlistPageHeadLineDuygu;
    //------------------orderPage------------------------
    @FindBy (xpath = "//a[@class='cart-toggle']")     public WebElement shoppingCartButtonDuygu;
    @FindBy (xpath = "//div[@class='cart-popup widget_shopping_cart dropdown-box']")    public WebElement shoppingCartPopUpDuygu;
    @FindBy (xpath = "//*[.='Checkout'] ")      public WebElement shoppingCartPopUpCheckoutDuygu;
    @FindBy(xpath="//h3[@id='order_review_heading']")   public WebElement totalOrderPriceDuygu;
    @FindBy(xpath="//input[@id='billing_first_name']")  public WebElement shoppingFirstNameBoxDuygu;
    @FindBy(xpath = "//select[@id='billing_country']")  public WebElement selectCountryDDMDuygu;
    @FindBy(xpath="//input[@id='billing_address_1']") public WebElement streetAddressDuygu;
    @FindBy(xpath="//input[@id='billing_postcode']") public WebElement zipCodeBoxDuygu;
    @FindBy(xpath="//input[@id='billing_city']") public WebElement townCityBoxDuygu;
    @FindBy(xpath="//select[@id='billing_state']") public WebElement selectProvinceDDMDuygu;
    @FindBy(xpath="//input[@id='billing_phone']")   public WebElement phoneBoxDuygu;
    @FindBy(xpath="//input[@id='billing_email']") public WebElement emailBoxDuygu;
    @FindBy(xpath="//input[@id='payment_method_bacs']") public WebElement checkBoxWireTransferDuygu;
    @FindBy(xpath="//button[@id='place_order']")    public WebElement placeOrderButtonDuygu;
    @FindBy(xpath="//*[.='Thank you. Your order has been received.']")    public WebElement orderConfirmedMessageDuygu;
    @FindBy(xpath=" //*[@class=' alert alert-simple alert-icon alert-close-top alert-danger']")    public WebElement fieldIsRequiredMessageDuygu;























    //Muammer Ucar (170)

















































    //Ismail Sap (220)

















































    //Selma Aslan (270)

















































    //Kadir Furkan Kilic (320)

















































    //Ibrahim Akar (370)




































































































}