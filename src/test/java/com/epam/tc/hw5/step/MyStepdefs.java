package com.epam.tc.hw5.step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.AbstractStep;
import steps.ActionStep;
import steps.AssertStep;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static pages.DifferentElementsPage.checkBoxWater;
import static pages.DifferentElementsPage.checkBoxWind;
import static pages.DifferentElementsPage.dropdownYellow;
import static pages.DifferentElementsPage.radioButtonSelen;
import static pages.DifferentElementsPage.textForLogsHW5;
import static pages.MainPage.HOME_PAGE;
import static pages.MainPage.URL_HOME_PAGE;

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
    public void iOpenWebsite() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        actionStep.openWebSite(URL_HOME_PAGE);
    }

    @When("I login as user Roman Iovlev")
    public void iLoginAsUserRomanIovlev() {
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
    public void iOpenDifferentElementsPage()   {
        actionStep.openDifferentElementsPage();
    }

    @And("I select checkboxes Water and Wind")
    public void iSelectCheckboxesWaterAndWind() {
        actionStep.selectCheckbox(checkBoxWater);
        actionStep.selectCheckbox(checkBoxWind);
    }

    @And("I select radiobutton Selen")
    public void iSelectRadiobuttonSelen() {
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
        assertStep.assertLogsForElements(textForLogsHW5);
    }
}
