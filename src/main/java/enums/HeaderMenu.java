package enums;

public enum HeaderMenu {
    HOME("Home"),
    CONTACT_FORM("Contact Form"),
    SERVICE("Service"),
    METALS_COLORS("Metals & Colors");

    String value;

    HeaderMenu(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
