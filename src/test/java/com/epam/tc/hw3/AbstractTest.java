package com.epam.tc.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class AbstractTest {

    public static WebDriver webDriver;
    public static String URL_HOME_PAGE = "https://jdi-testing.github.io/jdi-light/index.html";
    static String ID_FRAME = "frame";
    static String LOGIN_ROMAN = "Roman";
    static String PASSWORD_ROMAN = "Jdi1234";
    static String HOME_PAGE = "Home Page";
    static WebDriverWait webDriverWait;
    public static List<String> leftMenuItems = new ArrayList<>() {{
            add("Home");
            add("Contact form");
            add("Service");
            add("Metals & Colors");
            add("Elements packs");
            }};

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
