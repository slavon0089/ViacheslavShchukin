package steps;

import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;

public class AssertStep extends AbstractStep {

    public AssertStep(WebDriver driver) {
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
}
