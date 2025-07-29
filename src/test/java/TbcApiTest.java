import ge.tbcacademy.enums.Ccy;
import ge.tbcacademy.enums.ReceiveCountryCode;
import ge.tbcacademy.steps.api.TbcApi;
import ge.tbcacademy.steps.TbcSteps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TbcApiTest {
        TbcApi tbcApi;

        @BeforeClass
        public void setup() {
                RestAssured.baseURI = "https://apigw.tbc.ge";
                tbcApi = new TbcApi();
        }

        @Test
        public void testTransferFee_USD_USA() {
                Response response = tbcApi.getTransferFee(100, Ccy.USD, ReceiveCountryCode.USA);
                new TbcSteps(response)
                        .validateStatusCode(200)
                        .validateContentType("application/json; charset=utf-8")
                        .validateResponseSize(4)
                        .printPretty();
        }

        @Test
        public void testTransferFee_USD_GRC() {
                Response response = tbcApi.getTransferFee(1000, Ccy.USD, ReceiveCountryCode.GRC);
                new TbcSteps(response)
                        .validateStatusCode(200)
                        .validateContentType("application/json; charset=utf-8")
                        .printPretty();
        }

        @Test
        public void testTransferFee_GBP_ISR() {
                Response response = tbcApi.getTransferFee(1000, Ccy.GBP, ReceiveCountryCode.ISR);
                new TbcSteps(response)
                        .validateStatusCode(200)
                        .validateContentType("application/json; charset=utf-8")
                        .printPretty();
        }

        @Test
        public void testTransferFee_GEL_SRB() {
                Response response = tbcApi.getTransferFee(1000, Ccy.GEL, ReceiveCountryCode.SRB);
                new TbcSteps(response)
                        .validateStatusCode(200)
                        .validateContentType("application/json; charset=utf-8")
                        .printPretty();
        }
}
