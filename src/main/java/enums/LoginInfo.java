package enums;

public enum LoginInfo {
    INDEX_PAGE_URL("https://epam.github.io/JDI/index.html"),
    INDEX_PAGE_TITLE("Home Page"),
    LOGIN("epam"),
    PASSWORD("1234"),
    USER_NAME("PITER CHAILOVSKII");

    String value;

    LoginInfo(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
