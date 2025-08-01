package ge.tbcacademy.data.model.blogs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PagingDetails {
    private int pageIndex;
    private int pageSize;
    private int totalCount;
    private int totalPages;
    private boolean hasPreviousPage;
    private boolean hasNextPage;
    private int firstItemIndex;
    private int lastItemIndex;
    private int pageNumber;

    @JsonProperty("isFirstPage")
    private boolean firstPage;

    @JsonProperty("isLastPage")
    private boolean lastPage;
}