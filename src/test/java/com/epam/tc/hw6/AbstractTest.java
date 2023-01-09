package com.epam.tc.hw6;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import steps.ActionStep;
import steps.AssertStep;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static steps.AbstractStep.webDriver;
import static utils.Config.getUserFullNameFromProperties;
import static utils.Config.getUserNameFromProperties;
import static utils.Config.getUserPasswordFromProperties;

public class AbstractTest {
    public static List<String> leftMenuItems = List
            .of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    public static List<String> LIST_ITEMS_HEADER = List
            .of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    static WebDriverWait webDriverWait;
    public String user = getUserNameFromProperties();
    public String password = getUserPasswordFromProperties();
    public String userFullName = getUserFullNameFromProperties();
    ActionStep actionStep = new ActionStep(webDriver);
    AssertStep assertStep = new AssertStep(webDriver);
    SoftAssert softAssert = new SoftAssert();

    public AbstractTest() throws IOException {
    }

    @BeforeClass
    @Parameters({"isLocal", "hub", "browser"})
    public void beforeClass(@Optional("false") final boolean isLocal, final String hub, final String browser) {
        webDriver = DriverFabric.getWebDriver(isLocal, hub, browser);
    }

    @BeforeMethod(alwaysRun = true)
    public static void browserDriverSetup(ITestContext context) {
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
