package ge.tbcacademy.data.model.blogs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Segment {
    private String label;
    private boolean isHidden;
}

