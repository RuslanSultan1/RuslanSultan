package enums;

public enum ServiceMenu {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLES_WITH_PAGES("Table With Pages"),
    DIFFERENT_ELEMENTS("Different Elements"),
    PERFORMANCE("Performance"),
    USER_TABLE("User Table");
    String value;

    ServiceMenu(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
