import ge.tbcacademy.data.model.blogs.BlogRequest;
import ge.tbcacademy.data.model.blogs.BlogResponse;
import ge.tbcacademy.enums.BlogSegment;
import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.BlogSteps;
import ge.tbcacademy.steps.api.BlogApi;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.BASE_URI;


public class BlogScrollSearchTest {
    private BlogApi blogApi;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        blogApi = new BlogApi();
    }

    @Test
    public void scrollSearchUsingPojoAndSteps() {
        String searchTitle = "ფოტოasdგრაფ ელენე შენგელიას პასუხი";
        int pageSize = 10;
        int pageIndex = 0;

        boolean titleFound = false;
        String matchedFullTitle = null;

        while (true) {
            BlogRequest request = new BlogRequest(BlogSegment.ALL, pageIndex, pageSize, Locale.GEORGIAN);
            BlogResponse response = blogApi.scrollSearch(request);

            BlogSteps steps = new BlogSteps(response);

            if (steps.isEmpty()) break;

            matchedFullTitle = steps.findMatchingTitleIgnoreCase(searchTitle);
            if (matchedFullTitle != null) {
                System.out.println("Found match. Full Title: " + matchedFullTitle);
                titleFound = true;
                break;
            }
            pageIndex++;
        }

        new BlogSteps(null).assertTitleNotFound(titleFound, searchTitle);
    }

}