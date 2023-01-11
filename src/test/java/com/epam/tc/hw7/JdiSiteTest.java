package com.epam.tc.hw7;

import com.epam.jdi.light.elements.init.PageFactory;
import jdi.JdiSite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static jdi.User.roman;


public class JdiSiteTest {
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

//    @AfterSuite(alwaysRun = true)
//    public void afterSuite() {
//        WebDriverUtils.killAllSeleniumDrivers();
//    }


    @Test
    public void jdiHomepageTest() {
        JdiSite.open();
        //Login on JDI site as User
        JdiSite.jdiHomePage.login(roman);
        JdiSite.jdiHomePage.loggedUser.is().text(roman.name);
        //Open Metals & Colors page by Header menu
        JdiSite.jdiHomePage.openPageMetalsAndColors();



    }


}
