package com.epam.tc.hw2;

import java.time.Duration;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExerciseOneTest extends AbstractTest {


    private static String XPATH_ITEMS_IN_HEADER = "//ul[@class=\"uui-navigation nav navbar-nav m-l8\"]";
    private static String XPATH_LEFT_MENU = "//*[@class='sidebar-menu left']";
    private static String ID_FRAME_BUTTON = "frame-button";
    private static String LIST_ITEMS_HEADER = "HOME\nCONTACT FORM\nSERVICE\nMETALS & COLORS";

    @Test
    public void exercise() {
        //1. Open test site by URL_HOME_PAGE
        driver.get(URL_HOME_PAGE);
        //2. Assert Browser title "Home Page"
        Assertions.assertThat(driver.getTitle())
                .isEqualTo(HOME_PAGE);
        //3. Perform login
        WebElement loginDropdown = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_LOGIN_DROPDOWN)));
        loginDropdown.click();
        WebElement loginInput = driver.findElement(By.xpath(XPATH_LOGIN_INPUT));
        loginInput.sendKeys(loginText);
        WebElement passwordInput = driver.findElement(By.xpath(XPATH_PASSWORD_INPUT));
        passwordInput.sendKeys(passwordText);
        WebElement loginSubmit = driver.findElement(By.xpath(XPATH_LOGIN_SUBMIT));
        loginSubmit.click();
        WebElement logoutButton = driver.findElement(By.xpath(XPATH_LOGOUT_SUBMIT));
        boolean logoutButtonIsDisplayed = logoutButton.isDisplayed();
        Assertions.assertThat(logoutButtonIsDisplayed)
                .isTrue();
        //4. Assert Username is loggined
        WebElement loginName = driver.findElement(By.id(ID_LOGIN_NAME));
        Assertions.assertThat(loginName.getText())
                .isEqualTo(LOGIN_ROMAN_IOVLEV);
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> itemsInHeader = driver.findElements(By.xpath(XPATH_ITEMS_IN_HEADER));
        Assertions.assertThat(itemsInHeader.get(0).getText())
                .isEqualTo(LIST_ITEMS_HEADER);
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
                .isEqualTo("Already have good base\n(about 20 internal and\n"
                        + "some external projects),\nwish to get more…");
        //8.  Assert that there is the iframe with “Frame Button” exist
        WebElement frame = driver.findElement(By.id(ID_FRAME));
        boolean frameIsDisplayed = frame.isDisplayed();
        Assertions.assertThat(frameIsDisplayed)
                .isTrue();
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(ID_FRAME);
        WebElement frameButton = driver.findElement(By.id(ID_FRAME_BUTTON));
        boolean frameButtonIsDisplayed = frameButton.isDisplayed();
        Assertions.assertThat(frameButtonIsDisplayed)
                .isTrue();
        //10. Switch to original window back
        driver.switchTo().parentFrame();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement leftMenu = driver.findElement(By.xpath(XPATH_LEFT_MENU));
        Assertions.assertThat(leftMenu.getText())
                .contains("Home")
                .contains("Contact form")
                .contains("Service")
                .contains("Metals & Colors")
                .contains("Elements packs");
    }
}
