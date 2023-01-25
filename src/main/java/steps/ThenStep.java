package steps;

import static pages.MainPage.HOME_PAGE;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class ThenStep extends AbstractStep {
    AssertStep assertStep = new AssertStep(webDriver);

    protected ThenStep(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    public ThenStep() throws IOException {
        super(webDriver);
    }

    @Then("title equals Home Page")
    public void titleEqualsHomePage() {
        assertStep.assertBrowserTitle(HOME_PAGE);
    }

    @Then("username is displayed and equals")
    public void usernameIsDisplayedAndEquals() {
        assertStep.assertUserIsLogged(userFullName);
    }

    @Then("logs are displayed")
    public void logsAreDisplayed(DataTable dataTable) {
        assertStep.assertElementIsSelected(difElPage.checkBoxWater);
        assertStep.assertElementIsSelected(difElPage.checkBoxWind);
        assertStep.assertElementIsSelected(difElPage.radioButtonSelen);
        assertStep.assertElementIsSelected(difElPage.dropdownYellow);
        assertStep.assertLogsForElements(dataTable);
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

    @Then("1 log row has {string} text in log section")
    public void logRowHasTextInLogSection(String log) {
        assertStep.assertLogText(log);
    }

}
