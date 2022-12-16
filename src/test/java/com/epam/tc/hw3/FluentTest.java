package com.epam.tc.hw3;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class FluentTest extends ExerciseOneTest {

    @Test
    public void exercise() {
        //1. Open test site by URL
        webDriver.get(URL_HOME_PAGE);
        MainPage mainPage = new MainPage(webDriver);
        //2. Assert Browser title "Home Page"
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(HOME_PAGE);
        //3. Perform login
        mainPage.login(LOGIN_ROMAN, PASSWORD_ROMAN);

        mainPage.headerMenu().serviceMenu().differentElements();
    }
}
