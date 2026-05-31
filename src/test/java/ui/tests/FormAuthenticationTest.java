package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.models.LoginData;
import ui.pages.LoginPage;
import ui.pages.SecureAreaPage;
import utils.TestDataSupplier;

public class FormAuthenticationTest extends TestBase {

    private static final String ERROR_MESSAGE = TestDataSupplier.getFormAuthenticationData().getErrorMessage();
    private static final String SUCCESS_MESSAGE = TestDataSupplier.getFormAuthenticationData().getSuccessMessage();
    private static final String LOGOUT_MESSAGE = TestDataSupplier.getFormAuthenticationData().getLogoutMessage();
    private final LoginPage loginPage = new LoginPage();
    private final SecureAreaPage secureAreaPage = new SecureAreaPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(loginPage, MainPageLink.FORM_AUTHENTICATION);
    }

    @Test(dataProvider = "validCredentialsProvider")
    public void validCredentialsTest(LoginData credentials) {
        loginPage.login(credentials.getUsername(), credentials.getPassword());

        Assert.assertTrue(secureAreaPage.isSuccessMessageDisplayed(), "The Success Message isn't displayed!");
        Assert.assertEquals(secureAreaPage.getSuccessMessageText(), SUCCESS_MESSAGE,
                "The expected text doesn't match the actual one!");

        secureAreaPage.logout();

        Assert.assertTrue(loginPage.isNotificationMessageDisplayed(), "The Logout Message isn't displayed!");
        Assert.assertEquals(loginPage.getNotificationMessageText(), LOGOUT_MESSAGE,
                "The expected text doesn't match the actual one!");
    }

    @DataProvider
    public LoginData[][] validCredentialsProvider() {
        return TestDataSupplier.getValidCredentials();
    }

    @Test(dataProvider = "invalidCredentialsProvider")
    public void invalidCredentialsTest(LoginData credentials) {
        loginPage.login(credentials.getUsername(), credentials.getPassword());

        Assert.assertTrue(loginPage.isNotificationMessageDisplayed(), "The Error Message isn't displayed!");
        Assert.assertEquals(loginPage.getNotificationMessageText(), ERROR_MESSAGE,
                "The expected text doesn't match the actual one!");
    }

    @DataProvider
    public LoginData[][] invalidCredentialsProvider() {
        return TestDataSupplier.getInvalidCredentials();
    }
}
