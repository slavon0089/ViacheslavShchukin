package com.epam.tc.hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import java.io.IOException;
import static pages.MainPage.HOME_PAGE;
import static pages.MainPage.ID_FRAME;
import static pages.MainPage.URL_HOME_PAGE;
import static pages.MainPage.countOfImagesOnMainPage;
import static pages.MainPage.textUnderImages;

public class ExerciseOneTest extends AbstractTest {

    public ExerciseOneTest() throws IOException {
    }
    @Test(description = "first test with login")
    @Feature("feature - worked website")
    @Story("Story1")
    public void exercise() {
        //1. Open test site by URL
        actionStep.openWebSite(URL_HOME_PAGE);
        //2. Assert Browser title "Home Page"
        assertStep.assertBrowserTitle(HOME_PAGE);
        //3. Perform login
        actionStep.performLogin(user, password);
        //4. Assert Username is logged
        assertStep.assertUserIsLogged(userFullName);
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertStep.assert4HeadersItems(LIST_ITEMS_HEADER);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertStep.assert4ImagesOnIndexPageDisplayed(countOfImagesOnMainPage);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertStep.assertProperTextUnder4Images(textUnderImages);
        //8.  Assert that there is the iframe with “Frame Button” exist
        assertStep.assertIframeButtonExist();
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchToIframe(ID_FRAME);
        assertStep.assertFrameButtonIsDisplayed();
        //10. Switch to original window back
        actionStep.switchToParentWindow();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertStep.assert5itemsInLeftSectionIsDisplayed(leftMenuItems);

    }
}
