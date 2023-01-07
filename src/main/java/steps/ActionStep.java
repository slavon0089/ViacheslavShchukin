package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.DifferentElementsPage;
import pages.MainPage;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step(" I Open test site by URL")
    public void openWebSite(String website) {
        webDriver.get(website);
    }

    @Step("I perform login")
    public void performLogin(String user, String password) {
        mainPage = new MainPage(webDriver);
        mainPage.login(user, password);
    }

    @Step("I Switch to the iframe")
    public void switchToIframe(String frame) {
        webDriver.switchTo().frame(frame);
    }

    @Step("Switch to original window back")
    public void switchToParentWindow() {
        webDriver.switchTo().parentFrame();
    }

    @Step("I open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        mainPage.headerMenu()
                .clickServiceMenu()
                .clickDifferentElements();
        difElPage = new DifferentElementsPage(webDriver);
    }

    @Step("Select checkbox")
    public void selectCheckbox(WebElement element) {
        element.click();
    }

    @Step("Select radiobutton")
    public void selectRadioButton(WebElement element) {
        element.click();
    }

    @Step("select dropdown")
    public void selectDropDownColor(WebElement element) {
        element.click();
    }
}
