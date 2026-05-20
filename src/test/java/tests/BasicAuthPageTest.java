package tests;

import constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasicAuthPage;
import utils.SettingsTestData;

public class BasicAuthPageTest extends TestBase{

    private static final String USERNAME = System.getenv("USER");
    private static final String PASSWORD = System.getenv("PASSWORD");

    private final BasicAuthPage basicAuthPage = new BasicAuthPage();

    @Test
    public void basicAuthPageTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        addBasicAuthentication(USERNAME, PASSWORD);
        mainPage.navigateTo(MainPageLink.BASIC_AUTH);

        Assert.assertTrue(basicAuthPage.state().waitForDisplayed(),
                "The Basic Authentication Page isn't displayed!");
    }
}
