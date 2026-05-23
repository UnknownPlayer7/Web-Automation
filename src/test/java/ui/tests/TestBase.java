package ui.tests;

import aquality.selenium.forms.Form;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.constants.MainPageLink;
import ui.pages.MainPage;
import utils.TestDataSupplier;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class TestBase {

    private static final String MAIN_PAGE_HOST = TestDataSupplier.getEnvData().getHost();
    protected final MainPage mainPage = new MainPage();

    @BeforeMethod
    protected void setup() {
        getBrowser().maximize();
        getBrowser().goTo(MAIN_PAGE_HOST);
    }

    @BeforeMethod
    protected void verifyMainPageIsOpened() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "The Main Page isn't displayed!");
    }

    @AfterMethod
    protected void teardown() {
        getBrowser().quit();
    }

    protected void addCookie(String name, String value) {
        getBrowser().getDriver().manage().addCookie(new Cookie(name, value));
    }

    protected void addBasicAuthentication(String username, String password) {
        getBrowser().network().addBasicAuthentication(MAIN_PAGE_HOST, username, password);
    }

    /**
     * This method navigate to the passed {@code page} and then verifies that the {@code page} is displayed
     * @param page an instance of the extended {@link Form} class
     * @param link an instance of the {@link MainPageLink}
     */
    protected void navigateAndCheck(Form page, MainPageLink link) {
        mainPage.navigateTo(link);
        Assert.assertTrue(page.state().waitForDisplayed(),
                "The %s isn't displayed!".formatted(page.getName()));
    }
}
