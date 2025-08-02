package ge.tbcacademy.data.model.blogs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogEntry {
    private String slug;
    private String title;
    private String description;
    private String startDate;
    private Image image;
    private List<Segment> segments;
}
