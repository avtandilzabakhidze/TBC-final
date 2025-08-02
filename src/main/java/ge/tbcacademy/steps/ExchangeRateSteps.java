package ge.tbcacademy.steps;

import io.restassured.response.Response;

import java.util.List;

import static ge.tbcacademy.data.Constants.*;
import static org.hamcrest.Matchers.*;

public class ExchangeRateSteps {


    private Response response;
    private String iso1;
    private String iso2;

    public ExchangeRateSteps(Response response) {
        this.response = response;
    }

    public ExchangeRateSteps validateIsos(String iso1, String iso2) {
        List<String> isoList = response.jsonPath().getList(RATES_ISO_PATH);
        isoList.add(GEL);
        if (!isoList.contains(iso1) || !isoList.contains(iso2)) {
            throw new IllegalArgumentException(
                    String.format("Invalid ISOs: iso1=%s, iso2=%s", iso1, iso2)
            );
        }
        return this;
    }

    public ExchangeRateSteps validateExchangeRateFields(String iso1, String iso2) {
        this.iso1 = iso1;
        this.iso2 = iso2;
        response.then()
                .body(ISO1_PATH, equalTo(iso1))
                .body(ISO2_PATH, equalTo(iso2))
                .body(BUY_RATE_PATH, allOf(notNullValue(), greaterThan(0f)))
                .body(SELL_RATE_PATH, allOf(notNullValue(), greaterThan(0f)));
        return this;
    }


    public ExchangeRateSteps printRates() {
        float buy = response.path(BUY_RATE_PATH);
        float sell = response.path(SELL_RATE_PATH);

        System.out.printf("Exchange Rate: %s → %s | Buy: %.4f | Sell: %.4f%n", iso1, iso2, buy, sell);
        return this;
    }
}
