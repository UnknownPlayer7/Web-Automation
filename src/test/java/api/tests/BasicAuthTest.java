package api.tests;

import api.clients.BasicAuthClient;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;

public class BasicAuthTest extends ApiTestBase {

    private final BasicAuthClient basicAuthClient = new BasicAuthClient();

    @Test
    public void basicAuthTest() {
        basicAuthClient.login(USERNAME, PASSWORD)
                .then()
                .statusCode(200)
                .body(containsString(CONTENT));
    }
}
