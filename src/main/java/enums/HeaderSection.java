package enums;

public enum HeaderSection {
    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_COLORS("METALS & COLORS");

    String value;

    HeaderSection(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
