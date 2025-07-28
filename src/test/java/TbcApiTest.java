import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
        System.out.println("------------ 5- --------------------");

        Response response5 = RestAssured
                .given()
                .baseUri("https://apigw.tbc.ge")
                .basePath("/api/v1/atmsAndBranches/list")
                .header("Origin", "https://tbcbank.ge")
                .header("Referer", "https://tbcbank.ge/")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36")
                .contentType(ContentType.JSON)
                .accept("application/json")
                .body("""
              {
                "Locale": "ka-GE"
              }
              """)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("atms", notNullValue())  // ან "branches", რაც არის რეალურ JSON-ში
                .extract()
                .response();

        System.out.println(response5.prettyPrint());
    }
}
