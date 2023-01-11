package jdi;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import org.openqa.selenium.support.FindBy;

public class JdiHomePage extends WebPage {



    @FindBy(className = "profile-photo")
    public Icon loginIcon;

    @FindBy(id = "user-name")
    public Label loggedUser;

    @Css("form")
    public static LoginForm loginform;



    public void login(User user){
        loginIcon.click();
        loginform.login(user);
    }

    public void openPageMetalsAndColors(){
        JdiSite.metalsAndColorsPage.open();
    }
}
