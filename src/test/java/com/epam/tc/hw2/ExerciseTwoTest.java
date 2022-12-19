package com.epam.tc.hw2;

//import static com.epam.tc.hw2.ExerciseOneTest.*;
import java.time.Duration;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class ExerciseTwoTest extends AbstractTest {
    private static String ID_DROPDOWN_SERVICE_MENU = "dropdown";
    private static String XPATH_MENU_ITEM_DIFFERENT_ELEMENT = "//a[text()='Different elements']";
    private static String XPATH_CHECKBOX_WATER = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']";
    private static String XPATH_CHECKBOX_WIND = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']";
    private static String XPATH_RADIOBUTTON_SILVER = "//label[text()[contains(., ' Silver')]]/*[@type='radio']";
    private static String XPATH_DROPDOWN_BLUE = "//*[text()='Blue']";
    private static String XPATH_LOGS = "//*[@class='panel-body-list logs']/li";

    @Test
    public void exercise() {
        //1. Open test site by URL
        driver.get(URL_HOME_PAGE);
        //2. Assert Browser title "Home Page"
        Assertions.assertThat(driver.getTitle()).isEqualTo(HOME_PAGE);
        //3. Perform login
        WebElement loginDropdown = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLASS_LOGIN_DROPDOWN)));
        loginDropdown.click();
        WebElement loginInput = driver.findElement(By.xpath(XPATH_LOGIN_INPUT));
        loginInput.sendKeys(loginText);
        WebElement passwordInput = driver.findElement(By.cssSelector(CSS_PASSWORD_INPUT));
        passwordInput.sendKeys(passwordText);
        WebElement loginSubmit = driver.findElement(By.id(ID_LOGIN_SUBMIT));
        loginSubmit.click();
        WebElement logoutButton = driver.findElement(By.className(CLASS_LOGOUT_SUBMIT));
               Assertions.assertThat(logoutButton.isDisplayed()).isTrue();
        //4. Assert Username is loggined
        WebElement loginName = driver.findElement(By.id(ID_LOGIN_NAME));
        Assertions.assertThat(loginName.getText())
                .isEqualTo(LOGIN_ROMAN_IOVLEV);
        //5. Open through the header menu Service -> Different Elements Page
        WebElement dropdownServiceMenu = driver.findElement(By.className(ID_DROPDOWN_SERVICE_MENU));
        dropdownServiceMenu.click();
        WebElement menuItemDifferentElements = driver.findElement(By.xpath(XPATH_MENU_ITEM_DIFFERENT_ELEMENT));
        menuItemDifferentElements.click();
        Assertions.assertThat(driver.getTitle()).isEqualTo("Different Elements");
        //6. Select checkboxes
        WebElement checkBoxWater = driver.findElement(By.xpath(XPATH_CHECKBOX_WATER));
        checkBoxWater.click();
        WebElement checkBoxWind = driver.findElement(By.xpath(XPATH_CHECKBOX_WIND));
        checkBoxWind.click();
        //7. Select radio
        WebElement radioButtonSilver = driver.findElement(By.xpath(XPATH_RADIOBUTTON_SILVER));
        radioButtonSilver.click();
        //8. Select in dropdown
        WebElement dropdownBlue = driver.findElement(By.xpath(XPATH_DROPDOWN_BLUE));
        dropdownBlue.click();
        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> logs = driver.findElements(By.xpath(XPATH_LOGS));
        Assertions.assertThat(checkBoxWater.isSelected()).isTrue();
        Assertions.assertThat(checkBoxWind.isSelected()).isTrue();
        Assertions.assertThat(radioButtonSilver.isSelected()).isTrue();
        Assertions.assertThat(dropdownBlue.isSelected()).isTrue();
        Assertions.assertThat(logs.get(3).getText()).contains("Water: condition changed to true");
        Assertions.assertThat(logs.get(2).getText()).contains("Wind: condition changed to true");
        Assertions.assertThat(logs.get(1).getText()).contains("metal: value changed to Silver");
        Assertions.assertThat(logs.get(0).getText()).contains("Colors: value changed to Blue");

    }
}
