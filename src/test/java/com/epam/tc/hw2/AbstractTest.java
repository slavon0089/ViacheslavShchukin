package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class AbstractTest {

    public static WebDriver webDriver;
    static String XPATH_PASSWORD_INPUT = "//input[@id='password']";
    static String XPATH_LOGIN_SUBMIT = "//button[@id='login-button']";
    static String XPATH_LOGOUT_SUBMIT = "//*[@class='logout']";
    static String ID_LOGIN_NAME = "user-name";
    static String ID_FRAME = "frame";
    static String LOGIN_ROMAN = "Roman";
    static String PASSWORD_ROMAN = "Jdi1234";
    static String HOME_PAGE = "Home Page";
    static String LOGIN_ROMAN_IOVLEV = "ROMAN IOVLEV";
    static String XPATH_LOGIN_DROPDOWN = "//*[@class='dropdown uui-profile-menu']";
    static String XPATH_LOGIN_INPUT = "//input[@id='name']";
    public static String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    static WebDriverWait webDriverWait;

    @BeforeTest
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public static void browserDriverSetup() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        webDriver.quit();
        webDriver = null;
    }
}
