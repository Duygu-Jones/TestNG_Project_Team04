package allovercommerce_com.pages;


import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ShoppingPage {



    public ShoppingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Selma Simsek (20)

















































    //Salih Turkmen (70)
    @FindBy(xpath = "//a[contains(@aria-label, 'pen')]")            public List<WebElement> searchedProductsAddToCartButtonsST;
    @FindBy (xpath = "//a[@class='cart-toggle']")                   public WebElement cartButtonST;
    @FindBy (xpath = "//a[@class='button checkout wc-forward']")    public WebElement checkoutButtonST;
    @FindBy (xpath = "//a[@class='button wc-forward']")             public WebElement viewCartButtonST;
    @FindBy (xpath = "//*[@id='main']/div/div/div/div[4]/ul/li[2]/div/figure/div/a[1]") public WebElement addToCartButtonST;
    @FindBy(xpath = "//input[@class='input-text qty text']")  public WebElement quantity;
    @FindBy(xpath = "//h4[text()='Shipping']") public WebElement shippingText;










































    //Duygu Jones (120)

















































    //Muammer Ucar (170)

















































    //Ismail Sap (220)

















































    //Selma Aslan (270)

















































    //Kadir Furkan Kilic (320)

















































    //Ibrahim Akar (370)




































































































}