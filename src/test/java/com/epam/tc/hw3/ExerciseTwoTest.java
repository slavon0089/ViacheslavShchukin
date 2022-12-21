package com.epam.tc.hw3;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.DifferentElementsPage;
import pages.MainPage;


public class ExerciseTwoTest extends AbstractTest {
    private static String ID_DROPDOWN_SERVICE_MENU = "dropdown";
    private static String XPATH_MENU_ITEM_DIFFERENT_ELEMENT = "//a[text()='Different elements']";
    private static String XPATH_CHECKBOX_WATER = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']";
    private static String XPATH_CHECKBOX_WIND = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']";
    private static String XPATH_RADIOBUTTON_SILVER = "//label[text()[contains(., ' Silver')]]/*[@type='radio']";
    private static String XPATH_DROPDOWN_BLUE = "//*[text()='Blue']";
    private static String XPATH_LOGS = "//*[@class='panel-body-list logs']";
    private static String DifferentElementsText = "Different Elements";


    @Test
    public void exercise() {
        //1. Open test site by URL
        webDriver.get(URL_HOME_PAGE);
        MainPage mainPage = new MainPage(webDriver);
        //2. Assert Browser title "Home Page"
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(HOME_PAGE);
        //3. Perform login
        mainPage.login(LOGIN_ROMAN, PASSWORD_ROMAN);
        //4. Assert Username is loggined
        Assertions.assertThat(mainPage.userLogged()).isEqualTo(LOGIN_ROMAN_IOVLEV);
        //5. Open through the header menu Service -> Different Elements Page
        mainPage.headerMenu()
                .serviceMenu()
                .differentElements();
        //6. Select checkboxes
        DifferentElementsPage difElPage = new DifferentElementsPage(webDriver);
        difElPage.checkBoxWater.click();
        difElPage.checkBoxWind.click();
        //7. Select radio
        difElPage.radioButtonSilver.click();
        //8. Select in dropdown
        difElPage.dropdownBlue.click();
        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        Assertions.assertThat(difElPage.logs.getText())
                .contains("Water")
                .contains("Wind")
                .contains("Silver")
                .contains("Blue");
    }
}
