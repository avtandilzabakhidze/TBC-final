package ge.tbcacademy.steps.api;

import ge.tbcacademy.enums.Locale;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static ge.tbcacademy.data.Constants.*;
import static io.restassured.RestAssured.given;

public class AtmBranchApi {
    @Step("Get ATMs and branches for locale: {locale}")
    public Response getAtmsAndBranches(Locale locale) {
        return given()
                .basePath(BASE_PATH_ATM)
                .header("origin", TBC_URL)
                .contentType(ContentType.JSON)
                .accept(APPLICATION)
                .body(START_LOCATE + locale.getLocaleCode() + END_LOCATE)
                .when()
                .post();
    }
}
