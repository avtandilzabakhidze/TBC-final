import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.AtmBranchSteps;
import ge.tbcacademy.steps.api.AtmBranchApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.*;

public class AtmBranchApiTest {
    AtmBranchApi atmBranchApi;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        atmBranchApi = new AtmBranchApi();
    }

    @Test
    public void testAtmsAndBranches_GeorgianLocale() {
        Response response = atmBranchApi.getAtmsAndBranches(Locale.GEORGIAN);
        new AtmBranchSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .printPretty();
    }

    @Test
    public void testAtmsAndBranches_EnglishLocale() {
        Response response = atmBranchApi.getAtmsAndBranches(Locale.ENGLISH);
        new AtmBranchSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .printPretty();
    }
}
