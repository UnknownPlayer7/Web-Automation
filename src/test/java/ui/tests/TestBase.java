package ui.tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pages.MainPage;
import utils.TestDataSupplier;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class TestBase {

    private static final String MAIN_PAGE_HOST = TestDataSupplier.getEnvData().getHost();
    protected final MainPage mainPage = new MainPage();

    @BeforeMethod
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(MAIN_PAGE_HOST);
    }

    @BeforeMethod
    public void isMainPageOpenTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "The Main Page isn't displayed!");
    }

    @AfterMethod
    public void teardown() {
        getBrowser().quit();
    }

    protected void addCookie(String name, String value) {
        getBrowser().getDriver().manage().addCookie(new Cookie(name, value));
    }

    protected void addBasicAuthentication(String username, String password) {
        getBrowser().network().addBasicAuthentication(MAIN_PAGE_HOST, username, password);
    }
}
