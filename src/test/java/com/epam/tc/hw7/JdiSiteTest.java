package com.epam.tc.hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import jdi.DataProviderMetalsAndColors;
import jdi.JdiSite;
import jdi.entities.MetalsAndColors;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static jdi.JdiSite.*;
import static jdi.entities.User.*;


public class JdiSiteTest {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
        openHomePage();
        login(ROMAN);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }


    @Test (dataProvider = "DataProviderJson", dataProviderClass = DataProviderMetalsAndColors.class)
    public void jdiHomepageTest(MetalsAndColors metalsAndColors) {
        homePage.userName.is().text(ROMAN.getFullName());
        openMetalsAndColorsPage();
        metalsAndColorsPage.fillMetalAndColorForm(metalsAndColors);
        JdiSite.verifyResultLog(metalsAndColors);
    }


}
