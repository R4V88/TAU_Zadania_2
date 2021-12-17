package coingecko.boundary.simple;

import common.constants.AutomatedTestConstants;
import common.utils.UrlBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class priceGetTest {
    @Test
    @DisplayName("GET /api/v3/simple/price Get empty price response when parameters are incorrect")
    void getEmptyPriceResponseWithWrongParametersGiven() {
        String id = "01coinZz";

        //GIVEN
        String url = new UrlBuilder(AutomatedTestConstants.URL_COINGECKO_API)
                .add(AutomatedTestConstants.SIMPLE_PATH)
                .add("price?ids=01coinZz&vs_currencies=btk")
                .build();

        //WHEN
        Response response = given()
                .contentType(AutomatedTestConstants.MEDIA_TYPE_JSON)
                .when()
                .get(url)

        //THEN
                .then()
                .log()
                .ifValidationFails()
                .statusCode(AutomatedTestConstants.HTTP_OK)
                .extract()
                .response();

        String responseBody = response.asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String valueOfId = jsonPath.getString(id);

        assertNull(valueOfId);
    }

    @Test
    @DisplayName("GET /api/v3/simple/price Get price and http response OK")
    void getPriceResponseWithCorrectParametersGiven() {
        String id = "01coin";
        String vsCurrency = "btc";

        //GIVEN
        String url = new UrlBuilder(AutomatedTestConstants.URL_COINGECKO_API)
                .add(AutomatedTestConstants.SIMPLE_PATH)
                .add("price?ids=01coin&vs_currencies=btc")
                .build();

        //WHEN
        Response response = given()
                .contentType(AutomatedTestConstants.MEDIA_TYPE_JSON)
                .when()
                .get(url)

        //THEN
                .then()
                .log()
                .ifValidationFails()
                .statusCode(AutomatedTestConstants.HTTP_OK)
                .extract()
                .response();

        String responseBody = response.asString();
        JsonPath jsonPath = new JsonPath(responseBody);
        String valueOfId = jsonPath.getString(id);
        String valueOfVsCurrency = jsonPath.getString(id+"."+vsCurrency);

        assertNotNull(valueOfId);
        assertNotNull(valueOfVsCurrency);
    }
}
