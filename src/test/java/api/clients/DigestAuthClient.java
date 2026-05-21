package api.clients;

import api.endpoints.AuthEndpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DigestAuthClient extends  BaseApiClient {

    public Response login(String username, String password) {
        return given(baseRequestSpec)
                .auth()
                .digest(username, password)
                .when()
                .get(AuthEndpoints.DIGEST_AUTH);
    }
}
