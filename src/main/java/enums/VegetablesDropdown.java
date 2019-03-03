package enums;

public enum VegetablesDropdown {
    CUCUMBER("Cucumber"),
    TOMATO("Tomato"),
    VEGETABLES("Vegetables"),
    ONION("Onion");
    String value;

    VegetablesDropdown(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
