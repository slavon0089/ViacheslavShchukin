package com.epam.tc.hw3;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class ExerciseOneTest extends AbstractTest {

    private static String MENU_LIST = "HOME\nCONTACT FORM\nSERVICE\nMETALS & COLORS";
    private static int countOfImagesOnMainPage = 4;
    private static List<String> textUnderImages = new ArrayList<>() {{
            add("To include good practices\nand ideas from successful\nEPAM project");
            add("To be flexible and\ncustomizable");
            add("To be multiplatform");
            add("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
        }};

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
        Assertions.assertThat(mainPage.userLogged()).isTrue();
        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        Assertions.assertThat(mainPage.menuList()).isEqualTo(MENU_LIST);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        Assertions.assertThat(mainPage.listOfImages.size()).isEqualTo(countOfImagesOnMainPage);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        for (int i = 0; i < mainPage.listOfTextUnderImages.size() - 1; i++) {
            Assertions.assertThat(mainPage.listOfTextUnderImages.get(i).getText()).isEqualTo(textUnderImages.get(i));
        }
        //8.  Assert that there is the iframe with “Frame Button” exist
        Assertions.assertThat(mainPage.frame.isDisplayed()).isTrue();
        //9.  Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(ID_FRAME);
        Assertions.assertThat(mainPage.frameButton.isDisplayed()).isTrue();
        //10. Switch to original window back
        webDriver.switchTo().parentFrame();
        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        for (int i = 0; i < mainPage.leftMenu.size() - 1; i++) {
            Assertions.assertThat(mainPage.leftMenu.get(i).getText()).isEqualTo(leftMenuItems.get(i));
        }
    }
}
