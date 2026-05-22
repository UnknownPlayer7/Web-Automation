package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.DisappearingElementsPage;
import ui.pages.GalleryPage;
import utils.TestDataSupplier;

public class DisappearingElementsTest extends TestBase {

    private static final int RETRIES = TestDataSupplier.getDisappearingElementsData().getRefreshRetries();
    private final DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage();
    private final GalleryPage galleryPage = new GalleryPage();

    /**
     * This test verifies whether the {@code Gallery} Button is stable or not.
     * It refreshes the page several times and attempts to locate the button during each retry.
     * Lastly, if {@code failCount} is greater than {@code zero} the test throws the {@code AssertionError}.
     */
    @Test
    public void disappearingElementsStabilityTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        mainPage.navigateTo(MainPageLink.DISAPPEARING_ELEMENTS);
        Assert.assertTrue(disappearingElementsPage.state().waitForDisplayed(),
                "The Disappearing Elements Page isn't displayed!");

        int failCount = 0;
        for (int i = 0; i < RETRIES; i++) {
            if (!disappearingElementsPage.isGalleryButtonDisplayed()) {
                failCount++;
            }
            disappearingElementsPage.refreshPage();
        }

        Assert.assertTrue(failCount == 0,
                "The Gallery Button disappeared %d times. Page refreshed %d times".formatted(failCount, RETRIES));
    }

    /**
     * This test attempts to locate the {@code Gallery} Button which might not be displayed on the page.
     * It refreshes the page until the button appears and clicks it.
     * Lastly, it verifies that the {@code Gallery} Page is displayed.
     */
    @Test
    public void disappearingElementsInteractionTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        mainPage.navigateTo(MainPageLink.DISAPPEARING_ELEMENTS);
        Assert.assertTrue(disappearingElementsPage.state().waitForDisplayed(),
                "The Disappearing Elements Page isn't displayed!");

        boolean isGalleryButtonAppeared = false;
        for (int i = 0; i < RETRIES; i++) {
            if (disappearingElementsPage.isGalleryButtonDisplayed()) {
                disappearingElementsPage.clickGalleryButton();
                isGalleryButtonAppeared = true;

                break;
            }
            disappearingElementsPage.refreshPage();
        }

        Assert.assertTrue(isGalleryButtonAppeared,
                "The Gallery Button didn't appear during the page refreshing process!");
        Assert.assertTrue(galleryPage.state().waitForDisplayed(), "The Gallery Page isn't displayed!");
    }
}
