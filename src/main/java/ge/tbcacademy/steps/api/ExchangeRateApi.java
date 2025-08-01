package ge.tbcacademy.steps.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import static ge.tbcacademy.data.Constants.BASE_URI;
import static io.restassured.RestAssured.given;

public class ExchangeRateApi {
    static {
        RestAssured.baseURI = BASE_URI;
    }

    public Response getCommercialList(String locale) {
        return given()
                .queryParam("locale", locale)
                .when()
                .get("/api/v1/exchangeRates/commercialList")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response getExchangeRate(String iso1, String iso2) {
        return given()
                .log().all()
                .basePath("/api/v1/exchangeRates/getExchangeRate")
                .queryParam("Iso1", iso1)
                .queryParam("Iso2", iso2)
                .accept(ContentType.JSON)
                .header("origin", "https://tbcbank.ge")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
    }
}
