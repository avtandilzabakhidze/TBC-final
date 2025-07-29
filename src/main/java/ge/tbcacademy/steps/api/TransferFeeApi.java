package ge.tbcacademy.steps.api;

import ge.tbcacademy.enums.Ccy;
import ge.tbcacademy.enums.ReceiveCountryCode;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TransferFeeApi {
    public Response getTransferFee(int amount, Ccy currencyCode, ReceiveCountryCode receiveCountryCode) {
        return given()
                .basePath("/api/v1/moneyTransfer/fees")
                .queryParam("amount", amount)
                .queryParam("currencyCode", currencyCode)
                .queryParam("receiveCountryCode", receiveCountryCode.toString())
                .header("accept", "application/json")
                .when()
                .get();
    }
}
