package api.tests;

import api.clients.DigestAuthClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import utils.SettingsTestData;

import static org.hamcrest.Matchers.containsString;

public class DigestAuthTest {

    private static final String USERNAME = System.getenv("USER");
    private static final String PASSWORD = System.getenv("PASSWORD");
    private static final String CONTENT = SettingsTestData.getAuthData().getContent();
    private final DigestAuthClient digestAuthClient = new DigestAuthClient();

    @Test
    public void digestAuthTest() {
        digestAuthClient.loginWithDigest(USERNAME, PASSWORD)
                .then()
                .statusCode(200)
                .body(containsString(CONTENT));
    }
}
