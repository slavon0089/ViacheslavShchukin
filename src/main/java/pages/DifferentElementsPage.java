package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

public class DifferentElementsPage {

    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    public static WebElement checkBoxWater;

    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    public static WebElement checkBoxWind;

    @FindBy(xpath = "//label[text()[contains(., ' Silver')]]/*[@type='radio']")
    public static WebElement radioButtonSilver;

    @FindBy(xpath = "//*[text()='Blue']")
    public static WebElement dropdownBlue;

    @FindBy(css = ".panel-body-list.logs > li")
    public List<WebElement> logs;

    WaitActions waitActions;

    public static List<String> textForLogs = List
            .of("Colors: value changed to Blue",
                    "metal: value changed to Silver",
                    "Wind: condition changed to true",
                    "Water: condition changed to true");

    public DifferentElementsPage(WebDriver driver1) {
        PageFactory.initElements(driver1, this);
        waitActions = new WaitActions(driver1);
    }


}
