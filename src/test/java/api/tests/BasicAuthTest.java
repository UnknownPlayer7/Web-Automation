package api.tests;

import api.clients.BasicAuthClient;
import org.testng.annotations.Test;
import utils.SettingsTestData;

import static org.hamcrest.Matchers.containsString;

public class BasicAuthTest {

    private static final String USERNAME = System.getenv("USER");
    private static final String PASSWORD = System.getenv("PASSWORD");
    private static final String CONTENT = SettingsTestData.getAuthData().getContent();
    private final BasicAuthClient basicAuthClient = new BasicAuthClient();

    @Test
    public void basicAuthTest() {
        basicAuthClient.login(USERNAME, PASSWORD)
                .then()
                .statusCode(200)
                .body(containsString(CONTENT));
    }
}
