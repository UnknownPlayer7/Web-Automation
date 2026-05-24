package ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.constants.DraggedElements;
import ui.constants.MainPageLink;
import ui.pages.DragAndDropPage;
import utils.TestDataSupplier;

public class DragAndDropTest extends TestBase {

    private final static String TEXT_IN_COLUMN = TestDataSupplier.getDragAndDropData().getTextInColumnA();
    private final DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @BeforeMethod(dependsOnMethods = "setup")
    @Override
    protected void navigationTest() {
        navigateAndCheck(dragAndDropPage, MainPageLink.DRAG_AND_DROP);
    }

    @Test
    public void dragAndDropTest() {
        dragAndDropPage.dragAndDrop(DraggedElements.COLUMN_B, DraggedElements.COLUMN_A);

        Assert.assertTrue(dragAndDropPage.hasColumnAText(TEXT_IN_COLUMN),
                "The Column A hasn't text: " + TEXT_IN_COLUMN);
    }
}
