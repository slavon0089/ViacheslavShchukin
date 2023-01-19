package steps;

import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class Then extends AbstractStep {
    AssertStep assertStep = new AssertStep(webDriver);

    protected Then(WebDriver webDriver) throws IOException {
        super(webDriver);
    }


    @Step("title equals Home Page")
    public void titleEqualsHomePage(String url) {
        assertStep.assertBrowserTitle(url);
    }

    @Step("username is displayed and equals")
    public void usernameIsDisplayedAndEquals(String fullName) {
        assertStep.assertUserIsLogged(fullName);
    }

    @Step("logs are displayed")
    public void logsAreDisplayed(DataTable dataTable) {
        assertStep.assertElementIsSelected(difElPage.checkBoxWater);
        assertStep.assertElementIsSelected(difElPage.checkBoxWind);
        assertStep.assertElementIsSelected(difElPage.radioButtonSelen);
        assertStep.assertElementIsSelected(difElPage.dropdownYellow);
        assertStep.assertLogsForElements(dataTable);
    }


    @Step("page should be opened")
    public void pageShouldBeOpened(String string) {
        assertStep.assertBrowserTitle(string);
    }

    @Step("Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertNumberTypeDropdowns(count);
    }

    @Step("Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertNumberTypeUsers(count);
    }

    @Step("Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertDescriptionsUnderImages(count);
    }

    @Step("checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int count) {
        assertStep.assertCheckboxesUnderImages(count);
    }

    @Step("User table should contain following values:")
    public void userTableShouldContainFollowingValuesAnd(DataTable dataTable) {
        assertStep.assertNumberUserDescription(dataTable);
    }

    @Step("droplist should contain values in column Type for user Roman")
    public void droplistShouldContainValuesInColumnTypeForUserRoman(DataTable dataTable) {
        assertStep.assertDropListContainsValuesForUserRoman(dataTable);
    }

    @Step("1 log row has text in log section")
    public void logRowHasTextInLogSection(String log) {
        assertStep.assertLogText(log);
    }

}
