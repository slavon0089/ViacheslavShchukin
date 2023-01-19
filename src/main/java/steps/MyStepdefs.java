package steps;

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
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs extends AbstractStep {

    steps.Given given = new steps.Given(webDriver);
    steps.When when = new steps.When(webDriver);
    steps.Then then = new steps.Then(webDriver);

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
        given.openWebsite(URL_HOME_PAGE);

    }

    @Given("I open JDI GitHub site")
    public void openJdiGitHubWebsite() {
        given.openJdiGitHubWebsite(URL_HOME_PAGE);
    }

    @When("I login as user Roman Iovlev")
    public void loginAsUserRomanIovlev() {
        when.loginAsUserRomanIovlev(user, password);
    }

    @Then("title equals Home Page")
    public void titleEqualsHomePage() {
        then.titleEqualsHomePage(HOME_PAGE);
    }

    @Then("username is displayed and equals")
    public void usernameIsDisplayedAndEquals() {
        then.usernameIsDisplayedAndEquals(userFullName);
    }

    @When("I open Different Elements Page")
    public void openDifferentElementsPage()   {
        when.openDifferentElementsPage();
    }

    @When("I select checkboxes Water and Wind")
    public void selectCheckboxesWaterAndWind() {
        when.selectCheckboxesWaterAndWind();
    }

    @When("I select radiobutton Selen")
    public void selectRadiobuttonSelen() {
        when.selectRadiobuttonSelen();
    }

    @When("select dropdown Yellow")
    public void selectDropdownYellow() {
        when.selectDropdownYellow();
    }

    @Then("logs are displayed")
    public void logsAreDisplayed(DataTable dataTable) {
        then.logsAreDisplayed(dataTable);
    }

    @When("I login as user {string}")
    public void loginAsUser(String user) throws IOException {
        when.loginAsUser(user);
    }

    @When("I click on {string} button in Header")
    public void clickOnButtonInHeader(String item) {
        when.clickOnButtonInHeader(item);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String item) {
        when.clickOnButtonInServiceDropdown(item);
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String string) {
        then.pageShouldBeOpened(string);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        then.numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(count);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        then.usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(count);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        then.descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(count);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        then.checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(count);
    }

    @Then("User table should contain following values:")
    public void userTableShouldContainFollowingValuesAnd(DataTable dataTable) {
        then.userTableShouldContainFollowingValuesAnd(dataTable);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dataTable) {
        then.droplistShouldContainValuesInColumnTypeForUserRoman(dataTable);
    }

    @When("I select vip checkbox for {string}")
    public void selectVipCheckboxFor(String name) {
        when.selectVipCheckboxFor(name);
    }

    @Then("1 log row has {string} text in log section")
    public void logRowHasTextInLogSection(String log) {
        then.logRowHasTextInLogSection(log);
    }

    @After()
    public void browserQuit() {
        webDriver.quit();
        webDriver = null;
    }

}
