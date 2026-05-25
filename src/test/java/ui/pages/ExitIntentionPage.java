package ui.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ExitIntentionPage extends Form {

    private final ILabel modalWindow = getElementFactory().getLabel(By.id("ouibounce-modal"), "Modal Window");

    public ExitIntentionPage() {
        super(By.xpath("//*[text()='Exit Intent']"), "Exit Intention Page");
    }

    public boolean isModalWindowDisplayed() {
        return modalWindow.state().waitForDisplayed();
    }

    public boolean isModalWindowNotDisplayed() {
        return modalWindow.state().waitForNotDisplayed();
    }
}
