package ui.tests;

import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.ContextMenuPage;

public class ContextMenuPageTest extends TestBase {

    private final ContextMenuPage contextMenuPage = new ContextMenuPage();

    @Test
    public void contextMenuPageTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        mainPage.navigateTo(MainPageLink.CONTEXT_MENU);
        Assert.assertTrue(contextMenuPage.state().waitForDisplayed(), "Context Menu Page isn't displayed!");

        contextMenuPage.rightClickOnHotSpot();
        Assert.assertTrue(contextMenuPage.isAlertDisplayed(), "The Alert isn't displayed!");
    }
}
