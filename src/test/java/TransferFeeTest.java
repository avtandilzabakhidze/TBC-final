import ge.tbcacademy.enums.CountryCode;
import ge.tbcacademy.enums.Curency;
import ge.tbcacademy.steps.TransferFeeSteps;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.*;

@Epic("API")
@Link(name = "CRM-T14", url = "https://shorturl.at/AM226")
@Listeners(AllureTestNg.class)
public class TransferFeeTest extends BaseTest {
    @Story("Validate ATM and Branch Locations Are Within Georgia")
    @Test(description = "Fetch the remittance fee")
    @Severity(SeverityLevel.CRITICAL)
    public void validateFeeWithMoreThanMaximumAmount() {
        Response response = transferFeeApi.getTransferFee(AMOUNT_999999999, Curency.USD, CountryCode.USA);
        new TransferFeeSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .validateEmptyArrayResponse();
    }
}