package ge.tbcacademy.steps;

import io.restassured.response.Response;

public class TransferFeeSteps {
    private final Response response;

    public TransferFeeSteps(Response response) {
        this.response = response;
    }

    public TransferFeeSteps validateStatusCode(int expectedStatus) {
        response.then().statusCode(expectedStatus);
        return this;
    }

    public TransferFeeSteps validateContentType(String expectedContentType) {
        response.then().contentType(expectedContentType);
        return this;
    }

    public TransferFeeSteps printPretty() {
        System.out.println(response.asPrettyString());
        return this;
    }
}
