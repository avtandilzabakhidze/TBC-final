import ge.tbcacademy.enums.BlogSegment;
import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.BlogSteps;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.PAGE_SIZE;
import static ge.tbcacademy.data.Constants.SEARCH_TITLE;

@Epic("API")
@Link(name = "CRM-T12", url = "https://shorturl.at/bGVVf")
@Listeners(AllureTestNg.class)
public class BlogScrollSearchTest extends BaseTest {
    @Story("Test Currency Exchange Rate Public API")
    @Test(description = "Fetch Blogs Until Title Is Found or Confirmed Missing")
    @Severity(SeverityLevel.CRITICAL)
    public void scrollSearchUsingPojoAndSteps() {
        new BlogSteps(blogApi)
                .scrollUntilTitleFound(SEARCH_TITLE, BlogSegment.ALL, PAGE_SIZE, Locale.GEORGIAN)
                .assertTitleNotFound(SEARCH_TITLE);
    }
}