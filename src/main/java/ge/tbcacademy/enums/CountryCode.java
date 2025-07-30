package ge.tbcacademy.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum CountryCode {
    USA("USA"),
    GRC("GRC"),
    ISR("ISR"),
    UNSUPPORTED_RUS("RUS"),//just unsupported : )
    SRB("SRB");

    private final String code;
}
