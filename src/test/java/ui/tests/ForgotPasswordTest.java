package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.ForgotPasswordPage;
import ui.pages.LoginPage;
import ui.pages.SecureAreaPage;
import utils.BrowserUtils;
import utils.EmailUtils;
import utils.models.LoginData;

public class ForgotPasswordTest extends TestBase {

    private static final String RECIPIENT = System.getenv("USER_EMAIL");
    private static final String RECIPIENT_PASSWORD = System.getenv("EMAIL_PASSWORD");
    private static final String SERVICE_EMAIL = System.getenv("SERVICE_EMAIL");
    private final ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private final LoginPage loginPage = new LoginPage();
    private final SecureAreaPage secureAreaPage = new SecureAreaPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(forgotPasswordPage, MainPageLink.FORGOT_PASSWORD);
    }

    @Test
    public void forgotPasswordTest() {
        forgotPasswordPage.enterEmail(RECIPIENT);
        forgotPasswordPage.clickRetrievePasswordButton();

        LoginData loginData = EmailUtils.getRestoredLoginData(RECIPIENT, RECIPIENT_PASSWORD, SERVICE_EMAIL);
        BrowserUtils.navigateTo(loginData.getUrl());

        Assert.assertTrue(loginPage.state().waitForDisplayed(), "The Login Page isn't displayed!");

        loginPage.enterUsername(loginData.getUsername());
        loginPage.enterPassword(loginData.getPassword());
        loginPage.clickLoginButton();

        Assert.assertTrue(secureAreaPage.state().waitForDisplayed(), "The Secure Area Page isn't displayed!");
    }
}
