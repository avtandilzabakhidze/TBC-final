import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.AtmBranchSteps;
import ge.tbcacademy.steps.api.AtmBranchApi;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.*;

@Epic("ATM and Branch Management")
@Feature("ATM Branch Locations")
public class AtmBranchApiTest {
    AtmBranchApi atmBranchApi;

    @BeforeClass
    @Step("Setup test environment")
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        atmBranchApi = new AtmBranchApi();
    }

    @Test
    @Story("Location Validation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that all ATM and branch locations are within Georgia's geographical boundaries")
    @Link(name = "Test Case", url = "https://your-test-management-tool.com/test-case-123")
    public void testATMAndBranchLocationsWithinGeorgia() {
        Response response = atmBranchApi.getAtmsAndBranches(Locale.GEORGIAN);
        new AtmBranchSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .validateCoordinatesWithinGeorgia();
    }
}