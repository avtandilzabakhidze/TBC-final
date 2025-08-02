import ge.tbcacademy.enums.CountryCode;
import ge.tbcacademy.enums.Curency;
import ge.tbcacademy.steps.TransferFeeSteps;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.*;

@Epic("Transfer Management")
public class TransferFeeTest extends BaseTest {
    @Test
    @Story("Fee Validation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that transfer fee returns empty array for amounts exceeding maximum limit")
    @Link(name = "Test Case", url = "https://shorturl.at/0kegg")
    public void validateFeeWithMoreThanMaximumAmount() {
        Response response = transferFeeApi.getTransferFee(AMOUNT_999999999, Curency.USD, CountryCode.USA);
        new TransferFeeSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .validateEmptyArrayResponse();
    }
}