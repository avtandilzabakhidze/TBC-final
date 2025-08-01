import ge.tbcacademy.steps.ExchangeRateSteps;
import org.testng.annotations.Test;

public class ExchangeRateTest {
    @Test
    public void testUsdToGelExchangeRateFluently() {
        new ExchangeRateSteps()
                .fetchValidIsos()
                .requestExchangeRate("USD", "GEL")
                .validateExchangeRateFields()
                .printRates();
    }
}
