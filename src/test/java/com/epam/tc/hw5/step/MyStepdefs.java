package com.epam.tc.hw5.step;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.DifferentElementsPage.checkBoxWater;
import static pages.DifferentElementsPage.checkBoxWind;
import static pages.DifferentElementsPage.dropdownYellow;
import static pages.DifferentElementsPage.radioButtonSelen;
import static pages.DifferentElementsPage.textForLogsYellowSelenWindWater;
import static pages.MainPage.HOME_PAGE;
import static pages.MainPage.URL_HOME_PAGE;
import static pages.UserTablePage.USER_TABLE_PAGE;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ServiceMenu;
import steps.AbstractStep;
import steps.ActionStep;
import steps.AssertStep;
import users.RomanIovlev;


public class MyStepdefs extends AbstractStep {

    ActionStep actionStep = new ActionStep(webDriver);
    AssertStep assertStep = new AssertStep(webDriver);

    public MyStepdefs(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    public MyStepdefs() throws IOException {
        super(webDriver);
    }

    @Given("I open website")
    public void openWebsite() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        actionStep.openWebSite(URL_HOME_PAGE);
    }

    @Given("I open JDI GitHub site")
    public void openJdiGitHubWebsite() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        actionStep.openWebSite(URL_HOME_PAGE);
    }

    @When("I login as user Roman Iovlev")
    public void loginAsUserRomanIovlev() {
        actionStep.performLogin(user, password);
    }

    @And("title equals Home Page")
    public void titleEqualsHomePage() {
        assertStep.assertBrowserTitle(HOME_PAGE);
    }

    @And("username is displayed and equals")
    public void usernameIsDisplayedAndEquals() {
        assertStep.assertUserIsLogged(userFullName);
    }

    @Then("I open Different Elements Page")
    public void openDifferentElementsPage()   {
        actionStep.openDifferentElementsPage();
    }

    @And("I select checkboxes Water and Wind")
    public void selectCheckboxesWaterAndWind() {
        actionStep.selectCheckbox(checkBoxWater);
        actionStep.selectCheckbox(checkBoxWind);
    }

    @And("I select radiobutton Selen")
    public void selectRadiobuttonSelen() {
        actionStep.selectRadioButton(radioButtonSelen);
    }

    @And("select dropdown Yellow")
    public void selectDropdownYellow() {
        actionStep.selectDropDownColor(dropdownYellow);
    }

    @And("logs are displayed")
    public void logsAreDisplayed() {
        assertStep.assertElementIsSelected(checkBoxWater);
        assertStep.assertElementIsSelected(checkBoxWind);
        assertStep.assertElementIsSelected(radioButtonSelen);
        assertStep.assertElementIsSelected(dropdownYellow);
        assertStep.assertLogsForElements(textForLogsYellowSelenWindWater);
    }

    @And("I login as user {string}")
    public void loginAsUser(String user) throws IOException {
        mainPage = new MainPage(webDriver);
        RomanIovlev romanIovlev = new RomanIovlev();
        actionStep.performLogin(romanIovlev.userName, romanIovlev.password);
        assertThat(mainPage.userLogged().equals(user.toUpperCase()));
    }

    @When("I click on {string} button in Header")
    public void clickOnButtonInHeader(String item) {
        actionStep.clickMenuItem(item);
        serviceMenu = new ServiceMenu(webDriver);
    }

    @And("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String item) {
        actionStep.openUserTablePage();
    }

    @Then("{string} page should be opened")
    public void pageShouldBeOpened(String string) {
        assertStep.assertBrowserTitle(USER_TABLE_PAGE);
    }



    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertNumberTypeDropdowns(count);

    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertNumberTypeUsers(count);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertDescriptionsUnderImages(count);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertCheckboxesUnderImages(count);
    }

    @And("User table should contain following values:")
    public void userTableShouldContainFollowingValuesAnd(DataTable dataTable) {
        assertStep.assertNumberUserDescription(dataTable);

    }

    @And("droplist should contain values in column Type for user Roman")
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
