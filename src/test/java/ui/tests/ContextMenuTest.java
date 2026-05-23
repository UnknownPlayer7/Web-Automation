package ui.tests;

import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ContextMenuPage;

public class ContextMenuTest extends TestBase {

    private final ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Test
    public void contextMenuTest() {
        mainPage.navigateTo(MainPageLink.CONTEXT_MENU);
        Assert.assertTrue(contextMenuPage.state().waitForDisplayed(), "Context Menu Page isn't displayed!");

        contextMenuPage.rightClickOnHotSpot();
        Assert.assertTrue(contextMenuPage.isAlertDisplayed(), "The Alert isn't displayed!");
    }
}
