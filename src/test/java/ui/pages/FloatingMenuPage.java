package ui.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.BrowserUtils;
import utils.models.ValidationResult;

import java.time.Duration;

public class FloatingMenuPage extends Form {

    private final ILabel floatingMenu = getElementFactory().getLabel(By.id("menu"), "Floating Menu");

    public FloatingMenuPage() {
        super(By.xpath("//*[text()='Floating Menu']"), "Floating Menu Page");
    }

    public boolean isFloatingMenuDisplayed() {
        return floatingMenu.state().waitForDisplayed(Duration.ofSeconds(1));
    }

    public ValidationResult validateEntireFloatingMenuIsOnScreen() {
        return BrowserUtils.validateEntireElementIsOnScreen(floatingMenu);
    }
}
