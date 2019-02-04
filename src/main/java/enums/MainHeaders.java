package enums;

public enum MainHeaders {
    MAIN_TITLE("EPAM FRAMEWORK WISHES…"),
    MAIN_TXT("LOREM IPSUM DOLOR SIT AMET," +
            " CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
            "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
            "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU " +
            "FUGIAT NULLA PARIATUR.");

    String value;

    MainHeaders(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
