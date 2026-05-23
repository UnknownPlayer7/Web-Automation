package ui.tests;

import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.BrokenImagesPage;

import java.util.List;

public class BrokenImagesTest extends TestBase {

    private final BrokenImagesPage brokenImagesPage = new BrokenImagesPage();

    @Test
    public void brokenImagesTest() {
        mainPage.navigateTo(MainPageLink.BROKEN_IMAGES);
        Assert.assertTrue(brokenImagesPage.state().waitForDisplayed(),
                "The Broken Images Page isn't displayed!");

        List<String> brokenImages = brokenImagesPage.getBrokenImages();
        Assert.assertTrue(brokenImages.isEmpty(), "There are broken images: " + brokenImages);
    }
}
