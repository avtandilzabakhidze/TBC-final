package ge.tbcacademy.data.model.blogs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    private String alt;
    private String desc;
    private String src;
}

