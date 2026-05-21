package api.tests;

import api.clients.DigestAuthClient;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;

public class DigestAuthTest extends ApiTestBase {

    private final DigestAuthClient digestAuthClient = new DigestAuthClient();

    @Test
    public void digestAuthTest() {
        digestAuthClient.loginWithDigest(USERNAME, PASSWORD)
                .then()
                .statusCode(200)
                .body(containsString(CONTENT));
    }
}
