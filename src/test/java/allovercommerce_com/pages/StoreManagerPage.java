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
    @FindBy(xpath = "(//*[@class='text'])[4]")public WebElement productFk;
    @FindBy(xpath = "(//*[text()='Add New'])[1]")public WebElement addNewFk;
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[1]")public WebElement inventoryFk;
    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_advanced_head']")public WebElement advencedFk;
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[4]")public  WebElement shippingFk;
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[5]")public WebElement atteributesFk;
    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[7]")public WebElement linkedFk;
    @FindBy(id = "wcfm_products_manage_form_yoast_head")public WebElement seoFk;
    @FindBy(xpath = "//*[@id='sku']")public WebElement skuFk;
    @FindBy(xpath = "//*[@class='wcfm-tabWrap']")public WebElement scrollEnd;
    @FindBy(xpath = "//*[@id='sold_individually']")public WebElement soldCheckboxFk;
    @FindBy(xpath = "//*[@id='weight']")public WebElement weightFk;
    @FindBy(xpath = "//*[@id='length']")public WebElement lengthFk;
    @FindBy(xpath = "//*[@id='shipping_class']")public WebElement shippingClassFk;
    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")public WebElement processingTimeFk;
    @FindBy(id = "attributes_is_active_1")public WebElement colorFk;
    @FindBy(id = "wcfm_products_manage_form_attribute_head")public WebElement attributeFk;
    @FindBy(xpath = "(//*[@class='select2-search__field'])[2]")public WebElement colorDdmFk;
    @FindBy(xpath = "//*[@name='attributes[2][is_active]']")public WebElement sizeFk;
    @FindBy(xpath = "(//*[@class='select2-search__field'])[3]")public WebElement ddmSizeFk;
    @FindBy(xpath = "//input[@id='manage_stock']") public WebElement manageStockCheckBoxFk;
    @FindBy (xpath = "//input[@id='stock_qty']") public WebElement stockQtyCheckBoxFk;
    @FindBy(xpath = "//*[@id='backorders']") public WebElement allowBackorders;
    @FindBy (xpath = "//img[@id='featured_img_display']") public WebElement featuredImgFk;
    @FindBy(xpath = "(//button[@class='btn btn-search'])[1]") public WebElement searchButton;
    @FindBy (xpath = "(//button[@id='menu-item-upload'])[2]") public WebElement uploadFilesFk;
    @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")public WebElement galleryImagesFk;
    @FindBy (xpath = "//input[@id='pro_title']") public WebElement productTitleFk;
    @FindBy (xpath = "//input[@value='998']") public WebElement categoriesFk;
    @FindBy(xpath = "//*[@class='wcfm_product_manager_general_fields']") public WebElement necessaryScrollFK;
    @FindBy(xpath = "//*[@id='is_virtual']") public WebElement virtualBoxFk;
    @FindBy(xpath = "//*[@id='menu-item-browse']") public WebElement mediaLibraryFk;
    @FindBy(xpath = "(//*[@src='https://allovercommerce.com/wp-content/uploads/2023/12/aaapicture-Kopya-300x300.webp'])[1]")public WebElement firstImageFk;
    @FindBy(xpath = "(//*[@class='product-wrap'])[1]")public WebElement upploaedCar;
    @FindBy(xpath = "(//*[@class='button media-button button-primary button-large media-button-select'])") public WebElement selectFk;
    @FindBy(xpath = "(//*[@class='thumbnail'])[10]")
    public WebElement secondImageFk;
    @FindBy(xpath = "(//*[@class='button media-button button-primary button-large media-button-select'])[2]") public WebElement secondSelect;
    @FindBy(id = "wcfm_products_simple_submit_button") public WebElement submitFk;
    @FindBy(xpath = "(//*[@class='form-control'])[1]") public WebElement searchBoxFk;
    @FindBy(xpath = "(//*[text()='Add to Gallery'])[3]") public WebElement addToGalleryFk;
    @FindBy(xpath = "//button[@id='__wp-uploader-id-1']") public WebElement selectFilesButtonFK;
    @FindBy(xpath = "//button[@id='__wp-uploader-id-4']") public WebElement selectFilesButton2Fk;






    //Ibrahim Akar (370)




































































































}