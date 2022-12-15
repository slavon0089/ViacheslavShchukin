package pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

import java.util.List;

public class MainPage {

    WaitActions waitActions;
    private List<WebElement> suggestionList;
    @FindBy(xpath = "//*[@class='dropdown uui-profile-menu']")
    private WebElement loginDropdown;
    @FindBy(id = "name")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginSubmit;

    @FindBy(xpath = "//*[@class='logout']")
    private WebElement logoutButton;

    @FindBy(id = "user-name")
    private WebElement loginName;

    @FindBy(xpath = "//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]")
    private List<WebElement> horizontalMenu;

    @FindBy(className = "benefit-icon")
    public List<WebElement> listOfImages;

    @FindBy(className = "benefit-txt")
    public List<WebElement> listOfTextUnderImages;

    @FindBy(id = "frame")
    public WebElement frame;

    @FindBy(id = "frame-button")
    public WebElement frameButton;

    @FindBy(xpath = "//*[@class='sidebar-menu left']/li")
    public List<WebElement> leftMenu;
    @FindBy(className = "dropdown")
    public WebElement dropdownServiceMenu;

    @FindBy(xpath = "//a[text()='Different elements']")
    public WebElement DifferentElements;
    public MainPage(WebDriver driver1) {
        PageFactory.initElements(driver1, this);
        waitActions = new WaitActions(driver1);
    }

    public void login(String login, String password){

        loginDropdown.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginSubmit.click();
    }
    public boolean userLogged (){
        loginName.getText();
        boolean loginNameIsDisplayed = loginName.isDisplayed();
        return loginNameIsDisplayed;
    }
    public String menuList(){
        return horizontalMenu.get(0).getText();
    }

    public boolean frameDisplayed (){
        boolean displayedFrame = frame.isDisplayed();
        return displayedFrame;
    }
    public boolean frameButtonDisplayed (){
        boolean displayedFrameButton = frameButton.isDisplayed();
        return displayedFrameButton;
    }

    public void menuService(){
        dropdownServiceMenu.click();
    }
    public void menuItemDifferentElements(){
        DifferentElements.click();
    }
}
