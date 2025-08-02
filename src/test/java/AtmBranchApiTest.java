import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.AtmBranchSteps;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.APPLICATION;
import static ge.tbcacademy.data.Constants.STATUS_200;


@Epic("API")
@Link(name = "CRM-T15", url = "https://shorturl.at/0kegg")
@Listeners(AllureTestNg.class)
public class AtmBranchApiTest extends BaseTest {
    @Story("Validate ATM and Branch Locations Are Within Georgia")
    @Test(description = "Retrieve the list of ATMs and branches")
    @Severity(SeverityLevel.CRITICAL)
    public void testATMAndBranchLocationsWithinGeorgia() {
        Response response = atmBranchApi.getAtmsAndBranches(Locale.GEORGIAN);
        new AtmBranchSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .validateCoordinatesWithinGeorgia();
    }
}