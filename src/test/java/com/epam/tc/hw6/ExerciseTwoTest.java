package com.epam.tc.hw6;

//import static pages.DifferentElementsPage.checkBoxWater;
//import static pages.DifferentElementsPage.checkBoxWind;
//import static pages.DifferentElementsPage.dropdownBlue;
//import static pages.DifferentElementsPage.radioButtonSilver;
//import static pages.DifferentElementsPage.textForLogs;
import static pages.MainPage.HOME_PAGE;
import static pages.MainPage.URL_HOME_PAGE;
import static steps.AbstractStep.difElPage;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;


public class ExerciseTwoTest extends AbstractTest {
    public static List<String> textForLogs = List
        .of("Colors: value changed to Blue",
            "metal: value changed to Silver",
            "Wind: condition changed to true",
            "Water: condition changed to true");

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
        actionStep.selectCheckbox(difElPage.checkBoxWater);
        actionStep.selectCheckbox(difElPage.checkBoxWind);
        //7. Select radio
        actionStep.selectRadioButton(difElPage.radioButtonSilver);
        //8. Select in dropdown
        actionStep.selectDropDownColor(difElPage.dropdownBlue);
        //9. Assert that
        //• for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //• for radio button there is a log row and value is corresponded to the status of radio button
        //• for dropdown there is a log row and value is corresponded to the selected value.
        assertStep.assertElementIsSelected(difElPage.checkBoxWater);
        assertStep.assertElementIsSelected(difElPage.checkBoxWind);
        assertStep.assertElementIsSelected(difElPage.radioButtonSilver);
        assertStep.assertElementIsSelected(difElPage.dropdownBlue);
        assertStep.assertLogsForElements(textForLogs);
    }
}
