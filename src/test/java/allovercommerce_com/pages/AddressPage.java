package allovercommerce_com.pages;


import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AddressPage {






    public AddressPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


//Selma Simsek (20)

    @FindBy(xpath = "(//a[.='Add'])[1]") public WebElement addButtonSS;

    @FindBy(xpath= "//input[@id='billing_first_name']") public WebElement firstNameTextBoxSS;

    @FindBy(xpath = "//input[@id='billing_last_name']") public WebElement lastNameTextBoxSS;

    @FindBy(xpath = "//input[@id='billing_company']") public WebElement companyTextBoxSS;

    @FindBy(xpath= "//select[@id='billing_country']") public WebElement countryRegionDdmSS;

    @FindBy(xpath= "//input[@name='billing_address_1']") public WebElement streetAddressTextBoxSS;

    @FindBy(xpath = "//input[@name='billing_city']") public WebElement townCityTextBoxSS;

    @FindBy(xpath= "//input[@id='billing_state']") public WebElement stateTextBoxSS;

    @FindBy(xpath= "(//span[.='Select an option…'])[5]") public WebElement stateDdmSS;

    @FindBy(xpath = "//input[@name='billing_postcode']") public WebElement zipCodeTextBoxSS;

    @FindBy(xpath= "//input[@id='billing_phone']") public WebElement phoneTextBoxSS;

    @FindBy(xpath= "//input[@name='billing_email']") public WebElement emailAddressTextSS;

    @FindBy(xpath= "//button[.='Save address']") public WebElement saveAddressButtonSS;

    @FindBy(xpath = "//h3[.='Billing address']") public WebElement billingAddressButtonSS;

    @FindBy(xpath= "//a[.='Edit Your Billing Address']") public WebElement editYourBillingAddressSS;

    @FindBy(xpath= "//div[@role='alert']") public WebElement addressAddAlertSS;

    @FindBy(xpath= "//ul[@role='alert']") public WebElement bosTextAlertSS;















//Salih Turkmen (70)

















































//Duygu Jones (120)

















































    //Muammer Ucar (170)

















































    //Ismail Sap (220)

















































    //Selma Aslan (270)

















































    //Kadir Furkan Kilic (320)

















































    //Ibrahim Akar (370)




































































































}
