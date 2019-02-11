package enums;

public enum Radios {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");
    String value;
    int position;

    Radios(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

