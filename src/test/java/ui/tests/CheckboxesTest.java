package ui.tests;

import org.testng.annotations.BeforeMethod;
import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {

    private final CheckboxesPage checkboxesPage = new CheckboxesPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(checkboxesPage, MainPageLink.CHECKBOXES);
    }

    @Test
    public void checkboxesTest() {
        checkboxesPage.checkFirstCheckBox();
        checkboxesPage.uncheckSecondCheckBox();

        Assert.assertTrue(checkboxesPage.isFirstCheckBoxChecked(), "The first checkbox is unchecked!");
        Assert.assertFalse(checkboxesPage.isSecondCheckBoxChecked(), "The second checkbox is checked!");
    }
}
