package jdi;


import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(User user) {
       jdiHomePage.login(user);
    }


}
