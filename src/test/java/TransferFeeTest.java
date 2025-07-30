import ge.tbcacademy.enums.Curency;
import ge.tbcacademy.enums.CountryCode;
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
        public void validateFeeWithUnsupportedCountryCode() {
                Response response = transferFeeApi.getTransferFee(AMOUNT_100, Curency.USD, CountryCode.UNSUPPORTED_RUS);
                new TransferFeeSteps(response)
                        .validateStatusCode(STATUS_200)
                        .validateContentType(APPLICATION)
                        .validateEmptyArrayResponse();
        }
}
