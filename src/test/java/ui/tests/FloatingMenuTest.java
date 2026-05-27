package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.FloatingMenuPage;
import utils.BrowserUtils;
import utils.models.ValidationResult;

public class FloatingMenuTest extends TestBase {

    private final FloatingMenuPage floatingMenuPage = new FloatingMenuPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(floatingMenuPage, MainPageLink.FLOATING_MENU);
    }

    @Test
    public void floatingMenuTest() {
        Assert.assertTrue(floatingMenuPage.isFloatingMenuDisplayed(),
                "The floating menu isn't displayed!");

        BrowserUtils.scrollDownBy(3000);
        BrowserUtils.scrollDownToPageEnd();

        ValidationResult validationResult = floatingMenuPage.validateEntireFloatingMenuIsOnScreen();
        Assert.assertTrue(validationResult.isValid(),
                "The element isn't floating correctly!\n%s".formatted(validationResult.getReport()));
    }
}
