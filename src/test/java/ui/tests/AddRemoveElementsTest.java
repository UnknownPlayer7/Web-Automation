package ui.tests;

import org.testng.annotations.BeforeMethod;
import ui.constants.MainPageLink;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.AddRemoveElementsPage;

public class AddRemoveElementsTest extends TestBase {

    private final AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(addRemoveElementsPage, MainPageLink.ADD_REMOVE_ELEMENTS);
    }

    @Test
    public void addRemoveElementsTest() {
        addRemoveElementsPage.clickAddButton();
        Assert.assertTrue(addRemoveElementsPage.isDeleteButtonDisplayed(), "A delete button isn't displayed!");

        addRemoveElementsPage.clickDeleteButton();
        Assert.assertFalse(addRemoveElementsPage.isDeleteButtonDisplayed(), "A delete button is displayed!");
    }

}
