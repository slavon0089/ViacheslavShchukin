package steps;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.MainPage.HOME_PAGE;
import static pages.MainPage.URL_HOME_PAGE;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ServiceMenu;
import users.RomanIovlev;


public class MyStepdefs extends AbstractStep {
    public static List<String> textForLogsYellowSelenWindWater = List
            .of("Colors: value changed to Yellow",
                    "metal: value changed to Selen",
                    "Wind: condition changed to true",
                    "Water: condition changed to true");

    ActionStep actionStep = new ActionStep(webDriver);
    AssertStep assertStep = new AssertStep(webDriver);

    public MyStepdefs(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    public MyStepdefs() throws IOException {
        super(webDriver);
    }

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Given("I open website")
    public void openWebsite() {
        actionStep.openWebSite(URL_HOME_PAGE);
    }

    @Given("I open JDI GitHub site")
    public void openJdiGitHubWebsite() {
        actionStep.openWebSite(URL_HOME_PAGE);
    }

    @When("I login as user Roman Iovlev")
    public void loginAsUserRomanIovlev() {
        actionStep.performLogin(user, password);
    }

    @Then("title equals Home Page")
    public void titleEqualsHomePage() {
        assertStep.assertBrowserTitle(HOME_PAGE);
    }

    @Then("username is displayed and equals")
    public void usernameIsDisplayedAndEquals() {
        assertStep.assertUserIsLogged(userFullName);
    }

    @When("I open Different Elements Page")
    public void openDifferentElementsPage()   {
        actionStep.openDifferentElementsPage();
    }

    @When("I select checkboxes Water and Wind")
    public void selectCheckboxesWaterAndWind() {
        actionStep.selectCheckbox(difElPage.checkBoxWater);
        actionStep.selectCheckbox(difElPage.checkBoxWind);
    }

    @When("I select radiobutton Selen")
    public void selectRadiobuttonSelen() {
        actionStep.selectRadioButton(difElPage.radioButtonSelen);
    }

    @When("select dropdown Yellow")
    public void selectDropdownYellow() {
        actionStep.selectDropDownColor(difElPage.dropdownYellow);
    }

    @Then("logs are displayed")
    public void logsAreDisplayed() {
        assertStep.assertElementIsSelected(difElPage.checkBoxWater);
        assertStep.assertElementIsSelected(difElPage.checkBoxWind);
        assertStep.assertElementIsSelected(difElPage.radioButtonSelen);
        assertStep.assertElementIsSelected(difElPage.dropdownYellow);
        assertStep.assertLogsForElements(textForLogsYellowSelenWindWater);
    }

    @When("I login as user {string}")
    public void loginAsUser(String user) throws IOException {
        actionStep.loginAsUser(user);
    }

    @When("I click on {string} button in Header")
    public void clickOnButtonInHeader(String item) {
        actionStep.clickMenuItem(item);
        serviceMenu = new ServiceMenu(webDriver);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String item) {
        actionStep.clickServiceMenuItem(item);
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String string) {
        assertStep.assertBrowserTitle(string);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertNumberTypeDropdowns(count);

    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertNumberTypeUsers(count);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertDescriptionsUnderImages(count);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertCheckboxesUnderImages(count);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValuesAnd(DataTable dataTable) {
        assertStep.assertNumberUserDescription(dataTable);

    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dataTable) {
        assertStep.assertDropListContainsValuesForUserRoman(dataTable);
    }

    @When("I select vip checkbox for {string}")
    public void selectVipCheckboxFor(String name) {
        actionStep.selectOneVipCheckbox(name);
    }

    @Then("1 log row has {string} text in log section")
    public void logRowHasTextInLogSection(String log) {
        assertStep.assertLogText(log);
    }

    @After()
    public void browserQuit() {
        webDriver.quit();
        webDriver = null;
    }
}
