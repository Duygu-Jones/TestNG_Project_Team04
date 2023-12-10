package allovercommerce_com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {



//--------------------------------------wait: HARD WAIT METHOD----------------------------------------------------------
    public static void waitForSecond(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


//---------------------------------------waits: WAIT EXPLICIT METHODS----------------------------------------------------

    //Visible Wait for element
    public static void waitForVisibleElement(WebElement element, int second) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //inVisible Wait for Element
    public static void waitForInVisible(WebElement element, int second) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(second));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }

    //Visible Element Locator Wait
    public static WebElement waitForVisibleElementByLocator(By locator, int second) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(second));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    //Wait For Alert
    public static void waitForAlert(int second) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(second));
        wait.until(ExpectedConditions.alertIsPresent());

    }



//-------------------------------------------ALERT HANDLES--------------------------------------------------------------

    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertPrompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }


//-----------------------------------ddm-SELECT-------------------------------------------------------------------------

    //DropDown VisibleText ile secer
    public static void ddmVisibleText(WebElement ddm, String optionText) {
        Select select = new Select(ddm);
        select.selectByVisibleText(optionText);
    }

    //DropDown Index ile secer
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value ile secer
    public static void ddmValue(WebElement ddm, String optionsValue) {
        Select select = new Select(ddm);
        select.selectByValue(optionsValue);
    }


//------------------------------CheckBox-------------------------------------------------------------------------------
    public static void checkTheBox(WebElement checkbox){
        if (!checkbox.isSelected()){
            checkbox.click();
        }
    }


//-----------------------------ACTIONS----------------------------------------------------------------------------------

    //ACTIONS SCROLL_DOWN : sayfayi 1 kez asagi kaydirir
    public static void actionScrollDown(){
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).build().perform();
    }


    //ACTIONS SCROLL_END : Sayfanin en sonuna gider
    public static void actionScrollEnd(){
        new Actions(Driver.getDriver()).sendKeys(Keys.END).build().perform();
    }

    //ACTIONS SCROLL_UP : sayfayi 1 kez yukari kaydirir
    public static void actionScrollUp(){
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_UP).build().perform();
    }

    //ACTIONS SCROLL_HOME :  sayfanin en basina gider
    public static void actionScrollHome(){
        new Actions(Driver.getDriver()).sendKeys(Keys.HOME).build().perform();
    }



//-------------------------------SwitchTo:  Window  / iframe ----------------------------------------------------------

    //SwitchToWindow1 : List seklinde tum windows handles'lari alir ve index no ile istedigimiz window'u alabilirz
    public static void switchToWindows(int number) {
        List<String> allWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(allWindowHandles.get(number));
    }


    //SwitchToWindow2 : yukaridaki method ile aynidir, Stream seklinde yazilmis code. tum window handles'lari alir
    public static void switchToWindow(int number) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[number].toString());
    }


    //Switch to Iframe
    public static void frameIndex(int index){
        Driver.getDriver().switchTo().frame(index);
    }


    //Iframe'den parent frame'e gecmek icin;
    public static void frameToParentFrame(){
        Driver.getDriver().switchTo().parentFrame();
    }

    //Iframe'den tamamen cikmak icin;
    public static void frameToDefaultContent(){
        Driver.getDriver().switchTo().defaultContent();
    }




