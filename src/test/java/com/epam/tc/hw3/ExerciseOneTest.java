package com.epam.tc.hw3;

import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

public class ExerciseOneTest extends AbstractTest {

    private static  String ID_FRAME = "frame";
    private static int countOfImagesOnMainPage = 4;
    private static List<String> textUnderImages = List
            .of("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public ExerciseOneTest() throws IOException {
    }

    @Test
    public void exercise() {
        SoftAssert softAssert = new SoftAssert();
        //1. Open test site by URL
        webDriver.get(URL_HOME_PAGE);
        MainPage mainPage = new MainPage(webDriver);
        //2. Assert Browser title "Home Page"
        softAssert.assertEquals(webDriver.getTitle(), HOME_PAGE);
        //3. Perform login
        mainPage.login(user, password);
        //4. Assert Username is loggined
        softAssert.assertEquals(mainPage.userLogged(), LOGIN_ROMAN_IOVLEV);
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        for (int i = 0; i < LIST_ITEMS_HEADER.size(); i++) {
            softAssert.assertEquals(mainPage.menuList().get(i).getText(), LIST_ITEMS_HEADER.get(i));
            softAssert.assertTrue(mainPage.menuList().get(i).isDisplayed());
        }
        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(mainPage.listOfImages.size(), countOfImagesOnMainPage);
        for (int i = 0; i < countOfImagesOnMainPage; i++) {
            softAssert.assertTrue(mainPage.listOfImages.get(i).isDisplayed());
        }
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        for (int i = 0; i < mainPage.listOfTextUnderImages.size() - 1; i++) {
            softAssert.assertEquals(mainPage.listOfTextUnderImages.get(i).getText(), textUnderImages.get(i));
        }
        //8.  Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(mainPage.frame.isDisplayed());
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(ID_FRAME);
        softAssert.assertTrue(mainPage.frameButton.isDisplayed());
        //10. Switch to original window back
        webDriver.switchTo().parentFrame();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        for (int i = 0; i < mainPage.leftMenu.size() - 1; i++) {
            softAssert.assertEquals(mainPage.leftMenu.get(i).getText(), leftMenuItems.get(i));
        }
        softAssert.assertAll();
    }
}
