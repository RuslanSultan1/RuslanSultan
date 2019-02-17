package enums;

public enum User {

    PITER_CHAILOVSKII("epam", "1234", "PITER CHAILOVSKII");

    public final String login;
    public final String password;
    public final String username;

    User(String login, String password, String username) {
        this.login = login;
        this.password = password;
        this.username = username;
    }

    public static User getUserByUserName(String username) {
        for (User user : values()) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Wrong user name: " + username);
    }
}
