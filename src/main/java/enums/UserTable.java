package enums;

public enum UserTable {
    ROMAN(1, "Roman", "Wolverine","roman"),
    SERGEY_IVAN(2, "Sergey Ivan", "Spider Man","ivan"),
    VLADZIMIR(3, "Vladzimir", "Punisher","vlad"),
    HELEN_BENNETT(4, "Helen Bennett", "Captain America \nsome description","helen"),
    YOSHI_TANNAMURI(5, "Yoshi Tannamuri", "Cyclope \nsome description","yoshi"),
    GIOVANNI_ROVELLI(6, "Giovanni Rovelli", "Hulk\nsome description","gio");

    int number;
    String name;
    String description;
    String checkboxId;

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCheckboxId() {
        return checkboxId;
    }

    UserTable(int number, String name, String description, String checkboxId) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.checkboxId=checkboxId;
    }
    public static UserTable getUserByName(String name) {
        for (UserTable user : values()) {
            if (user.name.equals(name)) {
                return user;
            }
        }
        throw new IllegalArgumentException("Wrong user name: " + name);
    }
}
