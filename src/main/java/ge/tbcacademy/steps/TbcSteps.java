package ge.tbcacademy.steps;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class TbcSteps {
    private final Response response;

    public TbcSteps(Response response) {
        this.response = response;
    }

    public TbcSteps validateStatusCode(int expectedStatus) {
        response.then().statusCode(expectedStatus);
        return this;
    }

    public TbcSteps validateContentType(String expectedContentType) {
        response.then().contentType(expectedContentType);
        return this;
    }

    public TbcSteps validateResponseSize(int expectedSize) {
        response.then().body("size()", is(expectedSize));
        return this;
    }

    public TbcSteps printPretty() {
        System.out.println(response.asPrettyString());
        return this;
    }
}
