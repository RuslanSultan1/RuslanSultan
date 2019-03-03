package enums;

public enum MetalsOptions {
    METALS("Metals"),
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");
    String value;

    MetalsOptions(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

