package enums;

public enum NatureElementsCheckboxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");
    String value;

    NatureElementsCheckboxes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
