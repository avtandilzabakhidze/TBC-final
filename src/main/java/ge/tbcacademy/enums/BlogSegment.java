package ge.tbcacademy.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BlogSegment {
    ALL("All"),
    BLOG("Blog"),
    BUSINESS("Business"),
    NEWS("News"),
    CONCEPT("Concept"),
    EDUCATION("Education");

    private final String value;

    BlogSegment(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
