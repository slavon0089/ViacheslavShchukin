package steps;

import static utils.Config.getUserFullNameFromProperties;
import static utils.Config.getUserNameFromProperties;
import static utils.Config.getUserPasswordFromProperties;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.DifferentElementsPage;
import pages.MainPage;
import pages.ServiceMenu;
import pages.UserTablePage;


public class AbstractStep {

    public static WebDriver webDriver;
    SoftAssert softAssert = new SoftAssert();
    public MainPage mainPage;

    public ServiceMenu serviceMenu;
    public static DifferentElementsPage difElPage;

    public UserTablePage userTablePage;

    public String user = getUserNameFromProperties();
    public String password = getUserPasswordFromProperties();
    public String userFullName = getUserFullNameFromProperties();

    public AbstractStep() throws IOException {
    }

    protected AbstractStep(WebDriver webDriver) throws IOException {}
    //   // public static DifferentElementsPage difElPage;
    //    protected AbstractStep(WebDriver webDriver) {
    //        this.webDriver = webDriver;
    //    }

}
