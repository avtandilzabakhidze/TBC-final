package ge.tbcacademy.data.model.blogs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogResponse {
    private PagingDetails pagingDetails;
    private List<BlogEntry> list;
}
