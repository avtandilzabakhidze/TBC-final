package ge.tbcacademy.steps.api;

import ge.tbcacademy.enums.Locale;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TbcAtmBranchApi {
    private static final String BASE_PATH = "/api/v1/atmsAndBranches/list";

    public Response getAtmsAndBranches(Locale locale) {
        return given()
                .basePath(BASE_PATH)
                .header("Origin", "https://tbcbank.ge")
                .header("Referer", "https://tbcbank.ge/")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36")
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body("{\"Locale\": \"" + locale + "\"}")
                .when()
                .post();
    }
}
