package enums;

public enum Checkboxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");
    String value;

    Checkboxes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
