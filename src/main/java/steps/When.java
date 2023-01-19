package steps;

import static steps.AbstractStep.difElPage;
import static steps.AbstractStep.webDriver;

import io.qameta.allure.Step;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import pages.ServiceMenu;

public class When extends AbstractStep{
    ActionStep actionStep = new ActionStep(webDriver);


    public When(WebDriver webDriver) throws IOException {
        super(webDriver);
    }

    @Step("I login as user Roman Iovlev")
    public void loginAsUserRomanIovlev(String user, String password) {
        actionStep.performLogin(user, password);
    }

    @Step("I open Different Elements Page")
    public void openDifferentElementsPage()   {
        actionStep.openDifferentElementsPage();
    }

    @Step("I select checkboxes Water and Wind")
    public void selectCheckboxesWaterAndWind() {
        actionStep.selectCheckbox(difElPage.checkBoxWater);
        actionStep.selectCheckbox(difElPage.checkBoxWind);
    }
    @Step("I select radiobutton Selen")
    public void selectRadiobuttonSelen() {
        actionStep.selectRadioButton(difElPage.radioButtonSelen);
    }
    @Step("select dropdown Yellow")
    public void selectDropdownYellow() {
        actionStep.selectDropDownColor(difElPage.dropdownYellow);
    }
    @Step("I login as user {string}")
    public void loginAsUser(String user) throws IOException {
        actionStep.loginAsUser(user);
    }
    @Step("I click on button in Header")
    public void clickOnButtonInHeader(String item) {
                actionStep.clickMenuItem(item);
                serviceMenu = new ServiceMenu(webDriver);
    }
    @Step("I click on button in Service dropdown")
    public void clickOnButtonInServiceDropdown(String item) {
        actionStep.clickServiceMenuItem(item);
    }

    @Step("I select vip checkbox for ")
    public void selectVipCheckboxFor(String name) {
        actionStep.selectOneVipCheckbox(name);
    }
}
