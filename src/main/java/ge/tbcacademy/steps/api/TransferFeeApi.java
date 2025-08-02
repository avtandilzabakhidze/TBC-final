package ge.tbcacademy.steps.api;

import ge.tbcacademy.enums.CountryCode;
import ge.tbcacademy.enums.Curency;
import io.restassured.response.Response;

import static ge.tbcacademy.data.Constants.*;
import static io.restassured.RestAssured.given;

public class TransferFeeApi {
    public Response getTransferFee(int amount, Curency currencyCode, CountryCode receiveCountryCode) {
        return given()
                .basePath(BASE_PATH_FEE)
                .queryParam("amount", amount)
                .queryParam("currencyCode", currencyCode)
                .queryParam("receiveCountryCode", receiveCountryCode)
                .header("origin", TBC_URL)
                .when()
                .get();
    }
}
