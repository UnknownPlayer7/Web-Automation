package ui.tests;

import org.testng.annotations.BeforeMethod;
import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ABTestingPage;

public class ABTestingTest extends TestBase {

    private final ABTestingPage abTestingPage = new ABTestingPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        addCookie("optimizelyOptOut", "true");
        navigateAndCheck(abTestingPage, MainPageLink.AD_TESTING);
    }

    @Test
    public void abTestingTest() {
        Assert.assertTrue(abTestingPage.hasDefaultContent(),
                "The default content isn't displayed on the A/B Testing Page!");
    }
}
