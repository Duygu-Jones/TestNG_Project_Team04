package allovercommerce_com.tests.test_ornekleri_duygu.ornekPages;



import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageTry {


    public HomePageTry() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    //Selma Simsek (20)

















































    //Salih Turkmen (70)
    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInButton;
    SignUpInPageTry signUpinPage = new SignUpInPageTry();
    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccountLink;

    @FindBy (xpath = "//a[@class='register inline-type']")
    public WebElement registerButton;
    @FindBy(xpath = "//div[.='Sign Out']")
    public WebElement signOutButton;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/'])[1]")
    public WebElement myAccountButton;

    public void performLoginSalih() {
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        signInButton.click();
        signUpinPage.userNameBox.sendKeys("gakky80");
        signUpinPage.passwordBox.sendKeys("hukumuku82");
        signUpinPage.signInButton.click();
    }




























    //Duygu Jones (120)

















































    //Muammer Ucar (170)

















































    //Ismail Sap (220)

















































    //Selma Aslan (270)

















































    //Kadir Furkan Kilic (320)

















































    //Ibrahim Akar (370)




































































































}