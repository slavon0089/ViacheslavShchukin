package jdi.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import jdi.entities.User;

public class LoginForm extends Form<User> {
    @FindBy(id = "name")
    public TextField name;

    @FindBy(id = "password")
    public TextField password;

    @FindBy(id = "login-button")
    public Button submit;


}
