package steps;

import io.cucumber.java.en.When;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import pages.ServiceMenu;

public class WhenStep extends AbstractStep {
    ActionStep actionStep = new ActionStep(webDriver);


    public WhenStep(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    public WhenStep() throws IOException {
        super(webDriver);
    }

    @When("I login as user Roman Iovlev")
    public void loginAsUserRomanIovlev() {
        actionStep.performLogin(user, password);
    }

    @When("I open Different Elements Page")
    public void openDifferentElementsPage()   {
        actionStep.openDifferentElementsPage();
    }

    @When("I select checkboxes Water and Wind")
    public void selectCheckboxesWaterAndWind() {
        actionStep.selectCheckbox(difElPage.checkBoxWater);
        actionStep.selectCheckbox(difElPage.checkBoxWind);
    }

    @When("I select radiobutton Selen")
    public void selectRadiobuttonSelen() {
        actionStep.selectRadioButton(difElPage.radioButtonSelen);
    }

    @When("select dropdown Yellow")
    public void selectDropdownYellow() {
        actionStep.selectDropDownColor(difElPage.dropdownYellow);
    }

    @When("I login as user {string}")
    public void loginAsUser(String user) throws IOException {
        actionStep.loginAsUser(user);
    }

    @When("I click on {string} button in Header")
    public void clickOnButtonInHeader(String item) {
        actionStep.clickMenuItem(item);
        serviceMenu = new ServiceMenu(webDriver);
    }

    @When("I click on {string} button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String item) {
        actionStep.clickServiceMenuItem(item);
    }

    @When("I select vip checkbox for {string}")
    public void selectVipCheckboxFor(String name) {
        actionStep.selectOneVipCheckbox(name);
    }
}
