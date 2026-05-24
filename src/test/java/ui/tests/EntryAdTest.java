package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.EntryAdPage;

public class EntryAdTest extends TestBase {

    private final EntryAdPage entryAdPage = new EntryAdPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(entryAdPage, MainPageLink.ENTRY_AD);
    }

    @Test
    public void firstVisitEntryAdAppearsTest() {
        Assert.assertTrue(entryAdPage.isEntryAdDisplayed(), "The Entry Ad isn't displayed!");
    }

    @Test
    public void closeEntryAdWithButtonTest() {
        Assert.assertTrue(entryAdPage.isEntryAdDisplayed(), "The Entry Ad isn't displayed!");
        entryAdPage.clickCloseEntryAdButton();

        Assert.assertFalse(entryAdPage.isEntryAdDisplayed(),
                "The Entry Ad appears again after its closing!");
    }

    @Test
    public void closeEntryAdWithClickingBeyondTest() {
        Assert.assertTrue(entryAdPage.isEntryAdDisplayed(), "The Entry Ad isn't displayed!");
        entryAdPage.clickBeyondEntryAd();

        Assert.assertFalse(entryAdPage.isEntryAdDisplayed(),
                "The Entry Ad appears again after its closing!");
    }

    @Test
    public void enableEntryAdTest() {
        Assert.assertTrue(entryAdPage.isEntryAdDisplayed(), "The Entry Ad isn't displayed!");
        entryAdPage.clickCloseEntryAdButton();
        entryAdPage.enableEntryAd();

        Assert.assertTrue(entryAdPage.isEntryAdDisplayed(),
                "The Entry Ad doesn't appear after its enabling!");
    }
}
