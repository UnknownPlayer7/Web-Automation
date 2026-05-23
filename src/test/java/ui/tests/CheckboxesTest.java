package ui.tests;

import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {

    private final CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Test
    public void checkboxesTest() {
        mainPage.navigateTo(MainPageLink.CHECKBOXES);
        Assert.assertTrue(checkboxesPage.state().waitForDisplayed(), "The Checkboxes Page isn't displayed!");

        checkboxesPage.checkFirstCheckBox();
        checkboxesPage.uncheckSecondCheckBox();

        Assert.assertTrue(checkboxesPage.isFirstCheckBoxChecked(), "The first checkbox is unchecked!");
        Assert.assertFalse(checkboxesPage.isSecondCheckBoxChecked(), "The second checkbox is checked!");
    }
}
