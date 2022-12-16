package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ServiceMenu {
    @FindBy(xpath = "//li/a[text()='Support")
    private WebElement support;
    @FindBy(xpath = "//li/a[text()='Different elements']")
    private WebElement differentElements;

    public ServiceMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void differentElements() {
        differentElements.click();
    }

    public void support() {
        support.click();
    }

}
