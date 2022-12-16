package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

public class DifferentElementsPage {

    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    public WebElement checkBoxWater;
    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    public WebElement checkBoxWind;
    @FindBy(xpath = "//label[text()[contains(., ' Silver')]]/*[@type='radio']")
    public WebElement radioButtonSilver;
    @FindBy(xpath = "//*[text()='Blue']")
    public WebElement dropdownBlue;
    @FindBy(xpath = "//*[@class='panel-body-list logs']")
    public WebElement logs;
    WaitActions waitActions;

    public DifferentElementsPage(WebDriver driver1) {
        PageFactory.initElements(driver1, this);
        waitActions = new WaitActions(driver1);
    }


}
