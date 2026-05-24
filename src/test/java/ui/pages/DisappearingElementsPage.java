package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.time.Duration;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class DisappearingElementsPage extends Form {

    private final IButton galleryButton = getElementFactory().getButton(
            By.xpath("//*[@href='/gallery/']"), "Gallery button");

    public DisappearingElementsPage() {
        super(By.xpath("//*[@id='content']//ul"), "Disappearing Elements Page");
    }

    public boolean isGalleryButtonDisplayed() {
        return galleryButton.state().waitForDisplayed(Duration.ofSeconds(1));
    }

    public void clickGalleryButton() {
        galleryButton.clickAndWait();
    }
}
