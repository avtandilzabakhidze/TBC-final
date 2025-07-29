package ge.tbcacademy.enums;

public enum Locale {
    GEORGIAN("ka-GE"),
    ENGLISH("en-US");

    private final String localeCode;

    Locale(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getCode() {
        return localeCode;
    }
}
