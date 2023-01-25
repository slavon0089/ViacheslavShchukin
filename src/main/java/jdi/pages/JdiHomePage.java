package jdi.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import jdi.entities.User;
import jdi.forms.LoginForm;

public class JdiHomePage extends WebPage {

    @FindBy(css = ".benefit")
    public WebList benefit;

    @FindBy(id = "user-name")
    public Label userName;

    public LoginForm loginForm;

    @FindBy(id = "user-icon")
    public Icon userIcon;

    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }
}
