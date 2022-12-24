package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

public class HeaderMenu {
    WaitActions waitActions;
    private ServiceMenu serviceMenu;

    @FindBy(xpath = "//li[a='Home']")
    private WebElement homeMenu;

    @FindBy(xpath = "//li[a='Contact form']")
    private WebElement contactFormMenu;

    @FindBy(xpath = "//li[@class='dropdown']")
    private WebElement serviceSubMenu;

    @FindBy(xpath = "//li[a='Metals & Colors']")
    private WebElement metalsAndColoursMenu;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
        serviceMenu = new ServiceMenu(driver);
    }

    public void clickHomeMenu() {
        homeMenu.click();
    }

    public void clickContactFormMenu() {
        contactFormMenu.click();
    }

    public ServiceMenu clickServiceMenu() {
        serviceSubMenu.click();
        return serviceMenu;
    }

    public void clickMetalsAndColoursMenu() {
        metalsAndColoursMenu.click();
    }
}


