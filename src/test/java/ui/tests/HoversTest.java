package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.models.HoversData;
import ui.pages.HoversPage;
import utils.BrowserUtils;
import utils.TestDataSupplier;

public class HoversTest extends TestBase{

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(new HoversPage(), MainPageLink.HOVERS);
    }

    @Test(dataProvider = "provideHoverData")
    public void userDataIsDisplayedOnHoverTest(HoversData hoversData) {
        HoversPage hoversPage = new HoversPage();
        Assert.assertTrue(hoversPage.isUserDataHidden(hoversData.getUserIndex()),
                "The User-%d Data isn't hidden on the page load".formatted(
                        hoversData.getUserIndex() + 1));

        hoversPage.hoverOverUserFigure(hoversData.getUserIndex());
        Assert.assertTrue(hoversPage.isUserDataDisplayed(hoversData.getUserIndex()),
                "The User-%d Data isn't displayed on hover".formatted(hoversData.getUserIndex() + 1));

        hoversPage.moveMouseFromUserFigure(hoversData.getUserIndex());
        Assert.assertTrue(hoversPage.isUserDataHidden(hoversData.getUserIndex()),
                "The User-%d Data isn't hidden upon moving mouse away from the user figure".formatted(
                        hoversData.getUserIndex() + 1));
    }

    @DataProvider
    public HoversData[][] provideHoverData() {
        return TestDataSupplier.getHoversData();
    }

    @Test(dataProvider = "provideHoverData")
    public void userLabelTest(HoversData hoversData) {
        HoversPage hoversPage = new HoversPage();
        hoversPage.hoverOverUserFigure(hoversData.getUserIndex());

        Assert.assertEquals(hoversPage.getUserLabelText(hoversData.getUserIndex()), hoversData.getUserLabel(),
                "The User-%d Label doesn't match the expected one!".formatted(
                        hoversData.getUserIndex() + 1));
    }

    @Test(dataProvider = "provideHoverData")
    public void userLinkTest(HoversData hoversData) {
        HoversPage hoversPage = new HoversPage();
        hoversPage.hoverOverUserFigure(hoversData.getUserIndex());

        Assert.assertEquals(hoversPage.getUserLinkText(hoversData.getUserIndex()), hoversData.getUserLinkText(),
                "The User-%d Link text doesn't match the expected one!".formatted(
                        hoversData.getUserIndex() + 1));
    }

    @Test(dataProvider = "provideHoverData")
    public void userLinkNavigationTest(HoversData hoversData) {
        HoversPage hoversPage = new HoversPage();
        hoversPage.hoverOverUserFigure(hoversData.getUserIndex());
        hoversPage.clickUserLink(hoversData.getUserIndex());

        Assert.assertEquals(BrowserUtils.getCurrentEndpoint(), hoversData.getEndpoint(),
                "The current endpoint doesn't match the expected one!");
    }
}
