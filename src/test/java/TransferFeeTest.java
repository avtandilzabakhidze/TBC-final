import ge.tbcacademy.enums.CountryCode;
import ge.tbcacademy.enums.Curency;
import ge.tbcacademy.steps.TransferFeeSteps;
import ge.tbcacademy.steps.api.TransferFeeApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.*;

public class TransferFeeTest {
    TransferFeeApi transferFeeApi;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        transferFeeApi = new TransferFeeApi();
    }

    @Test
    public void validateFeeWithMoreThanMaximumAmount() {
        Response response = transferFeeApi.getTransferFee(AMOUNT_999999999, Curency.USD, CountryCode.USA);
        new TransferFeeSteps(response)
                .validateStatusCode(STATUS_200)
                .validateContentType(APPLICATION)
                .validateEmptyArrayResponse();
    }
}
