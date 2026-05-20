package tests;

import constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesPageTest extends TestBase {

    private final CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Test
    public void checkboxesPageTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        mainPage.navigateTo(MainPageLink.CHECKBOXES);
        Assert.assertTrue(checkboxesPage.state().waitForDisplayed(), "The Checkboxes Page isn't displayed!");

        checkboxesPage.checkFirstCheckBox();
        checkboxesPage.uncheckSecondCheckBox();

        Assert.assertTrue(checkboxesPage.isFirstCheckBoxChecked(), "The first checkbox is unchecked!");
        Assert.assertFalse(checkboxesPage.isSecondCheckBoxChecked(), "The second checkbox is checked!");
    }
}
