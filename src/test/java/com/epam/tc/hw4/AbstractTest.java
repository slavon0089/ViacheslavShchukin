package com.epam.tc.hw4;

import static steps.AbstractStep.webDriver;
import static utils.Config.getUserFullNameFromProperties;
import static utils.Config.getUserNameFromProperties;
import static utils.Config.getUserPasswordFromProperties;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import steps.ActionStep;
import steps.AssertStep;

public class AbstractTest {
    ActionStep actionStep = new ActionStep(webDriver);
    AssertStep assertStep = new AssertStep(webDriver);
    SoftAssert softAssert = new SoftAssert();

    static WebDriverWait webDriverWait;
    public static List<String> leftMenuItems =  List
            .of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    public static List<String> LIST_ITEMS_HEADER = List
            .of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    public String user = getUserNameFromProperties();
    public String password = getUserPasswordFromProperties();
    public String userFullName = getUserFullNameFromProperties();

    public AbstractTest() throws IOException {
    }

    @BeforeMethod(alwaysRun = true)
    public static void browserDriverSetup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 10);
        context.setAttribute("driver", webDriver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        softAssert.assertAll();
        webDriver.quit();
        webDriver = null;
    }
}
