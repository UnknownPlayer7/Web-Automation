package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.DynamicLoadingPageLink;
import ui.constants.MainPageLink;
import ui.pages.DynamicLoadingPage;
import ui.pages.HiddenElementPage;
import ui.pages.NotRenderedElementPage;

public class DynamicLoadingTest extends TestBase {

    private final DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
    private final HiddenElementPage hiddenElementPage = new HiddenElementPage();
    private final NotRenderedElementPage notRenderedElementPage = new NotRenderedElementPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(dynamicLoadingPage, MainPageLink.DYNAMIC_LOADING);
    }

    @Test
    public void hiddenElementTest() {
        dynamicLoadingPage.navigateTo(DynamicLoadingPageLink.EXAMPLE_1);
        Assert.assertTrue(hiddenElementPage.state().waitForDisplayed(),
                "The Hidden Element Page isn't displayed!");

        Assert.assertTrue(hiddenElementPage.isHiddenElementNotDisplayed(), "The Hidden Element is visible!");
        hiddenElementPage.clickStartButton();

        Assert.assertTrue(hiddenElementPage.isHiddenElementDisplayed(), "The Hidden Element isn't displayed!");
    }

    @Test
    public void notRenderedElementTest() {
        dynamicLoadingPage.navigateTo(DynamicLoadingPageLink.EXAMPLE_2);
        Assert.assertTrue(notRenderedElementPage.state().waitForDisplayed(),
                "The Not Rendered Element Page isn't displayed!");

        Assert.assertTrue(notRenderedElementPage.isNotRenderedElementNotDisplayed(),
                "The Not Rendered Element is visible!");
        notRenderedElementPage.clickStartButton();

        Assert.assertTrue(notRenderedElementPage.isNotRenderedElementDisplayed(),
                "The Not Rendered Element isn't displayed!");
    }
}
