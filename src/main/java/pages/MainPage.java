package pages;

import static steps.AbstractStep.webDriver;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitActions;

public class MainPage {

    public static int countOfImagesOnMainPage = 4;
    public static List<String> textUnderImages = List
            .of("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    public static String ID_FRAME = "frame";
    public static String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    public static String HOME_PAGE = "Home Page";
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
    WaitActions waitActions;
    private HeaderMenu headerMenu;
    @FindBy(xpath = "//*[@class='dropdown uui-profile-menu']")
    private WebElement loginDropdown;
    @FindBy(id = "name")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginSubmit;
    @FindBy(id = "user-name")
    private WebElement loginName;
    @FindBy(xpath = "//ul[contains(@class,'uui-navigation nav ')]/li")
    private List<WebElement> itemsInHeader;

    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderItem;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        waitActions = new WaitActions(driver);
        headerMenu = new HeaderMenu(driver);
    }

    @Step("login with username and password")
    public void login(String user, String password) {
        loginDropdown.click();
        loginInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginSubmit.click();
    }

    @Step("get logged user name")
    public String userLogged() {

        return loginName.getText();
    }

    @Step("get list of header menu")
    public List<WebElement> menuList() {
        return itemsInHeader;
    }

    public HeaderMenu headerMenu() {
        return headerMenu;
    }

    public void clickOnServiceItem() {
        serviceHeaderItem.click();
    }

    public void clickServiceMenuItem(String item) {
        By serviceMenuItemPath = new By.ByXPath("//a[contains(text(),'" + item + "')]");
        WebElement serviceMenuItem = webDriver.findElement(serviceMenuItemPath);
        serviceMenuItem.click();
    }
}
