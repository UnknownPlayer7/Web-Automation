package tests;

import constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;

public class AddRemoveElementsPageTest extends TestBase {

    private final AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

    @Test
    public void addRemoveElementsPageTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        mainPage.navigateTo(MainPageLink.ADD_REMOVE_ELEMENTS);
        Assert.assertTrue(addRemoveElementsPage.state().waitForDisplayed(),
                "Add/Remove Elements Page isn't displayed!");

        addRemoveElementsPage.clickAddButton();
        Assert.assertTrue(addRemoveElementsPage.isDeleteButtonDisplayed(), "A delete button isn't displayed!");

        addRemoveElementsPage.clickDeleteButton();
        Assert.assertFalse(addRemoveElementsPage.isDeleteButtonDisplayed(), "A delete button is displayed!");
    }

}
