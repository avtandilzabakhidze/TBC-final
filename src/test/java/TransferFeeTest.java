import ge.tbcacademy.enums.Ccy;
import ge.tbcacademy.enums.ReceiveCountryCode;
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
        public void testTransferFee_USD_USA() {
                Response response = transferFeeApi.getTransferFee(AMOUNT_100, Ccy.USD, ReceiveCountryCode.USA);
                new TransferFeeSteps(response)
                        .validateStatusCode(STATUS_200)
                        .validateContentType(APPLICATION)
                        .printPretty();
        }

        @Test
        public void testTransferFee_USD_GRC() {
                Response response = transferFeeApi.getTransferFee(AMOUNT_200, Ccy.USD, ReceiveCountryCode.GRC);
                new TransferFeeSteps(response)
                        .validateStatusCode(STATUS_200)
                        .validateContentType(APPLICATION)
                        .printPretty();
        }

        @Test
        public void testTransferFee_GBP_ISR() {
                Response response = transferFeeApi.getTransferFee(AMOUNT_500, Ccy.GBP, ReceiveCountryCode.ISR);
                new TransferFeeSteps(response)
                        .validateStatusCode(STATUS_200)
                        .validateContentType(APPLICATION)
                        .printPretty();
        }

        @Test
        public void testTransferFee_GEL_SRB() {
                Response response = transferFeeApi.getTransferFee(AMOUNT_1000, Ccy.GEL, ReceiveCountryCode.SRB);
                new TransferFeeSteps(response)
                        .validateStatusCode(STATUS_200)
                        .validateContentType(APPLICATION)
                        .printPretty();
        }
}
