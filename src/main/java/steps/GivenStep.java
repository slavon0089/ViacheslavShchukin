package steps;

import static pages.MainPage.URL_HOME_PAGE;
import static steps.AbstractStep.webDriver;

import io.cucumber.java.en.Given;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class GivenStep {
    ActionStep actionStep = new ActionStep(webDriver);
    AssertStep assertStep = new AssertStep(webDriver);

    public GivenStep(WebDriver webDriver) throws IOException {
    }

    public GivenStep() throws IOException {
    }

    @Given("I open website")
    public void openWebsite() {
        actionStep.openWebSite(URL_HOME_PAGE);
    }

    @Given("I open JDI GitHub site")
    public void openJdiGitHubWebsite() {
        actionStep.openWebSite(URL_HOME_PAGE);
    }





}
