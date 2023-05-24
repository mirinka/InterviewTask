package verifications;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusCodeVerifications {

    public static void verify200ResponseCode(Response response) {
        assertEquals(200, response.statusCode(), "Incorrect response code");
    }

    public static void verify201ResponseCode(Response response) {
        assertEquals(201, response.statusCode(), "Incorrect response code");
    }

    public static void verify204ResponseCode(Response response) {
        assertEquals(204, response.statusCode(), "Incorrect response code");
    }

    public static void verify401ResponseCode(Response response) {
        assertEquals(401, response.statusCode(), "Incorrect response code");
    }

    public static void verify404ResponseCode(Response response) {
        assertEquals(404, response.statusCode(), "Incorrect response code");
    }

    public static void verify422ResponseCode(Response response) {
        assertEquals(422, response.statusCode(), "Incorrect response code");
    }

    public static void verify201or422StatusCode(Response response) {
        assertThat(response.statusCode(), either(is(201)).or(is(422)));
    }

    public static void verifyResponseCodeEquals(int expectedCode, int actualCode) {
        Assertions.assertEquals(expectedCode, actualCode, "Status code is not correct as expected");
    }
}
