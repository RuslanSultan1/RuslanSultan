package enums;

public enum ColorRadios {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");
    String value;
    int position;

    ColorRadios(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

