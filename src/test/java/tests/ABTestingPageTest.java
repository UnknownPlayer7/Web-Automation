package tests;

import constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ABTestingPage;

public class ABTestingPageTest extends TestBase{

    private final ABTestingPage abTestingPage = new ABTestingPage();

    @Test
    public void abTestingPageTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        addCookie("optimizelyOptOut", "true");
        mainPage.navigateTo(MainPageLink.AD_TESTING);

        Assert.assertTrue(abTestingPage.hasDefaultContent(),
                "The default content isn't displayed on the A/B Testing Page!");
    }
}
