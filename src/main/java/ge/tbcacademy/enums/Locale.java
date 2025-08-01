package ge.tbcacademy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Locale {
    GEORGIAN("ka-GE"),
    ENGLISH("en-US");

    private final String localeCode;
}
