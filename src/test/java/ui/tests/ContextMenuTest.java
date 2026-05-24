package ui.tests;

import org.testng.annotations.BeforeMethod;
import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ContextMenuPage;

public class ContextMenuTest extends TestBase {

    private final ContextMenuPage contextMenuPage = new ContextMenuPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(contextMenuPage, MainPageLink.CONTEXT_MENU);
    }

    @Test
    public void contextMenuTest() {
        contextMenuPage.rightClickOnHotSpot();
        Assert.assertTrue(contextMenuPage.isAlertDisplayed(), "The Alert isn't displayed!");
    }
}
