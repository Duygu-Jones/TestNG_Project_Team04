package allovercommerce_com.pages;


import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ComparePage {

    public ComparePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }








//Selma Simsek (25)












































//Salih Turkmen (70)

















































//Duygu Jones (120)
    @FindBy(xpath = "//div[@class='compare-basic-info']")                   public List<WebElement> compareListDuygu;
    @FindBy(xpath = "//a[@class='compare-action remove_from_compare']")     public WebElement removeFromCompareListButtonDuygu;
    @FindBy(xpath = "//h2[text()='No products added to the compare']")      public WebElement noProductsAddedToTheCompareTextDuygu;
    @FindBy(xpath = "//h3[.='Compare Products']")                           public WebElement comparePopUpWindowDuygu;
    @FindBy(xpath = "//figure/img[@width='300']")                         public List<WebElement> comparePopUp_ProductsList;
    @FindBy(xpath = "//a[@class='btn-remove remove_from_compare fas fa-times']") public List<WebElement> removeFromComparePopUpDuygu;
    @FindBy(xpath = "//a[@class='compare-clean']")                          public WebElement cleanAllComparePopUpDuygu;
    @FindBy(xpath = "//div[@class='compare-popup-overlay']")                public WebElement comparePopUp_CloseDuygu;
    @FindBy(xpath = "//a[@class='btn btn-dark btn-rounded']")                public WebElement startCompareAllDuygu;
    @FindBy(className = "slider-scrollbar-drag")                            public WebElement comparePopUpSlideBarDuygu;
    @FindBy(xpath = "//h2[.='Compare']")                                    public WebElement comparePageHeadDuygu;
    @FindBy(xpath= "//li/a[.='Home']")                                      public WebElement homeButtonDuygu;





































    //Muammer Ucar (170)

















































    //Ismail Sap (220)

















































    //Selma Aslan (270)

















































    //Kadir Furkan Kilic (320)

















































    //Ibrahim Akar (370)




































































































}
