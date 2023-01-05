package steps;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.DifferentElementsPage;
import pages.MainPage;

public class AbstractStep {

    public static WebDriver webDriver;
    SoftAssert softAssert = new SoftAssert();
    public MainPage mainPage;
    public static DifferentElementsPage difElPage;


    protected AbstractStep(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
