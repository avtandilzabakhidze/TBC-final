import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.ExchangeRateSteps;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("API")
@Link(name = "CRM-T13", url = "https://shorturl.at/2M9Gp")
@Listeners(AllureTestNg.class)
public class ExchangeRateTest extends BaseTest {
    @Story("Test Currency Exchange Rate Public API")
    @Test(priority = 1, dataProvider = "isoProvider",
            dataProviderClass = ge.tbcacademy.data.IsoData.class,
            description = "Request commercial exchange rate list and validate isos")
    @Severity(SeverityLevel.BLOCKER)
    public void testComercialList(String iso1, String iso2) {
        Response response = exchangeRateApi.getCommercialList(Locale.GEORGIAN);
        new ExchangeRateSteps(response)
                .validateIsos(iso1, iso2);
    }

    @Story("Test Currency Exchange Rate Public API")
    @Test(priority = 2, dependsOnMethods = "testComercialList",
            dataProvider = "isoProvider",
            dataProviderClass = ge.tbcacademy.data.IsoData.class,
            description = "Request exchange rate for currency pair and verify response contains correct data")
    @Severity(SeverityLevel.CRITICAL)
    public void testExchangeRate(String iso1, String iso2) {
        Response response = exchangeRateApi.getExchangeRate(iso1, iso2);
        new ExchangeRateSteps(response)
                .validateExchangeRateFields(iso1, iso2)
                .printRates();
    }
}
