package pages;

import static steps.AbstractStep.webDriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class UserTablePage {
    public static String USER_TABLE_PAGE = "User Table";

    @FindBy(xpath = "//tbody//select")
    public List<WebElement> listOfDropdowns;

    @FindBy(xpath = "//tbody//a")
    public List<WebElement> listOfUsers;

    @FindBy(xpath = "//tbody//span")
    public List<WebElement> descriptionsUnderImages;

    @FindBy(xpath = "//tbody//input")
    public List<WebElement> checkboxesUnderImages;

    @FindBy(xpath = "//tr//td[1]")
    public List<WebElement> numberType;
    @FindBy(xpath = "//tbody//tr[1]//td//select//option")
    public List<WebElement> firstDropdownValues;

    @FindBy(css = ".panel-body-list.logs > li")
    public List<WebElement> logs;



    public UserTablePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void clickVipCheckBox(String checkboxOption) {
        By checkBoxElementPath = new By.ByXPath("//*[@id = '" + checkboxOption + "']");
        WebElement checkBoxValue = webDriver.findElement(checkBoxElementPath);
        checkBoxValue.click();
    }


}
