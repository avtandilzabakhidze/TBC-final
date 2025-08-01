package ge.tbcacademy.data.model.blogs;

import ge.tbcacademy.enums.BlogSegment;
import ge.tbcacademy.enums.Locale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequest {
    private BlogSegment segment;
    private int pageIndex;
    private int pageSize;
    private Locale locale;
}
