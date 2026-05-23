package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.constants.DraggedElements;
import ui.constants.MainPageLink;
import ui.pages.DragAndDropPage;
import utils.TestDataSupplier;

public class DragAndDropTest extends TestBase {

    private final static String TEXT_IN_COLUMN = TestDataSupplier.getDragAndDropData().getTextInColumnA();
    private final DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    public void dragAndDropTest() {
        mainPage.navigateTo(MainPageLink.DRAG_AND_DROP);
        Assert.assertTrue(dragAndDropPage.state().waitForDisplayed(), "The Drag and Drop Page isn't displayed!");

        dragAndDropPage.dragAndDrop(DraggedElements.COLUMN_B, DraggedElements.COLUMN_A);

        Assert.assertTrue(dragAndDropPage.hasColumnAText(TEXT_IN_COLUMN),
                "The Column A hasn't text: " + TEXT_IN_COLUMN);
    }
}
