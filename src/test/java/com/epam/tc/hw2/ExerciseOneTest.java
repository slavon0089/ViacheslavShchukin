package com.epam.tc.hw2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseOneTest extends AbstractTest {


    private static String XPATH_ITEMS_IN_HEADER = " //ul[contains(@class,'uui-navigation nav ')]/li";
    private static String CSS_LEFT_MENU = ".sidebar-menu > li";
    private static String ID_FRAME_BUTTON = "frame-button";
    private static List<String> LIST_ITEMS_HEADER =  List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    private static List<String> LIST_ITEMS_LEFT_MENU =  List
            .of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");


    @Test
    public void exercise() {
        SoftAssert softAssert = new SoftAssert();
        //1. Open test site by URL_HOME_PAGE
        driver.get(URL_HOME_PAGE);
        //2. Assert Browser title "Home Page"
        softAssert.assertEquals(driver.getTitle(), HOME_PAGE);
        //3. Perform login
        WebElement loginDropdown = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLASS_LOGIN_DROPDOWN)));
        loginDropdown.click();
        WebElement loginInput = driver.findElement(By.xpath(XPATH_LOGIN_INPUT));
        loginInput.sendKeys(loginText);
        WebElement passwordInput = driver.findElement(By.cssSelector(CSS_PASSWORD_INPUT));
        passwordInput.sendKeys(passwordText);
        WebElement loginSubmit = driver.findElement(By.id(ID_LOGIN_SUBMIT));
        loginSubmit.click();
        WebElement logoutButton = driver.findElement(By.className(CLASS_LOGOUT_SUBMIT));
        softAssert.assertTrue(logoutButton.isDisplayed());
        //4. Assert Username is loggined
        WebElement loginName = driver.findElement(By.id(ID_LOGIN_NAME));
        softAssert.assertEquals(loginName.getText(), LOGIN_ROMAN_IOVLEV);
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> itemsInHeader = driver.findElements(By.xpath(XPATH_ITEMS_IN_HEADER));
        for (int i = 0; i < itemsInHeader.size(); i++) {
            softAssert.assertEquals(itemsInHeader.get(i).getText(), LIST_ITEMS_HEADER.get(i));
            softAssert.assertTrue(itemsInHeader.get(i).isDisplayed());
        }
        //6. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> listOfImages = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(listOfImages.size(), 4);
        for (int i = 0; i < listOfImages.size(); i++) {
            softAssert.assertTrue(listOfImages.get(i).isDisplayed());
        }
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> listOfTextUnderImages = driver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(listOfTextUnderImages.get(0).getText(), "To include good practices\n"
               + "and ideas from successful\nEPAM project");
        softAssert.assertEquals(listOfTextUnderImages.get(1).getText(), "To be flexible and\ncustomizable");
        softAssert.assertEquals(listOfTextUnderImages.get(2).getText(), "To be multiplatform");
        softAssert.assertEquals(listOfTextUnderImages.get(3).getText(), "Already have good base\n"
               + "(about 20 internal and\nsome external projects),\nwish to get more…");
        //8.  Assert that there is the iframe with “Frame Button” exist
        WebElement frame = driver.findElement(By.id(ID_FRAME));
        softAssert.assertTrue(frame.isDisplayed());
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame(ID_FRAME);
        WebElement frameButton = driver.findElement(By.id(ID_FRAME_BUTTON));
        softAssert.assertTrue(frameButton.isDisplayed());
        //10. Switch to original window back
        driver.switchTo().parentFrame();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftMenu = driver.findElements(By.cssSelector(CSS_LEFT_MENU));
        for (int i = 0; i < leftMenu.size(); i++) {
            softAssert.assertEquals(leftMenu.get(i).getText(), LIST_ITEMS_LEFT_MENU.get(i));
        }
        softAssert.assertAll();
    }
}