//----------------------------------------- Screen Shots Methods --------------------------------------------------------

    //Tüm Sayfa ScreenShot
    public static void screenShot(String imgName, String yourName) {
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        String filePath = System.getProperty("user.dir") + "/src/test/java/allovercommerce_com/testoutputs/screenShots/"
                                                                            +yourName + "_"+ imgName+ "_"+  date + ".png";



        try {
            Files.write(Paths.get(filePath),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement ScreenShot
    public static void  screenShotOfWebElement(WebElement webElement, String imgName, String yourName){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );
        String filePath = System.getProperty("user.dir") + "/src/test/java/allovercommerce_com/testoutputs/webElementScreenShots/"
                                                                                +yourName + "_"+ imgName+ "_"+  date + ".png";

        try {
            Files.write(Paths.get(filePath),webElement.getScreenshotAs(OutputType.BYTES) );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


//--------------------------------------------WebTable-------------------------------------------------------------------

    //WebTable
    public static void printDataFromTable(int tableNo, int row, int column) {
        WebElement rowAndColumn = Driver.getDriver().findElement(By.xpath("//table["+tableNo+"]//tbody//tr["+row+"]//td["+column+"]"));
        System.out.println("rowAndColumn Data: "+ rowAndColumn.getText());
        System.out.println(rowAndColumn.getText());
    }

//--------------------------------------------JS Executor Methods--------------------------------------------------------
    // JS Executor Click Method
    public static void jsClick(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void jsScroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void jsScrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void jsScrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS Executor SendKeys
    public static void jsSendKeys(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SetAttributeValue
    public static void jsSetAttribute(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void jsGetValueBy(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }




//----------------------------- Extent Reports --------------------------------------------------------------------------

    protected static ExtentReports extentReports;                //--> Raporlamayi baslatir
    protected static ExtentHtmlReporter extentHtmlReporter;      //--> html formatinda raporlari olusturur
    protected static ExtentTest extentTest;                      //--> Test adimlarina bilgi ekler, buna yonelik methodlari icerir


    public static void extentReportCreate(String yourName, String us_NoBaslik, String tc_NoBaslik){

        if (extentReports == null) {

            //Raporlamayi olusturmak ve yonetmek icin Object olusturulur
            extentReports = new ExtentReports();

            //Test stepleri olusutulabilmesi icin extentTest Object olusturuldu
            extentTest = extentReports.createTest(tc_NoBaslik);

            // raporun HTML dosyasıni oluşturulur
            String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
            String yourReportName = yourName +"_"+ date + "_Allovercommerce.com_html_report.html"; // Rapor dosyasının adı
            extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/extentReport/" + yourReportName);

            //ExtentReport'a, Html raporlayiciyi ekler; bu raporun html formatinda olusturulmasini saglar
            extentReports.attachReporter(extentHtmlReporter);

            //Raporun adi tanimlandi, Raporda gorunecek olan GENEL BASLIK --> h1
            extentHtmlReporter.config().setReportName("Allovercommerce.com | " + us_NoBaslik);        //site basligi

            //Html Raporunun belge basligi tanimlanir ve bu baslik sekme uzerinde gorulur --> h2
            extentHtmlReporter.config().setDocumentTitle(tc_NoBaslik);

            // Raporlama bilgileri girilir
            extentReports.setSystemInfo("Project", "TestNG");
            extentReports.setSystemInfo("Test Türü", "Regression");
            extentReports.setSystemInfo("Grup", "Batch189");
            extentReports.setSystemInfo("Takım", "TEAM4");
            extentReports.setSystemInfo("QA", yourName);
            extentReports.setSystemInfo("Website: ", "Allovercommerce.com");
            extentReports.setSystemInfo("User_Story", us_NoBaslik);
            extentReports.setSystemInfo("Test_Case", tc_NoBaslik);

        }
    }


    //test steps'leri bu method ile girilir
    public static void extentTestInfo(String testStepsMessage) {
        if (extentTest != null) {
            extentTest.info(testStepsMessage);
        }
    }


    //Test gecer ise; Test Passed rapor mesaji verir
    public static void extentTestPass(String expectedMessage) {
        if (extentTest != null) {
            extentTest.pass(expectedMessage);
        }
    }

    //Test kalir ise; Test Failed rapor mesaji verir
    public static void extentTestFail(String message) {
        if (extentTest != null) {
            extentTest.fail(message);
        }
    }


    // ExtentReports objesinin flush() metodunu çağırarak rapor dosyasını oluşturur ve kaydeder:
    //      !!! test sonunda mutlaka eklenmelidir
    public static void extentReportFlush() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }




//---------------------------------------Kisisel Methodlar----------------------------------------------------------------














































    //---------------------------------------Kisisel Methodlar : 399 ----------------------------------------------------------------
    //Selma Simsek (400)

















































    //Salih Bey: 450
    public static void verifyData(WebElement element, String expected) {
        String actualDate = element.getText();
        Assert.assertEquals(actualDate, expected);

    }












































    //Duygu Jones (500)

















































    //Muammer Ucar (550)

















































    //Ismail Sap (600)

















































    //#Selma Aslan (650)

















































    //Kadir Furkan Kilic (700)

















































    //Ibrahim bey; 7500
    public static void deleteAll(WebElement webElement){
        String selectAll = Keys.chord(Keys.CONTROL,"a");
        webElement.sendKeys(selectAll,Keys.DELETE);
    }




















































}//class