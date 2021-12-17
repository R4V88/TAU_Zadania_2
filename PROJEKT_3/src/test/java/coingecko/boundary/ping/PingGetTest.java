package coingecko.boundary.ping;

import common.constants.AutomatedTestConstants;
import common.utils.UrlBuilder;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PingGetTest {
    @Test
    @DisplayName("GET /api/v3/ping get server status")
    void getServerStatus() {
        //GIVEN
        String url = new UrlBuilder(AutomatedTestConstants.URL_COINGECKO_API)
                .add(AutomatedTestConstants.PING_PATH)
                .build();

        //WHEN
        Response response = given()
                .contentType(AutomatedTestConstants.MEDIA_TYPE_JSON)
                .when()
                .get(url)

        //THEN
                .then()
                .log().ifValidationFails()
                .statusCode(AutomatedTestConstants.HTTP_OK)
                .extract()
                .response();

        String message = response.getBody().jsonPath().getString("gecko_says");

        assertEquals("(V3) To the Moon!", message);
    }

    @Test
    @DisplayName("GET /api/v3/ping get server status when path is incorrect")
    void getServerStatusWhenPathIsIncorrect() {
        //GIVEN
        String url = new UrlBuilder(AutomatedTestConstants.URL_COINGECKO_API)
                .add("/ping")
                .build();

        //WHEN
        Response response = given()
                .contentType(AutomatedTestConstants.MEDIA_TYPE_JSON)
                .when()
                .get(url)

        //THEN
                .then()
                .log().ifValidationFails()
                .statusCode(AutomatedTestConstants.HTTP_NOT_FOUND)
                .extract()
                .response();

        String message = response.getBody().jsonPath().getString("error");

        assertEquals(AutomatedTestConstants.WRONG_URI, message);
    }
}
