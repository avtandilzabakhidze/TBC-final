import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.ExchangeRateSteps;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static ge.tbcacademy.data.Constants.ISO1;
import static ge.tbcacademy.data.Constants.ISO2;

@Epic("API")
@Link(name = "CRM-T13", url = "https://shorturl.at/2M9Gp")
@Listeners(AllureTestNg.class)
public class ExchangeRateTest extends BaseTest {
    @Story("Test Currency Exchange Rate Public API")
    @Test(priority = 1, description = "Request commercial exchange rate list and validate isos")
    @Severity(SeverityLevel.BLOCKER)
    public void testComercialList() {
        Response response = exchangeRateApi.getCommercialList(Locale.GEORGIAN);
        new ExchangeRateSteps(response)
                .validateIsos(ISO1, ISO2);
    }
    @Story("Test Currency Exchange Rate Public API")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2, dependsOnMethods = "testComercialList",
            description = "Request exchange rate for currency pair and verify response contains correct data")
    public void testExchangeRate() {
        Response response = exchangeRateApi.getExchangeRate(ISO1, ISO2);
        new ExchangeRateSteps(response)
                .validateExchangeRateFields(ISO1, ISO2)
                .printRates();
    }
}
