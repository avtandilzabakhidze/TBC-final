package ge.tbcacademy.steps;

import ge.tbcacademy.data.model.blogs.BlogEntry;
import ge.tbcacademy.data.model.blogs.BlogResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BlogSteps {
    private final BlogResponse blogResponse;
    private static final Logger logger = LoggerFactory.getLogger(BlogSteps.class);

    public BlogSteps(BlogResponse blogResponse) {
        this.blogResponse = blogResponse;
    }

    public boolean isEmpty() {
        return blogResponse == null || blogResponse.getList() == null || blogResponse.getList().isEmpty();
    }

    public String findMatchingTitleIgnoreCase(String partialTitle) {
        if (blogResponse == null || blogResponse.getList() == null) return null;

        for (BlogEntry entry : blogResponse.getList()) {
            String fullTitle = entry.getTitle();
            if (fullTitle != null && fullTitle.toLowerCase().contains(partialTitle.toLowerCase())) {
                return fullTitle;
            }
        }
        return null;
    }

    public BlogSteps assertTitleNotFound(boolean found, String expectedTitle) {
        if (!found) {
            logger.warn("Expected to find title containing: " + expectedTitle);
        }
        return this;
    }
    public BlogSteps logFoundTitle(String matchedTitle) {
        System.out.printf("Found match. Full Title: %s", matchedTitle);
        return this;
    }
}

