package enums;

public enum IconsTexts {
    BENEFIT_PRACTISE("To include good practices\n" + "and ideas from successful\n" + "EPAM project"),
    BENEFIT_CUSTOM("To be flexible and\n" + "customizable"),
    BENEFIT_MULTI("To be multiplatform"),
    BENEFIT_BASE("Already have good base\n" + "(about 20 internal and\n" +
            "some external projects),\n" + "wish to get more…");

    String value;

    IconsTexts(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
