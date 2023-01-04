package Steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import java.io.IOException;

import static pages.MainPage.ID_FRAME;
import static pages.MainPage.URL_HOME_PAGE;

public class ActionStep extends AbstractStep{
    public MainPage mainPage;

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step(" I Open test site by URL")
    public void openWebSite(String website){
        webDriver.get(website);
    }
    @Step("I perform login")
    public void performLogin(String user, String password){
      mainPage = new MainPage(webDriver);
        mainPage.login(user, password);
    }

    @Step("I Switch to the iframe")
    public void switchToIframe(String frame){
        webDriver.switchTo().frame(frame);
    }

    @Step("Switch to original window back")
    public void switchToParentWindow(){
        webDriver.switchTo().parentFrame();
    }
}
