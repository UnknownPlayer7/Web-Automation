package api.tests;

import utils.SettingsTestData;

public class ApiTestBase {
    protected static final String USERNAME = System.getenv("USER");
    protected static final String PASSWORD = System.getenv("PASSWORD");
    protected static final String CONTENT = SettingsTestData.getAuthData().getContent();
}
