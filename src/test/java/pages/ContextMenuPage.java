package pages;

import aquality.selenium.browser.AlertActions;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContextMenuPage extends Form {

    private final IButton hotSpot = getElementFactory().getButton(By.id("hot-spot"), "Hot-spot");

    public ContextMenuPage() {
        super(By.id("hot-spot"), "Context Menu Page");
    }

    public void rightClickOnHotSpot() {
        hotSpot.getMouseActions().rightClick();
    }

    public boolean isAlertDisplayed() {
        return AqualityServices.getConditionalWait().waitFor(ExpectedConditions.alertIsPresent()) != null;
    }
}
