package coingecko.boundary.simple;

import common.constants.AutomatedTestConstants;
import common.utils.UrlBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupportVsCurrenciesGetTest {

    private final List<String> all = List.of(
            "btc", "eth", "ltc", "bch", "bnb", "eos", "xrp", "xlm", "link", "dot", "yfi",
            "usd", "aed", "ars", "aud", "bdt", "bhd", "bmd", "brl", "cad", "chf", "clp", "cny", "czk", "dkk", "eur", "gbp",
            "hkd", "huf", "idr", "ils", "inr", "jpy", "krw", "kwd", "lkr", "mmk", "mxn", "myr", "ngn", "nok", "nzd", "php",
            "pkr", "pln", "rub", "sar", "sek", "sgd", "thb", "try", "twd", "uah", "vef", "vnd", "zar", "xdr", "xag", "xau",
            "bits", "sats"
    );

    @Test
    @DisplayName("GET /api/v3/simple/supported_vs_currencies get list of supported_vs_currencies")
    void getListOfSupportedVsCurrencies() {
        //GIVEN
        String urlCurrencyShorts = new UrlBuilder(AutomatedTestConstants.URL_COINGECKO_API)
                .add(AutomatedTestConstants.SIMPLE_PATH)
                .add("supported_vs_currencies")
                .build();

        //WHEN
        Response response = given()
                .contentType(AutomatedTestConstants.MEDIA_TYPE_JSON)
                .when()
                .get(urlCurrencyShorts)

                //THEN
                .then()
                .log()
                .ifValidationFails()
                .statusCode(AutomatedTestConstants.HTTP_OK)
                .body("size()", is(61))
                .extract()
                .response();

        String responseBody = response.asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        jsonPath.getList("");

        assertEquals(all, jsonPath.getList(""));
    }
}
