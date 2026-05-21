package api.tests;

import utils.TestDataSupplier;

public class ApiTestBase {
    protected static final String USERNAME = System.getenv("USER");
    protected static final String PASSWORD = System.getenv("PASSWORD");
    protected static final String CONTENT = TestDataSupplier.getAuthData().getContent();
}
