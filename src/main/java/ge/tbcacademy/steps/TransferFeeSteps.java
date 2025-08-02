package ge.tbcacademy.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static ge.tbcacademy.data.Constants.*;
import static org.hamcrest.Matchers.hasSize;

public class TransferFeeSteps {
    private final Response response;

    public TransferFeeSteps(Response response) {
        this.response = response;
    }

    @Step("Validate response status code is {expectedStatus}")
    public TransferFeeSteps validateStatusCode(int expectedStatus) {
        response.then().statusCode(expectedStatus);
        return this;
    }

    @Step("Validate content type is {expectedContentType}")
    public TransferFeeSteps validateContentType(String expectedContentType) {
        response.then().contentType(expectedContentType);
        return this;
    }

    @Step("Validate response contains empty array")
    public TransferFeeSteps validateEmptyArrayResponse() {
        response.then().body(EMPTY, hasSize(ZERO));
        return this;
    }
}