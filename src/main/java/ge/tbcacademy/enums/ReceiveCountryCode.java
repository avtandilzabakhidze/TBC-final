package ge.tbcacademy.enums;

public enum ReceiveCountryCode {
    USA("USA"),
    GRC("GRC"),
    ISR("ISR"),
    SRB("SRB");

    private final String code;

    ReceiveCountryCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
