package ge.tbcacademy.steps;

import ge.tbcacademy.data.model.atm.AtmBranch;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static ge.tbcacademy.data.Constants.*;

public class AtmBranchSteps {
    private final Response response;

    public AtmBranchSteps(Response response) {
        this.response = response;
    }

    @Step("Validate response status code is {expectedCode}")
    public AtmBranchSteps validateStatusCode(int expectedCode) {
        response.then().statusCode(expectedCode);
        return this;
    }

    @Step("Validate content type is {expectedContentType}")
    public AtmBranchSteps validateContentType(String expectedContentType) {
        response.then().contentType(expectedContentType);
        return this;
    }

    @Step("Validate all ATM coordinates are within Georgia boundaries")
    public AtmBranchSteps validateCoordinatesWithinGeorgia() {
        List<AtmBranch> data = response.jsonPath().getList(PAYLOAD_BRANCHES, AtmBranch.class);
        List<AtmBranch> invalidLocations = new ArrayList<>();

        for (AtmBranch atm : data) {
            double lat = atm.getLatitude();
            double lng = atm.getLongitude();

            boolean isLatValid = lat >= MIN_LAT && lat <= MAX_LAT;
            boolean isLngValid = lng >= MIN_LNG && lng <= MAX_LNG;

            if (!isLatValid || !isLngValid) {
                invalidLocations.add(atm);
            }
        }

        Assert.assertTrue(invalidLocations.isEmpty(),
                OUTSIDE_GEORGIA + ". Invalid locations found: " + invalidLocations.size());
        return this;
    }
}