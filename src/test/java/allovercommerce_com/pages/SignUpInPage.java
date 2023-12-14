package allovercommerce_com.pages;


import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignUpInPage {





    public SignUpInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Selma Simsek (20)

    @FindBy(xpath = "(//input[@id='username'])[1]")
    public WebElement usernameOrEmailTextBoxSS;

    @FindBy(xpath = "(//input[@id='password'])[1]")
    public WebElement passwordTextBoxSS;

    @FindBy(xpath = "(//button[.='Sign In'])[1]")
    public WebElement signInButtonSS;

    @FindBy(xpath = "(//input[@id='reg_username'])[1]")
    public WebElement signUpUsernameTextBoxSS;

    @FindBy(xpath = "(//input[@id='reg_email'])[1]")
    public WebElement signUpEmailTextBoxSS;

    @FindBy(xpath = "(//input[@id='reg_password'])[1]")
    public WebElement signUpPasswordTextBoxSS;

    @FindBy(xpath = "(//input[@id='register-policy'])[1]")
    public WebElement signUpIAgreeBoxSS;

    @FindBy(xpath = "(//button[.='Sign Up'])[1]")
    public WebElement signUpOnayButtonSS;

    @FindBy(xpath = "//p[.='An account is already registered with that username. Please choose another.']")
    public WebElement alreadyRegisteredUsernameSS;

    @FindBy(xpath = "//p[.='An account is already registered with your email address. Please log in.']")
    public WebElement alreadyRegisteredEmailSS;

    @FindBy(xpath = "//p[.='Please enter a valid account username.']")
    public WebElement invalidUsernameTextSS;
















    //Salih Turkmen (70)
    @FindBy(xpath = "//input[@id='username']")      public WebElement userNameBoxST;
    @FindBy(xpath = "//input[@id='password']")      public WebElement passwordBoxST;
    @FindBy(xpath = "//button[@value='Sign In']")   public WebElement signInButtonST;














































    //Duygu Jones (120)

















































    //Muammer Ucar (170)

















































    //Ismail Sap (220)
    @FindBy(className = "w-icon-account") public WebElement signInButtonIsmail;
    @FindBy(id = "username") public WebElement userNameBoxIsmail;
    @FindBy(id = "password") public WebElement passwordBoxIsmail;
    @FindBy(name = "login") public WebElement loginButtonIsmail;
    @FindBy(xpath = "//span[.='Sign Out']") public WebElement loginVerifyIsmail;












































    //Selma Aslan (270)

















































    //Kadir Furkan Kilic (320)

















































    //Ibrahim Akar (370)




































































































}
