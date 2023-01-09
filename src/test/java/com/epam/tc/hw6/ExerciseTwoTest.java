package com.epam.tc.hw6;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.io.IOException;

import static pages.DifferentElementsPage.checkBoxWater;
import static pages.DifferentElementsPage.checkBoxWind;
import static pages.DifferentElementsPage.dropdownBlue;
import static pages.DifferentElementsPage.radioButtonSilver;
import static pages.DifferentElementsPage.textForLogs;
import static pages.MainPage.HOME_PAGE;
import static pages.MainPage.URL_HOME_PAGE;

public class ExerciseTwoTest extends AbstractTest {

    public ExerciseTwoTest() throws IOException {
    }

    @Test  (description = "second test with login")
    @Description(value = "second test with login, menu and new page")
    @Feature("feature - worked website")
    @Story("Story2")
    public void exercise()  {
        //1. Open test site by URL
        actionStep.openWebSite(URL_HOME_PAGE);
        //2. Assert Browser title "Home Page"
        assertStep.assertBrowserTitle(HOME_PAGE);
        //3. Perform login
        actionStep.performLogin(user, password);
        //4. Assert Username is logged
        assertStep.assertUserIsLogged(userFullName);
        //5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();
        //6. Select checkboxes
        actionStep.selectCheckbox(checkBoxWater);
        actionStep.selectCheckbox(checkBoxWind);
        //7. Select radio
        actionStep.selectRadioButton(radioButtonSilver);
        //8. Select in dropdown
        actionStep.selectDropDownColor(dropdownBlue);
        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        assertStep.assertElementIsSelected(checkBoxWater);
        assertStep.assertElementIsSelected(checkBoxWind);
        assertStep.assertElementIsSelected(radioButtonSilver);
        assertStep.assertElementIsSelected(dropdownBlue);
        assertStep.assertLogsForElements(textForLogs);
    }
}
