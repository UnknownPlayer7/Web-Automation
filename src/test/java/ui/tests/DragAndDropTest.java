package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.constants.DraggedElements;
import ui.constants.MainPageLink;
import ui.pages.DragAndDropPage;

public class DragAndDropTest extends TestBase {

    private final DragAndDropPage dragAndDropPage = new DragAndDropPage();
    private final static String TEXT_IN_COLUMN = "B";

    @Test
    public void dragAndDropTest() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page isn't displayed!");

        mainPage.navigateTo(MainPageLink.DRAG_AND_DROP);
        Assert.assertTrue(dragAndDropPage.state().waitForDisplayed(), "The Drag and Drop Page isn't displayed!");

        dragAndDropPage.dragAndDrop(DraggedElements.COLUMN_B, DraggedElements.COLUMN_A);

        Assert.assertTrue(dragAndDropPage.hasColumnAText(TEXT_IN_COLUMN),
                "The Column A hasn't text: " + TEXT_IN_COLUMN);
    }
}
