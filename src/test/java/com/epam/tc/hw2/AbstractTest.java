package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class AbstractTest {

    public WebDriver driver;
    static String CSS_PASSWORD_INPUT = "input[id='password']";

    static String ID_LOGIN_SUBMIT = "login-button";
    static String CLASS_LOGOUT_SUBMIT = "logout";
    static String ID_LOGIN_NAME = "user-name";
    static String ID_FRAME = "frame";
    static String loginText = "Roman";
    static String passwordText = "Jdi1234";
    static String HOME_PAGE = "Home Page";
    static String LOGIN_ROMAN_IOVLEV = "ROMAN IOVLEV";
    static String CLASS_LOGIN_DROPDOWN = "//*[@class='dropdown uui-profile-menu']";
    static String XPATH_LOGIN_INPUT = "//input[@id='name']";
    public static String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeTest
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void browserDriverSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
