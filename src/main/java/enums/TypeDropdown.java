package enums;

public enum TypeDropdown {
    USER("User"),
    MANAGER("Manager"),
    ADMIN("Admin");
    String value;
    TypeDropdown(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
