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
    @FindBy(xpath = "(//a[@class='register inline-type'])")                             public  WebElement registerMU;
    @FindBy(xpath ="(//a[@href='https://allovercommerce.com/vendor-register/'])[2]")    public  WebElement BecomeAVendorMU;
    @FindBy(id="user_email")                                                            public  WebElement emailBoxMU;
    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_email_verified_input'])")              public WebElement verificationCodeButtonMU;
    @FindBy(xpath ="(//a[@class='register_as_vendor'])")                                public  WebElement signUpAsAVendorButtonMU;
    @FindBy(xpath ="//input[@id='passoword']")                                          public WebElement passwordBoxAlloverCommerMU;
    @FindBy(xpath ="//input[@id='confirm_pwd']")                                        public WebElement confirmPasswordBoxAlloverCommerMU;
    @FindBy(id ="password_strength")                                                    public WebElement tooShortTextMU;
    @FindBy(id ="password_strength")                                                    public WebElement weakTextMU;
    @FindBy(id ="password_strength")                                                    public WebElement goodTextMU;
    @FindBy(id ="password_strength")                                                    public WebElement strongTextMU;
    @FindBy(xpath ="(//*[@class='from'])[1]")                                           public WebElement fakeMailButtonMU;
    @FindBy(xpath ="//span[starts-with(@id,'predmet')]")                                public WebElement fakemailVerificationCodeMU;
    @FindBy(xpath ="//input[@id='passoword']")                                          public WebElement passwordBox1MU;
    @FindBy(xpath ="(//*[@href='https://mail.google.com/mail/&ogbl'])")                 public WebElement gmailButtonMU;
    @FindBy(xpath ="(//*[@href='https://accounts.google.com/AccountChooser/signinchooser?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser&ec=asw-gmail-globalnav-signin'])")
                                                                                        public WebElement signInButtonMU;
    @FindBy(id ="identifierId")                                                         public WebElement gmailBoxMU;
    @FindBy(xpath ="//*[@name='Passwd']")                                               public WebElement gmailPasswordBoxMU;
    @FindBy(xpath ="(//span[@class='CJ'])[1]")                                          public WebElement otherButtonMU;
    @FindBy(xpath ="//a[@href='https://mail.google.com/mail/u/0/#spam']")               public WebElement spamButtonMU;
    @FindBy(xpath ="(//*[@class='bqe'])[2]")                                            public WebElement emailCamingToGmailFromAlloverCommerceMU;
    @FindBy(xpath ="(//h2[@class='hP'])")                                               public WebElement verificationCodeCamingToGmailFromAlloverCommerceMU;
    @FindBy(xpath = "(//*[@style='display: block;'])")
                                                                                        public WebElement verifyTextAlloverCommerMU;
























    //Ismail Sap (220)
    @FindBy(className = "w-icon-account") public WebElement signInButtonIsmail;
    @FindBy(id = "username") public WebElement userNameBoxIsmail;
    @FindBy(id = "password") public WebElement passwordBoxIsmail;
    @FindBy(name = "login") public WebElement loginButtonIsmail;
    @FindBy(xpath = "//span[.='Sign Out']") public WebElement loginVerifyIsmail;












































    //Selma Aslan (270)
    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signIn;
    @FindBy(xpath = "(//*[@data-toggle='tab'])[2]")
    public WebElement signUp;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement userName1;
    @FindBy(xpath = "(//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[2]")
    public WebElement password1;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInol;
    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signOut;
    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement address;
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement add;
    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManager;
    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement product;





























    //Kadir Furkan Kilic (320)

    @FindBy(xpath = "(//*[.='Sign In'])[2]")
    public static WebElement SignInFk;
    @FindBy(xpath = "//*[@id='username']")
    public static WebElement emailFk;
    @FindBy(xpath = "//*[@id='password']")
    public static WebElement passwordFk;
    @FindBy(xpath = "//*[@name='login']")
    public static WebElement submitFk;








































    //Ibrahim Akar (370)
@FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signInIbrahim;
@FindBy(id = "username")
public WebElement userNameTextBoxIbrahim;
@FindBy(xpath = "//*[@class='login logout inline-type']")
    public WebElement signOutIbrahim;
@FindBy(linkText = "Log out")
    public WebElement signOutConfirm;
































































































}
