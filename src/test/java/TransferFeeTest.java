import ge.tbcacademy.enums.CountryCode;
import ge.tbcacademy.enums.Curency;
import ge.tbcacademy.steps.TransferFeeSteps;
import ge.tbcacademy.steps.api.TransferFeeApi;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.*;

@Epic("Transfer Management")
@Feature("Transfer Fee Calculation")
public class TransferFeeTest {
    TransferFeeApi transferFeeApi;

    @BeforeClass
    @Step("Setup test environment")
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        transferFeeApi = new TransferFeeApi();
    }

    @Test
    @Story("Fee Validation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that transfer fee returns empty array for amounts exceeding maximum limit")
    @Issue("JIRA-456")
    public void validateFeeWithMoreThanMaximumAmount() {
        Response response = transferFeeApi.getTransferFee(AMOUNT_999999999, Curency.USD, CountryCode.USA);
        new TransferFeeSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .validateEmptyArrayResponse();
    }
}