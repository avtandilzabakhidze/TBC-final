import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TbcApiTest {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://apigw.tbc.ge";

        Response response = given()
                .basePath("/api/v1/moneyTransfer/fees")
                .queryParam("amount", 100)
                .queryParam("currencyCode", "USD")
                .queryParam("receiveCountryCode", "USA")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("size()", is(4))
                .extract()
                .response();

        System.out.println(response.asPrettyString());
        System.out.println("----------- 2 -----------");

        Response response1 = given()
                .basePath("/api/v1/moneyTransfer/fees")
                .queryParam("amount", 1000)
                .queryParam("currencyCode", "USD")
                .queryParam("receiveCountryCode", "GRC")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                // Additional assertions here depend on actual response structure
                .extract()
                .response();

        System.out.println(response1.asPrettyString());

        System.out.println("------------ 3 --------------------");
        Response response2 = given()
                .basePath("/api/v1/moneyTransfer/fees")
                .queryParam("amount", 1000)
                .queryParam("currencyCode", "GBP")
                .queryParam("receiveCountryCode", "ISR")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract()
                .response();

        System.out.println(response2.asPrettyString());
        System.out.println("------------ 4 --------------------");

        Response response3 = given()
                .basePath("/api/v1/moneyTransfer/fees")
                .queryParam("amount", 1000)
                .queryParam("currencyCode", "GEL")
                .queryParam("receiveCountryCode", "SRB")
                .header("accept", "application/json")
                .when()
                .get()
                .then()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .extract()
                .response();

        System.out.println(response3.asPrettyString());
    }
}
