import ge.tbcacademy.steps.api.AtmBranchApi;
import ge.tbcacademy.steps.api.BlogApi;
import ge.tbcacademy.steps.api.ExchangeRateApi;
import ge.tbcacademy.steps.api.TransferFeeApi;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static ge.tbcacademy.data.Constants.BASE_URI;

public class BaseTest {
    AtmBranchApi atmBranchApi;
    TransferFeeApi transferFeeApi;
    ExchangeRateApi exchangeRateApi;
    protected BlogApi blogApi;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
        atmBranchApi = new AtmBranchApi();
        transferFeeApi = new TransferFeeApi();
        exchangeRateApi = new ExchangeRateApi();
        blogApi = new BlogApi();
    }
}
