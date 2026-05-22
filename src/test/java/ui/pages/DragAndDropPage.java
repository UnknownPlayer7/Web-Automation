package ui.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.constants.DraggedElements;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class DragAndDropPage extends Form {

    private final ILabel columnA = getElementFactory().getLabel(By.id("column-a"), "Column A");

    public DragAndDropPage() {
        super(By.id("column-b"), "Drag and Drop Page");
    }

    public boolean hasColumnAText(String text) {
        return columnA.getText().equals(text);
    }

    public void dragAndDrop(DraggedElements source, DraggedElements target) {
        WebElement sourceElement = getDraggedElementById(source.getElementId());
        WebElement targetElement = getDraggedElementById(target.getElementId());

        new Actions(getBrowser().getDriver())
                .dragAndDrop(sourceElement, targetElement)
                .perform();
    }

    private WebElement getDraggedElementById(String elementId) {
        return getElementFactory().getLink(By.id(elementId), elementId).getElement();
    }
}
