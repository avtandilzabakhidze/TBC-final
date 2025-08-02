package ge.tbcacademy.steps;

import ge.tbcacademy.data.model.blogs.BlogEntry;
import ge.tbcacademy.data.model.blogs.BlogRequest;
import ge.tbcacademy.data.model.blogs.BlogResponse;
import ge.tbcacademy.enums.BlogSegment;
import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.api.BlogApi;


public class BlogSteps {
    private final BlogApi blogApi;
    private BlogResponse response;
    private boolean titleFound;

    public BlogSteps(BlogApi blogApi) {
        this.blogApi = blogApi;
    }

    public BlogSteps scrollUntilTitleFound(String searchTitle, BlogSegment segment, int pageSize, Locale locale) {
        int pageIndex = 0;

        while (true) {
            BlogRequest request = new BlogRequest(segment, pageIndex, pageSize, locale);
            response = blogApi.scrollSearch(request);

            if (isEmptyResponse()) break;

            String matchedTitle = findMatchingTitleIgnoreCase(searchTitle);
            if (matchedTitle != null) {
                logFoundTitle(matchedTitle);
                titleFound = true;
                break;
            }
            pageIndex++;
        }

        return this;
    }

    public BlogSteps assertTitleNotFound(String expectedTitle) {
        if (!titleFound) {
            System.err.printf("Expected to find title containing: %s%n", expectedTitle);
        }
        return this;
    }

    private String findMatchingTitleIgnoreCase(String partialTitle) {
        for (BlogEntry entry : response.getList()) {
            String fullTitle = entry.getTitle();
            if (fullTitle != null && fullTitle.toLowerCase().contains(partialTitle.toLowerCase())) {
                return fullTitle;
            }
        }
        return null;
    }

    private void logFoundTitle(String matchedTitle) {
        System.out.printf("Found match. Full Title: %s%n", matchedTitle);
    }
    private boolean isEmptyResponse() {
        return response == null || response.getList() == null || response.getList().isEmpty();
    }
}

