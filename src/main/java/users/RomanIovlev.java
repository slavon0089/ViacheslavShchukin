package users;

import static utils.Config.getUserFullNameFromProperties;
import static utils.Config.getUserNameFromProperties;
import static utils.Config.getUserPasswordFromProperties;

import java.io.IOException;


public class RomanIovlev {


    public String userName = getUserNameFromProperties();
    public String password = getUserPasswordFromProperties();
    public String romanFullName = getUserFullNameFromProperties();

    public RomanIovlev() throws IOException {
    }

    public RomanIovlev(String userName, String password) throws IOException {
        this.userName = userName;
        this.password = password;
    }
}
