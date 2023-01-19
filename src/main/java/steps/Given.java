package steps;

import static steps.AbstractStep.difElPage;
import static steps.AbstractStep.webDriver;

import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import pages.DifferentElementsPage;

public class Given {
    ActionStep actionStep = new ActionStep(webDriver);
    AssertStep assertStep = new AssertStep(webDriver);

    public Given(WebDriver webDriver) throws IOException {
    }

    public Given() throws IOException {
    }

    @Step("I open website")
    public void openWebsite(String URL) {
        actionStep.openWebSite(URL);
    }

    @Step("I open JDI GitHub site")
    public void openJdiGitHubWebsite(String URL) {
        actionStep.openWebSite(URL);
    }





}
