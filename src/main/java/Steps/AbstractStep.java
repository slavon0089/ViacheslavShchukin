package Steps;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AbstractStep {

    public static WebDriver webDriver;
    SoftAssert softAssert = new SoftAssert();
    protected WebDriver driver;

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
    }
}
