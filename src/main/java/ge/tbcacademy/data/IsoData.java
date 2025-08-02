package ge.tbcacademy.data;

import org.testng.annotations.DataProvider;

public class IsoData {
    @DataProvider(name = "isoProvider")
    public Object[][] isoProvider() {
        return new Object[][]{
                {"USD", "GEL"},
                {"EUR", "GEL"},
                {"GBP", "GEL"},
                {"USD", "CHF"},
                {"ILS", "AED"},
                {"RUR", "JPY"}
        };
    }
}