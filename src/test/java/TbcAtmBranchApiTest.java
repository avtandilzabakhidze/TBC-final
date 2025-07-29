import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.TbcAtmBranchSteps;
import ge.tbcacademy.steps.api.TbcAtmBranchApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TbcAtmBranchApiTest {
    TbcAtmBranchApi tbcAtmBranchApi;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://apigw.tbc.ge";
        tbcAtmBranchApi = new TbcAtmBranchApi();
    }

    @Test
    public void testAtmsAndBranches_GeorgianLocale() {
        Response response = tbcAtmBranchApi.getAtmsAndBranches(Locale.GEORGIAN);
        new TbcAtmBranchSteps(response)
                .validateStatusCode(200)
                .validateContentType("application/json")
                .printPretty();
    }

    @Test
    public void testAtmsAndBranches_EnglishLocale() {
        Response response = tbcAtmBranchApi.getAtmsAndBranches(Locale.ENGLISH);
        new TbcAtmBranchSteps(response)
                .validateStatusCode(200)
                .validateContentType("application/json")
                .printPretty();
    }
}
