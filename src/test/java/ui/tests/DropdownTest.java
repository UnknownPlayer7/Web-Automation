package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.constants.DropdownOptions;
import ui.constants.MainPageLink;
import ui.pages.DropdownPage;

public class DropdownTest extends TestBase {

    private final DropdownPage dropdownPage = new DropdownPage();

    @Test
    public void dropdownTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        mainPage.navigateTo(MainPageLink.DROPDOWN);
        Assert.assertTrue(dropdownPage.state().waitForDisplayed(), "The Dropdown Page isn't displayed!");

        dropdownPage.chooseOption(DropdownOptions.OPTION_2);
        Assert.assertEquals(dropdownPage.getSelectedText(), DropdownOptions.OPTION_2.getText(),
                "The selected text in the dropdown doesn't match the expected one!");

    }
}
