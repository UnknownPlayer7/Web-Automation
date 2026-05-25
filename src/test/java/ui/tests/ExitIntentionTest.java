package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.ExitIntentionPage;
import utils.BrowserUtils;

public class ExitIntentionTest extends TestBase {

    private final ExitIntentionPage exitIntentionPage = new ExitIntentionPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(exitIntentionPage, MainPageLink.EXIT_INTENTION);
    }

    @Test
    public void exitIntentionTest() {
        Assert.assertTrue(exitIntentionPage.isModalWindowNotDisplayed(), "The Modal Window should be hidden!");
        BrowserUtils.imitateMouseMoveBeyondViewPort();

        Assert.assertTrue(exitIntentionPage.isModalWindowDisplayed(), "The Modal Window should be visible!");
    }
}
