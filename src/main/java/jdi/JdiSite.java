package jdi;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import jdi.entities.MetalsAndColors;
import jdi.entities.User;
import jdi.pages.JdiHomePage;
import jdi.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {


    @Url("/index.html")
    public static JdiHomePage homePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void openHomePage() {
        homePage.open();
    }
    public static void login(User user) {
        homePage.login(user);
    }


    public static String getUserName() {
       return homePage.getUserName();
    }

    public static void openMetalsAndColorsPage() {
        metalsAndColorsPage.open();
    }


    public static void verifyResultLog(MetalsAndColors metalsAndColors) {
        metalsAndColorsPage.assertResultLog(metalsAndColors);
    }
}
