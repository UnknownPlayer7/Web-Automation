package tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.MainPage;
import utils.SettingsTestData;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class TestBase {

    private static final String MAIN_PAGE_HOST = SettingsTestData.getEnvData().getHost();
    protected final MainPage mainPage = new MainPage();

    @BeforeMethod
    public void setup() {
        getBrowser().maximize();
        getBrowser().goTo(MAIN_PAGE_HOST);
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
