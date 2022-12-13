package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.epam.tc.hw2.ExerciseOneTest.*;

public class ExerciseTwoTest {
    public static String idForDropdownServiceMenu = "dropdown";
    public static String xPathFormenuItemDifferentElements = "//a[text()='Different elements']";
    public static String xPathForCheckBoxWater = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']";
    public static String xPathForCheckBoxWind = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']";
    public static String xPathForRadioButtonSilver = "//label[text()[contains(., ' Silver')]]/*[@type='radio']";
    public static String xPathFordropdownBlue = "//*[text()='Blue']";
    public static String xPathForLogs = "//*[@class='panel-body-list logs']";
    public static WebDriver driver;
    public String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeTest
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public static void browserDriverSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void exercise() {
        //1. Open test site by URL
        driver.get(URL);
        //2. Assert Browser title "Home Page"
        Assertions.assertThat(driver.getTitle())
                .isEqualTo(homePage);
        //3. Perform login
        WebElement loginDropdown = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathForLoginDropdown)));
        loginDropdown.click();
        WebElement loginInput = driver.findElement(By.xpath(xPathForLoginInput));
        loginInput.sendKeys(loginText);
        WebElement passwordInput = driver.findElement(By.xpath(xPathForPasswordInput));
        passwordInput.sendKeys(passwordText);
        WebElement loginSubmit = driver.findElement(By.xpath(xPathForLoginSubmit));
        loginSubmit.click();
        WebElement logoutButton = driver.findElement(By.xpath(xPathForLogoutSubmit));
        boolean logoutButtonIsDisplayed = logoutButton.isDisplayed();
        Assertions.assertThat(logoutButtonIsDisplayed)
                .isTrue();
        //4. Assert Username is loggined
        WebElement loginName = driver.findElement(By.id(idForloginName));
        Assertions.assertThat(loginName.getText())
                .isEqualTo(loginRomanIOVLEV);
        //5. Open through the header menu Service -> Different Elements Page
        WebElement dropdownServiceMenu = driver.findElement(By.className(idForDropdownServiceMenu));
        dropdownServiceMenu.click();
        WebElement menuItemDifferentElements = driver.findElement(By.xpath(xPathFormenuItemDifferentElements));
        menuItemDifferentElements.click();
        Assertions.assertThat(driver.getTitle())
                .isEqualTo("Different Elements");
        //6. Select checkboxes
        WebElement checkBoxWater = driver.findElement(By.xpath(xPathForCheckBoxWater));
        checkBoxWater.click();
        WebElement checkBoxWind = driver.findElement(By.xpath(xPathForCheckBoxWind));
        checkBoxWind.click();
        boolean statusCheckBoxWater = checkBoxWater.isSelected();
        boolean statusCheckBoxWind = checkBoxWind.isSelected();
        Assertions.assertThat(statusCheckBoxWater)
                .isTrue();
        Assertions.assertThat(statusCheckBoxWind)
                .isTrue();
        //7. Select radio
        WebElement radioButtonSilver = driver.findElement(By.xpath(xPathForRadioButtonSilver));
        radioButtonSilver.click();
        boolean statusRadioButtons = radioButtonSilver.isSelected();
        Assertions.assertThat(statusRadioButtons)
                .isTrue();
        //8. Select in dropdown
        WebElement dropdown = driver.findElement(By.xpath(xPathFordropdownBlue));
        dropdown.click();
        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        WebElement logs = driver.findElement(By.xpath(xPathForLogs));
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
