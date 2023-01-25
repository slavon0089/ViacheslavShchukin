package com.epam.tc.hw7;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import jdi.DataProviderMetalsAndColors;
import jdi.JdiSite;
import jdi.entities.MetalsAndColors;
import jdi.entities.User;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class JdiSiteTest {
    public static final User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
        JdiSite.openHomePage();
        JdiSite.login(ROMAN);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }


    @Test (dataProvider = "DataProviderJson", dataProviderClass = DataProviderMetalsAndColors.class)
    public void jdiHomepageTest(MetalsAndColors metalsAndColors) {
        JdiSite.homePage.userName.is().text(ROMAN.getFullName());
        JdiSite.openMetalsAndColorsPage();
        JdiSite.metalsAndColorsPage.fillMetalAndColorForm(metalsAndColors);
        JdiSite.verifyResultLog(metalsAndColors);
    }


}
