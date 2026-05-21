package ui.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ABTestingPage extends Form {

    private final ILabel defaultHeader = getElementFactory().getLabel(
            By.xpath("//h3[text()='No A/B Test']"), "Default Header");

    public ABTestingPage() {
        super(By.xpath("//*[contains(text(),'split testing')]"), "A/B Testing Page");
    }

    public boolean hasDefaultContent() {
        return defaultHeader.state().waitForDisplayed();
    }

}
