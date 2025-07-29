package ge.tbcacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Curency {
    GEL("GEL"),
    USD("USD"),
    EUR("EUR"),
    GBP("GBP");

    private final String ccy;
}
