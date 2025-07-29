package ge.tbcacademy.steps;

import io.restassured.response.Response;

public class AtmBranchSteps {
    private final Response response;

    public AtmBranchSteps(Response response) {
        this.response = response;
    }

    public AtmBranchSteps validateStatusCode(int expectedCode) {
        response.then().statusCode(expectedCode);
        return this;
    }

    public AtmBranchSteps validateContentType(String expectedContentType) {
        response.then().contentType(expectedContentType);
        return this;
    }

    public AtmBranchSteps printPretty() {
        System.out.println(response.prettyPrint());
        return this;
    }
}
