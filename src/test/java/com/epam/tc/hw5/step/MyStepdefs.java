package com.epam.tc.hw5.step;

import com.epam.tc.hw4.AbstractTest;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.AbstractStep;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static pages.MainPage.URL_HOME_PAGE;

public class MyStepdefs extends AbstractStep {


    public MyStepdefs(WebDriver webDriver) {
        super(webDriver);
    }

    public MyStepdefs() {
        super(webDriver);
    }

    @Given("I open website")
    public void iOpenWebsite() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get(URL_HOME_PAGE);
    }
}
