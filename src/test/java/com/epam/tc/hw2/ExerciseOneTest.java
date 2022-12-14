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
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExerciseOneTest {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static SoftAssert softAssert;
    public static String xPathForLoginDropdown = "//*[@class='dropdown uui-profile-menu']";
    public static String xPathForLoginInput = "//input[@id='name']";
    public static String xPathForPasswordInput = "//input[@id='password']";
    public static String xPathForLoginSubmit = "//button[@id='login-button']";
    public static String xPathForLogoutSubmit = "//*[@class='logout']";
    public static String xPathForItemsInHeader = "//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]";
    public static String xPathForLeftMenu = "//*[@class='sidebar-menu left']";
    public static String idForloginName = "user-name";
    public static String idForFrame = "frame";
    public static String idForFrameButton = "frame-button";
    public static String loginText = "Roman";
    public static String passwordText = "Jdi1234";
    public static String homePage = "Home Page";
    public static String loginRomanIOVLEV = "ROMAN IOVLEV";
    public static String listItemsInHeader = "HOME\nCONTACT FORM\nSERVICE\nMETALS & COLORS";

    @BeforeTest
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public static void browserDriverSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        softAssert = new SoftAssert();
    }

    @Test
    public void exercise() {
        //1. Open test site by URL
        String URL = "https://jdi-testing.github.io/jdi-light/index.html";
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
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> itemsInHeader = driver.findElements(By.xpath(xPathForItemsInHeader));
        Assertions.assertThat(itemsInHeader.get(0).getText())
                .isEqualTo(listItemsInHeader);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> listOfImages = driver.findElements(By.className("benefit-icon"));
        Assertions.assertThat(listOfImages.size())
                .isEqualTo(4);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> listOfTextUnderImages = driver.findElements(By.className("benefit-txt"));
        Assertions.assertThat(listOfTextUnderImages.get(0).getText())
                .isEqualTo("To include good practices\nand ideas from successful\nEPAM project");
        Assertions.assertThat(listOfTextUnderImages.get(1).getText())
                .isEqualTo("To be flexible and\ncustomizable");
        Assertions.assertThat(listOfTextUnderImages.get(2).getText())
                .isEqualTo("To be multiplatform");
        Assertions.assertThat(listOfTextUnderImages.get(3).getText())
                .isEqualTo("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        //8.  Assert that there is the iframe with “Frame Button” exist
        WebElement frame = driver.findElement(By.id(idForFrame));
        boolean frameIsDisplayed = frame.isDisplayed();
        Assertions.assertThat(frameIsDisplayed)
                .isTrue();
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(idForFrame);
        WebElement frameButton = driver.findElement(By.id(idForFrameButton));
        boolean frameButtonIsDisplayed = frameButton.isDisplayed();
        Assertions.assertThat(frameButtonIsDisplayed)
                .isTrue();
        //10. Switch to original window back
        driver.switchTo().parentFrame();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement leftMenu = driver.findElement(By.xpath(xPathForLeftMenu));
        Assertions.assertThat(leftMenu.getText())
                .contains("Home")
                .contains("Contact form")
                .contains("Service")
                .contains("Metals & Colors")
                .contains("Elements packs");
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
