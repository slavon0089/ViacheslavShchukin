package jdi;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    public String login;
    public String password;
    public String name;

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public static User roman = new User("Roman", "Jdi1234","ROMAN IOVLEV");
}
