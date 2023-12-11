package allovercommerce_com.tests.us17;

import allovercommerce_com.utilities.ConfigReader;
import allovercommerce_com.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC01 {
    @Test
    public void testVendorBuy() {
            Actions actions = new Actions(Driver.getDriver());
            Driver.getDriver().get(ConfigReader.getProperty("URL"));


    }
}
