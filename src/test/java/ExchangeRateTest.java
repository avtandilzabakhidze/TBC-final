import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.ExchangeRateSteps;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.ISO1;
import static ge.tbcacademy.data.Constants.ISO2;

public class ExchangeRateTest extends BaseTest {
    @Test(priority = 1)
    public void testComercialList() {
        Response response = exchangeRateApi.getCommercialList(Locale.GEORGIAN);
        new ExchangeRateSteps(response)
                .validateIsos(ISO1, ISO2);
    }

    @Test(priority = 2, dependsOnMethods = "testComercialList")
    public void testExchangeRate() {
        Response response = exchangeRateApi.getExchangeRate(ISO1, ISO2);
        new ExchangeRateSteps(response)
                .validateExchangeRateFields(ISO1, ISO2)
                .printRates();
    }
}
