package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.DropdownOptions;
import ui.constants.MainPageLink;
import ui.pages.DropdownPage;

public class DropdownTest extends TestBase {

    private final DropdownPage dropdownPage = new DropdownPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(dropdownPage, MainPageLink.DROPDOWN);
    }

    @Test
    public void dropdownTest() {
        dropdownPage.chooseOption(DropdownOptions.OPTION_2);
        Assert.assertEquals(dropdownPage.getSelectedText(), DropdownOptions.OPTION_2.getText(),
                "The selected text in the dropdown doesn't match the expected one!");

    }
}
