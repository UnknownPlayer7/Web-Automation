package ui.tests;

import org.testng.annotations.BeforeMethod;
import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.BrokenImagesPage;

import java.util.List;

public class BrokenImagesTest extends TestBase {

    private final BrokenImagesPage brokenImagesPage = new BrokenImagesPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(brokenImagesPage, MainPageLink.BROKEN_IMAGES);
    }

    @Test
    public void brokenImagesTest() {
        List<String> brokenImages = brokenImagesPage.getBrokenImages();
        Assert.assertTrue(brokenImages.isEmpty(), "There are broken images: " + brokenImages);
    }
}
