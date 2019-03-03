package enums;

public enum DropdownColorOptions {
    COLORS("Colors"),
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");
    String value;

    DropdownColorOptions(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
