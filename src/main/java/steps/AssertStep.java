package steps;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.MainPage;
import pages.UserTablePage;


public class AssertStep extends AbstractStep {


    public AssertStep(WebDriver driver) throws IOException {
        super(driver);
    }

    @Step("Assert Browser title Home Page")
    public void assertBrowserTitle(String title) {
        softAssert.assertEquals(webDriver.getTitle(), title);
    }

    @Step("I assert Username is logged")
    public void assertUserIsLogged(String userFullName) {
        mainPage = new MainPage(webDriver);
        softAssert.assertEquals(mainPage.userLogged(), userFullName);
        softAssert.assertAll();
    }

    @Step("I assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assert4HeadersItems(List<String> listItemsHeader) {
        for (int i = 0; i < listItemsHeader.size(); i++) {
            softAssert.assertEquals(mainPage.menuList().get(i).getText(), listItemsHeader.get(i));
            softAssert.assertTrue(mainPage.menuList().get(i).isDisplayed());
        }
    }

    @Step("I assert that there are 4 images on the Index Page and they are displayed")
    public void assert4ImagesOnIndexPageDisplayed(int countOfImagesOnMainPage) {
        softAssert.assertEquals(mainPage.listOfImages.size(), countOfImagesOnMainPage);
        for (int i = 0; i < countOfImagesOnMainPage; i++) {
            softAssert.assertTrue(mainPage.listOfImages.get(i).isDisplayed());
        }
    }

    @Step("I assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertProperTextUnder4Images(List<String> textUnderImages) {
        for (int i = 0; i < mainPage.listOfTextUnderImages.size() - 1; i++) {
            softAssert.assertEquals(mainPage.listOfTextUnderImages.get(i).getText(), textUnderImages.get(i));
        }
    }

    @Step("I assert that there is the iframe with “Frame Button” exist")
    public void assertIframeButtonExist() {
        softAssert.assertTrue(mainPage.frame.isDisplayed());
    }

    @Step("I check that there is “Frame Button” in the iframe")
    public void assertFrameButtonIsDisplayed() {
        softAssert.assertTrue(mainPage.frameButton.isDisplayed());
    }

    @Step("I assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assert5itemsInLeftSectionIsDisplayed(List<String> leftMenuItems) {
        for (int i = 0; i < mainPage.leftMenu.size() - 1; i++) {
            softAssert.assertEquals(mainPage.leftMenu.get(i).getText(), leftMenuItems.get(i));
        }
    }

    @Step("I check selected elements")
    public void assertElementIsSelected(WebElement element) {
        Assertions.assertThat(element.isSelected()).isTrue();
    }

    @Step("I check log row and value is corresponded to the selected value.")
    public void assertLogsForElements(List<String> textForLogs) {
        for (int i = 0; i < textForLogs.size(); i++) {
            Assertions.assertThat(difElPage.logs.get(i).getText()).contains(textForLogs.get(i));
        }
    }

    @Step("assert numbers of dropdowns")
    public void assertNumberTypeDropdowns(int countDropdowns) {
        userTablePage = new UserTablePage(webDriver);
        Assertions.assertThat(userTablePage.listOfDropdowns.size()).isEqualTo(countDropdowns);
        for (int i = 0; i < countDropdowns; i++) {
            Assertions.assertThat(userTablePage.listOfDropdowns.get(i).isDisplayed()).isTrue();
        }
    }

    @Step("assert number type of users")
    public void assertNumberTypeUsers(int countUsers) {
        Assertions.assertThat(userTablePage.listOfUsers.size()).isEqualTo(countUsers);
        for (int i = 0; i < countUsers; i++) {
            Assertions.assertThat(userTablePage.listOfUsers.get(i).isDisplayed()).isTrue();
        }
    }

    @Step("assert description under images")
    public void assertDescriptionsUnderImages(int countImages) {
        Assertions.assertThat(userTablePage.descriptionsUnderImages.size()).isEqualTo(countImages);
        for (int i = 0; i < countImages; i++) {
            Assertions.assertThat(userTablePage.descriptionsUnderImages.get(i).isDisplayed()).isTrue();
        }
    }

    @Step("assert checkboxes under images")
    public void assertCheckboxesUnderImages(int countCheckboxes) {
        Assertions.assertThat(userTablePage.checkboxesUnderImages.size()).isEqualTo(countCheckboxes);
        for (int i = 0; i < countCheckboxes; i++) {
            Assertions.assertThat(userTablePage.checkboxesUnderImages.get(i).isDisplayed()).isTrue();
        }
    }

    @Step("assert number user description")
    public void assertNumberUserDescription(DataTable dataTable) {
        List<List<String>> userTable = dataTable.rows(1).cells();
        List<String> numbers = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> desc = new ArrayList<>();
        userTable.forEach(els -> {
            numbers.add(els.get(0));
            names.add(els.get(1));
            desc.add(els.get(2));
        });

        assertThat(userTablePage.numberType.stream()
                 .map(WebElement::getText)
                 .collect(Collectors.toList())).isEqualTo(numbers);

        assertThat(userTablePage.listOfUsers.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())).isEqualTo(names);

        assertThat(userTablePage.descriptionsUnderImages.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .map(n -> n.replaceAll("\\s", " "))
                .map(String::trim)
                .collect(Collectors.toList())).isEqualTo(desc);
    }

    @Step("assert dropdown contains for User Roman")
    public void assertDropListContainsValuesForUserRoman(DataTable dataTable) {

        List<String> dropdownOptions = dataTable.asList();
        for (int i = 0; i < userTablePage.firstDropdownValues.size(); i++) {
            Assertions.assertThat(userTablePage.firstDropdownValues.get(i).getText().equals(dropdownOptions.get(i)));
        }
    }

    @Step("assert logs")
    public void assertLogText(String logText) {
        By logPath = new By.ByXPath("//li[contains(. ,'" + logText + "')]");
        WebElement log = webDriver.findElement(logPath);
        Assert.assertTrue(log.isDisplayed());
    }

    public void userLogged(String user) {
        assertThat(mainPage.userLogged().equals(user.toUpperCase()));
    }

}
