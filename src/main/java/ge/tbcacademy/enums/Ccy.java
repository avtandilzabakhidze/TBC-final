package ge.tbcacademy.enums;

public enum Ccy{
    GEL("GEL"),
    USD("USD"),
    EUR("EUR"),
    GBP("GBP");

    private final String ccy;

    Ccy(String ccy) {
        this.ccy = ccy;
    }

    public String getCcy() {
        return ccy;
    }
}
