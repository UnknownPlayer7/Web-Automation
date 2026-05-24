package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.MainPageLink;
import ui.pages.DynamicControlsPage;
import utils.TestDataSupplier;

public class DynamicControlsTest extends TestBase {

    private static final String TEXT_TO_ENTER = TestDataSupplier.getDynamicControlsData().getTextToEnter();
    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(dynamicControlsPage, MainPageLink.DYNAMIC_CONTROLS);
    }

    @Test
    public void removeCheckBoxTest() {
        Assert.assertTrue(dynamicControlsPage.isCheckboxDisplayed(), "Checkbox is hidden!");
        dynamicControlsPage.clickRemoveCheckboxButton();

        Assert.assertTrue(dynamicControlsPage.isCheckboxNotDisplayed(), "Checkbox is visible!");
    }

    @Test
    public void enableInputTest() {
        Assert.assertTrue(dynamicControlsPage.isInputDisabled(), "The Input is enabled");
        dynamicControlsPage.clickInputToggleButton();

        Assert.assertTrue(dynamicControlsPage.isInputEnable(), "The Input is disabled!");

        dynamicControlsPage.enterText(TEXT_TO_ENTER);
        String inputContent = dynamicControlsPage.getInputValue();

        Assert.assertEquals(inputContent, TEXT_TO_ENTER,
                "The entered text doesn't match the content of the input field!");
    }
}
