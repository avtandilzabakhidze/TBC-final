package ge.tbcacademy.steps;

import ge.tbcacademy.enums.Locale;
import ge.tbcacademy.steps.api.ExchangeRateApi;
import io.restassured.response.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ExchangeRateSteps {

    private final ExchangeRateApi api = new ExchangeRateApi();
    private Set<String> validIsos;

    private Response rateResponse;
    private String iso1;
    private String iso2;

    public ExchangeRateSteps fetchValidIsos() {
        Response response = api.getCommercialList("ka-GE");
        List<String> isoList = response.jsonPath().getList("rates.iso");
        this.validIsos = new HashSet<>(isoList);
        return this;
    }

    public ExchangeRateSteps requestExchangeRate(String iso1, String iso2) {
        this.iso1 = iso1;
        this.iso2 = iso2;

        boolean iso1Valid = validIsos.contains(iso1);
        boolean iso2Valid = validIsos.contains(iso2) || "GEL".equalsIgnoreCase(iso2);

        if (!iso1Valid || !iso2Valid) {
            throw new IllegalArgumentException(
                    String.format("Invalid ISOs: iso1=%s, iso2=%s", iso1, iso2)
            );
        }

        this.rateResponse = api.getExchangeRate(iso1, iso2);
        return this;
    }

    public ExchangeRateSteps validateExchangeRateFields() {
        rateResponse.then()
                .body("iso1", equalTo(iso1))
                .body("iso2", equalTo(iso2))
                .body("buyRate", notNullValue())
                .body("sellRate", notNullValue());
        return this;
    }

    public ExchangeRateSteps printRates() {
        float buy = rateResponse.path("buyRate");
        float sell = rateResponse.path("sellRate");

        System.out.printf("Exchange Rate: %s → %s | Buy: %.4f | Sell: %.4f%n", iso1, iso2, buy, sell);
        return this;
    }

}
