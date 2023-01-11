package jdi;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @Css("#name")
    public TextField login;

    @Css("#password")
    public TextField password;

    @Css("[type=submit]")
    public Button submit;
}
