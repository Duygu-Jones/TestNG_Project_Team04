package allovercommerce_com.pages;



import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {


    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Selma Simsek (20)

    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement registerButtonSS;

    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signInButtonSS;

    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement myAccountButtonSS;

    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signUpButtonSS;





































    //Salih Turkmen (70)
    @FindBy(xpath = "//span[text()='Sign In']") public WebElement signInButtonST;
    SignUpInPage signUpInPage=new SignUpInPage();
    @FindBy(xpath = "//li[@id='menu-item-1079']//a[contains(text(),'My Account')]") public WebElement myAccountLinkST;

    public void performLoginSalih() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        signInButtonST.click();
        signUpInPage.userNameBoxST.sendKeys("Alice");
        signUpInPage.passwordBoxST.sendKeys("Alice123456*");
        signUpInPage.signInButtonST.click();
    }
    @FindBy(css = "input[aria-label='Search']")         public WebElement searchBoxST;




































    //Duygu Jones (120)
    @FindBy(xpath = "//span[text()='Sign In']")             public WebElement signInButtonDuygu;
    @FindBy(xpath="//input[@aria-label='Search']")          public WebElement searchBoxDuygu;
    @FindBy(xpath = "//li/a[text()='Electronics']")         public WebElement electronicsCategoryLinkDuygu;
    @FindBy(xpath = "//li/a[text()='Home & Garden']")       public WebElement homeAndGardenCategoryLink;













































    //Muammer Ucar (170)

















































    //Ismail Sap (220)

















































    //Selma Aslan (270)

















































    //Kadir Furkan Kilic (320)

    public static void vendorLogginFk(){
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        SignUpInPage.SignInFk.click();
        SignUpInPage.emailFk.sendKeys(ConfigReader.getProperty("emailFk"));
        SignUpInPage.passwordFk.sendKeys(ConfigReader.getProperty("allowerPassFk"));
        SignUpInPage.submitFk.click();

    }
    @FindBy(xpath = "(//*[@href='https://allovercommerce.com/my-account-2/'])[1]")
    public WebElement myAccountFk;






































    //Ibrahim Akar (370)






    @FindBy(xpath = "(//*[@class='form-control'])[1]")
    public WebElement searchBoxIbrahim;































































































}
