package ge.tbcacademy.data;

public class Constants {
    public static final String
            BASE_URI = "https://apigw.tbc.ge",
            TBC_URL = "https://tbcbank.ge",
            BLOG_BASE_PATH = "/api/v1/marketing/entries/blog",
            EXCHANGE_RATES_BASE_PATH = "/api/v1/exchangeRates/getExchangeRate",
            COMMERCIAL_LIST_BASE_PATH = "/api/v1/exchangeRates/commercialList",
            APPLICATION = "application/json",
            PAYLOAD_BRANCHES = "payload.branches",
            START_LOCATE = "{\"Locale\": \"",
            END_LOCATE = "\"}",
            EMPTY = "",
            USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36",
            BASE_PATH_ATM = "/api/v1/atmsAndBranches/list",
            BASE_PATH_FEE = "/api/v1/moneyTransfer/fees",
            OUTSIDE_GEORGIA = "Found outside Georgia",
            ISO1_PATH = "iso1",
            ISO2_PATH = "iso2",
            BUY_RATE_PATH = "buyRate",
            SELL_RATE_PATH = "sellRate",
            RATES_ISO_PATH = "rates.iso",
            GEL = "GEL",
            ISO1 = "USD",
            ISO2 = "TRY",
            SEARCH_TITLE = "ელენე შენგელიას პასუხი";

    public static final int
            STATUS_200 = 200,
            ZERO = 0,
            AMOUNT_999999999 = 999999999,
            PAGE_SIZE = 10;


    public static final double
            MIN_LAT = 41.0,
            MAX_LAT = 43.6,
            MIN_LNG = 40.0,
            MAX_LNG = 47.5;
}
