package ge.tbcacademy.steps.api;

import ge.tbcacademy.enums.Locale;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static ge.tbcacademy.data.Constants.*;
import static io.restassured.RestAssured.given;

public class ExchangeRateApi {
    static {
        RestAssured.baseURI = BASE_URI;
    }

    public Response getCommercialList(Locale locale) {
        return given()
                .queryParam("locale", locale.getLocaleCode())
                .when()
                .get(COMMERCIAL_LIST_BASE_PATH)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response getExchangeRate(String iso1, String iso2) {
        return given()
                .basePath(EXCHANGE_RATES_BASE_PATH)
                .queryParam("Iso1", iso1)
                .queryParam("Iso2", iso2)
                .accept(ContentType.JSON)
                .header("origin", TBC_URL)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
    }
}
