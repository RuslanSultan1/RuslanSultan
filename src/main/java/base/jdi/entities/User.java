package base.jdi.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    public static User PETER = new User("epam", "1234", "PETER CHAVLOVSKY");

    String login;
    String password;
    String fullName;
}
