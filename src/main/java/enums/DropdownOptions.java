package enums;

public enum DropdownOptions {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");
    String value;

    DropdownOptions(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
