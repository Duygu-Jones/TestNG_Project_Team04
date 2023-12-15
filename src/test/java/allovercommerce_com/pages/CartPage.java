package allovercommerce_com.pages;


import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {

    public CartPage(){




        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Selma Simsek (20)

















































    //Salih Turkmen (70)
@FindBy(id = "payment_method_cod")         public WebElement payAtTheDoorRadioButtonST;
    @FindBy(id = "place_order")              public WebElement placeOrderButtonST;
    @FindBy(xpath = "//p[.='Thank you. Your order has been received.']")    public WebElement thankYouYourOrderHasBeenReceivedTextST;
    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")    public WebElement quantityPlusButtonST;
    @FindBy(xpath = "//input[@class='input-text qty text']")           public WebElement quantityTextST;
    @FindBy (xpath = "//button[@title='Minus']") public WebElement quantityMinusButtonST;
    @FindBy(xpath = "//button[@name='update_cart']")     public WebElement quantityUpdateButtonST;










































    //Duygu Jones (120)

















































    //Muammer Ucar (170)

















































    //Ismail Sap (220)

















































    //Selma Aslan (270)

















































    //Kadir Furkan Kilic (320)

















































    //Ibrahim Akar (370)




































































































}
