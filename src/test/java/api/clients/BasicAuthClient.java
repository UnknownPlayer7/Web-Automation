package api.clients;

import api.endpoints.AuthEndpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BasicAuthClient extends BaseApiClient{

    public Response login(String username, String password) {
        return given(baseRequestSpec)
                .auth()
                .basic(username, password)
                .when()
                .get(AuthEndpoints.BASIC_AUTH);
    }
}
