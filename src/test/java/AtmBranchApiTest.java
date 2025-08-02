import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.AtmBranchSteps;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.APPLICATION;
import static ge.tbcacademy.data.Constants.STATUS_200;

@Epic("ATM and Branch Management")
public class AtmBranchApiTest extends BaseTest {
    @Test
    @Story("Location Validation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that all ATM and branch locations are within Georgia's geographical boundaries")
    @Link(name = "Test Case", url = "https://shorturl.at/AM226")
    public void testATMAndBranchLocationsWithinGeorgia() {
        Response response = atmBranchApi.getAtmsAndBranches(Locale.GEORGIAN);
        new AtmBranchSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .validateCoordinatesWithinGeorgia();
    }
}