package ge.tbcacademy.steps.api;

import ge.tbcacademy.data.model.blogs.BlogRequest;
import ge.tbcacademy.data.model.blogs.BlogResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static ge.tbcacademy.data.Constants.BLOG_BASE_PATH;

public class BlogApi {
    public BlogResponse scrollSearch(BlogRequest request) {
        return RestAssured
                .given()
                .basePath(BLOG_BASE_PATH)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request)
                .post()
                .then()
                .statusCode(200)
                .extract()
                .as(BlogResponse.class);
    }
}
