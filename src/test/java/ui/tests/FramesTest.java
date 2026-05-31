package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.FramesPageLink;
import ui.constants.MainPageLink;
import ui.constants.NestedFrames;
import ui.pages.FramesPage;
import ui.pages.NestedFramesPage;
import utils.BrowserUtils;

public class FramesTest extends TestBase {

    private final FramesPage framesPage = new FramesPage();
    private final NestedFramesPage nestedFramesPage = new NestedFramesPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(framesPage, MainPageLink.FRAMES);
    }

    @Test
    public void nestedFramesTest() {
        framesPage.navigateTo(FramesPageLink.NESTED_FRAMES);
        Assert.assertTrue(nestedFramesPage.state().waitForDisplayed(), "The Nested Frames isn't displayed!");

        nestedFramesPage.switchTo(NestedFrames.FRAME_TOP);
        nestedFramesPage.switchTo(NestedFrames.FRAME_RIGHT);
        Assert.assertEquals(nestedFramesPage.getFrameContentText(), "RIGHT");

        BrowserUtils.switchToParentFrame();
        nestedFramesPage.switchTo(NestedFrames.FRAME_MIDDLE);
        Assert.assertEquals(nestedFramesPage.getFrameContentText(), "MIDDLE");

        BrowserUtils.switchToParentFrame();
        nestedFramesPage.switchTo(NestedFrames.FRAME_LEFT);
        Assert.assertEquals(nestedFramesPage.getFrameContentText(), "LEFT");

        BrowserUtils.switchToDefaultContent();
        nestedFramesPage.switchTo(NestedFrames.FRAME_BOTTOM);
        Assert.assertEquals(nestedFramesPage.getFrameContentText(), "BOTTOM");
    }


}
