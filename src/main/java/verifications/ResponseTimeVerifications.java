package verifications;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.lessThan;

public class ResponseTimeVerifications {

    public static void verifyResponseTimeLessThan(Response response, Long threshold) {
        response.then().time(lessThan(threshold));
    }
}
