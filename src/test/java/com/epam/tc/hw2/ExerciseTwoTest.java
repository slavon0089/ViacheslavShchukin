package com.epam.tc.hw2;

import static com.epam.tc.hw2.ExerciseOneTest.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ExerciseTwoTest {
    private static String ID_DROPDOWN_SERVICE_MENU = "dropdown";
    private static String XPATH_MENU_ITEM_DIFFERENT_ELEMENT = "//a[text()='Different elements']";
    private static String XPATH_CHECKBOX_WATER = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']";
    private static String XPATH_CHECKBOX_WIND = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']";
    private static String XPATH_RADIOBUTTON_SILVER = "//label[text()[contains(., ' Silver')]]/*[@type='radio']";
    private static String XPATH_DROPDOWN_BLUE = "//*[text()='Blue']";
    private static String XPATH_LOGS = "//*[@class='panel-body-list logs']";

    @BeforeTest
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public static void browserDriverSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void exercise() {
        //1. Open test site by URL
        driver.get(URL_HOME_PAGE);
        //2. Assert Browser title "Home Page"
        Assertions.assertThat(driver.getTitle())
                .isEqualTo(HOME_PAGE);
        //3. Perform login
        WebElement loginDropdown = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_LOGIN_DROPDOWN)));
        loginDropdown.click();
        WebElement loginInput = driver.findElement(By.xpath(XPATH_LOGIN_INPUT));
        loginInput.sendKeys(loginText);
        WebElement passwordInput = driver.findElement(By.xpath(XPATH_PASSWORD_INPUT));
        passwordInput.sendKeys(passwordText);
        WebElement loginSubmit = driver.findElement(By.xpath(XPATH_LOGIN_SUBMIT));
        loginSubmit.click();
        WebElement logoutButton = driver.findElement(By.xpath(XPATH_LOGOUT_SUBMIT));
        boolean logoutButtonIsDisplayed = logoutButton.isDisplayed();
        Assertions.assertThat(logoutButtonIsDisplayed)
                .isTrue();
        //4. Assert Username is loggined
        WebElement loginName = driver.findElement(By.id(ID_LOGIN_NAME));
        Assertions.assertThat(loginName.getText())
                .isEqualTo(LOGIN_ROMAN_IOVLEV);
        //5. Open through the header menu Service -> Different Elements Page
        WebElement dropdownServiceMenu = driver.findElement(By.className(ID_DROPDOWN_SERVICE_MENU));
        dropdownServiceMenu.click();
        WebElement menuItemDifferentElements = driver.findElement(By.xpath(XPATH_MENU_ITEM_DIFFERENT_ELEMENT));
        menuItemDifferentElements.click();
        Assertions.assertThat(driver.getTitle())
                .isEqualTo("Different Elements");
        //6. Select checkboxes
        WebElement checkBoxWater = driver.findElement(By.xpath(XPATH_CHECKBOX_WATER));
        checkBoxWater.click();
        WebElement checkBoxWind = driver.findElement(By.xpath(XPATH_CHECKBOX_WIND));
        checkBoxWind.click();
        boolean statusCheckBoxWater = checkBoxWater.isSelected();
        boolean statusCheckBoxWind = checkBoxWind.isSelected();
        Assertions.assertThat(statusCheckBoxWater)
                .isTrue();
        Assertions.assertThat(statusCheckBoxWind)
                .isTrue();
        //7. Select radio
        WebElement radioButtonSilver = driver.findElement(By.xpath(XPATH_RADIOBUTTON_SILVER));
        radioButtonSilver.click();
        boolean statusRadioButtons = radioButtonSilver.isSelected();
        Assertions.assertThat(statusRadioButtons)
                .isTrue();
        //8. Select in dropdown
        WebElement dropdown = driver.findElement(By.xpath(XPATH_DROPDOWN_BLUE));
        dropdown.click();
        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        WebElement logs = driver.findElement(By.xpath(XPATH_LOGS));
        Assertions.assertThat(logs.getText())
                .contains("Water")
                .contains("Wind")
                .contains("Silver")
                .contains("Blue");
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
