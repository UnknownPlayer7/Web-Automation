package ui.tests;

import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ABTestingPage;

public class ABTestingTest extends TestBase {

    private final ABTestingPage abTestingPage = new ABTestingPage();

    @Test
    public void abTestingTest() {
        addCookie("optimizelyOptOut", "true");
        mainPage.navigateTo(MainPageLink.AD_TESTING);

        Assert.assertTrue(abTestingPage.hasDefaultContent(),
                "The default content isn't displayed on the A/B Testing Page!");
    }
}
