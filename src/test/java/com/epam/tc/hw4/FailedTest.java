package com.epam.tc.hw4;

import static com.epam.tc.hw4.ExerciseTwoTest.textForLogs;
import static pages.MainPage.HOME_PAGE;
import static pages.MainPage.URL_HOME_PAGE;
import static steps.AbstractStep.difElPage;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;

public class FailedTest extends AbstractTest {
    private static int countOfImagesOnMainPage = 4;
    private static List<String> textUnderImages = List
            .of("To include good practices\nand ideas from successfulEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public FailedTest() throws IOException {
    }

    @Test (description = "this test should be failed")
    @Feature("feature - worked website")
    @Story("Story3 - broken")
    public void exercise() {
        //1. Open test site by URL
        actionStep.openWebSite(URL_HOME_PAGE);
        //2. Assert Browser title "Home Page"
        assertStep.assertBrowserTitle(HOME_PAGE);
        //3. Perform login
        actionStep.performLogin(password, password);
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
