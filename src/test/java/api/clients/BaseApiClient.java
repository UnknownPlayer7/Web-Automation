package api.clients;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.TestDataSupplier;

public class BaseApiClient {

    private static final String BASE_URL = TestDataSupplier.getEnvData().getHost();
    protected RequestSpecification baseRequestSpec;

    public BaseApiClient() {
        baseRequestSpec = RestAssured.given()
                .baseUri(BASE_URL)
                .log().ifValidationFails();
    }
}
