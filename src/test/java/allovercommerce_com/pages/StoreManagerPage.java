package allovercommerce_com.pages;


import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StoreManagerPage {





    public StoreManagerPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Selma Simsek (20)

















































 //Salih Turkmen (70)

















































//Duygu Jones (120)

















































//Muammer Ucar (170)

















































 //Ismail Sap (220)

















































 //Selma Aslan (270)
 @FindBy(xpath = "//*[.='Store Manager']")
 public WebElement storeManager;
 @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
 public WebElement product;
 @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
 public WebElement addNew;
 @FindBy(xpath = "//span[.='canta']")
 public WebElement canta;
 @FindBy(xpath = "//*[@id='pro_title']")
 public WebElement productTitle;
 @FindBy(xpath = "//*[@data-id='excerpt']")
 public WebElement shortDescription;
 @FindBy(xpath = "//*[@data-id='description']")
 public WebElement description;
 @FindBy(xpath = "//*[.='+Add new category']")
 public WebElement addNewCategory;
 @FindBy (xpath = "//*[@id='wcfm_new_cat']")
 public WebElement categoryName;
 @FindBy(xpath = "(//*[@value='298'])[1]")
 public WebElement apple;
 @FindBy (xpath = "//*[@id='wcfm_new_product_brand']")
 public WebElement productBrandName;
 @FindBy (xpath = "(//button[@class='button wcfm_add_category_bt wcfm_add_taxonomy_bt'])[2]")
 public WebElement add2;
 @FindBy(xpath = "//*[@value='variable']")
 public WebElement variable;
 @FindBy(xpath = "//*[@value='simple']")
 public WebElement simple;
 @FindBy(xpath = "//*[@value='grouped']")
 public WebElement grouped;
 @FindBy(xpath = "//*[@value='external']")
 public WebElement external;
 @FindBy(xpath = "//*[@id='featured_img_display']")
 public WebElement bigFoto;
 @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
 public WebElement smallFoto;
 @FindBy(xpath = "//*[@id='__wp-uploader-id-1']")
 public WebElement selectLoad;
 @FindBy (xpath = "(//p[@class='description wcfm_full_ele wcfm_side_add_new_category wcfm_add_new_category wcfm_add_new_taxonomy'])[2]")
 public WebElement addNewProductBrands;
 @FindBy (xpath = "//h2[.='Filter media']")
 public WebElement filterMedia;
 @FindBy (xpath = "//input[@value='1148']")
 public WebElement opel;





 //Kadir Furkan Kilic (320)

















































//Ibrahim Akar (370)


























































































}