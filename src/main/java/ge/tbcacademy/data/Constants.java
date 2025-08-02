package ge.tbcacademy.data;

public class Constants {
    public static final String
            BASE_URI = "https://apigw.tbc.ge",
            TBC_URL = "https://tbcbank.ge",
            BLOG_BASE_PATH = "/api/v1/marketing/entries/blog",
            APPLICATION = "application/json",
            PAYLOAD_BRANCHES = "payload.branches",
            START_LOCATE = "{\"Locale\": \"",
            END_LOCATE = "\"}",
            EMPTY = "",
            BASE_PATH_ATM = "/api/v1/atmsAndBranches/list",
            BASE_PATH_FEE = "/api/v1/moneyTransfer/fees",
            OUTSIDE_GEORGIA = "Found outside Georgia";

    public static final int
            STATUS_200 = 200,
            ZERO = 0,
            AMOUNT_999999999 = 999999999;

    public static final double
            MIN_LAT = 41.0,
            MAX_LAT = 43.6,
            MIN_LNG = 40.0,
            MAX_LNG = 47.5;
}
