package ge.tbcacademy.data;

public class Constants {
    public static final String BASE_URI = "https://apigw.tbc.ge",
            TBC_URL = "https://tbcbank.ge",
            APPLICATION = "application/json",
            START_LOCATE = "{\"Locale\": \"",
            END_LOCATE =  "\"}",
            USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36",
            BASE_PATH_ATM = "/api/v1/atmsAndBranches/list",
            BASE_PATH_FEE = "/api/v1/moneyTransfer/fees";


    public static final int STATUS_200 = 200,
            AMOUNT_100 = 100,
            AMOUNT_200 = 200,
            AMOUNT_500 = 500,
            AMOUNT_1000 = 1000;
}
