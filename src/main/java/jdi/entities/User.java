package jdi.entities;

public class User {
    public static final User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private String name;
    private String password;
    private String fullName;

    public User(String name, String password, String fullName) {
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
