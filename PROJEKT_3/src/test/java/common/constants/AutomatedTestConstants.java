package common.constants;

public interface AutomatedTestConstants {
    //URI
    String URL_COINGECKO_API = "https://api.coingecko.com/api";

    //PATHs
    String PING_PATH = "/v3/ping";
    String SIMPLE_PATH = "/v3/simple";

    //MESSAGES
    String WRONG_URI = "Incorrect path. Please check https://www.coingecko.com/api/";

    //HTTP CODES
    int HTTP_OK = 200;
    int HTTP_NOT_FOUND = 404;

    //HEADERS
    String MEDIA_TYPE_JSON = "application/json";
}
