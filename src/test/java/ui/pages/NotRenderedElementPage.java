package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class NotRenderedElementPage extends Form {

    private final IButton startButton = getElementFactory().getButton(
            By.xpath("//*[@id='start']/button"), "Start Button");
    private final ILabel notRenderedElement = getElementFactory().getLabel(
            By.id("finish"), "Not Rendered Element");

    public NotRenderedElementPage() {
        super(By.id("start"), "Not Rendered Element Page");
    }

    public void clickStartButton() {
        startButton.click();
    }

    public boolean isNotRenderedElementDisplayed() {
        return notRenderedElement.state().waitForDisplayed();
    }

    public boolean isNotRenderedElementNotDisplayed() {
        return notRenderedElement.state().waitForNotDisplayed();
    }
}
