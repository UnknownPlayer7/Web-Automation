package ui.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class EntryAdPage extends Form {

    private final ILink enableEntryAdLink = getElementFactory().getLink(
            By.id("restart-ad"), "Enable Entry Ad Link");
    private final ILabel entryAd = getElementFactory().getLabel(
            By.xpath("//*[@id='modal']/*[@class='modal']"), "Entry Ad");
    private final IButton closeEntryAdButton = entryAd.findChildElement(
            By.xpath(".//*[@class='modal-footer']/*[text()='Close']"),
            "Close Entry Ad Button", ElementType.BUTTON);

    public EntryAdPage() {
        super(By.xpath("//*[text()='Entry Ad']"), "Entry Ad Page");
    }

    public void enableEntryAd() {
        enableEntryAdLink.click();
    }

    public void clickCloseEntryAdButton() {
        closeEntryAdButton.click();
    }

    public void clickBeyondEntryAd() {
        WebElement figure = entryAd.getElement();
        int xOffset = figure.getSize().width;
        int yOffset = figure.getSize().height;

        new Actions(getBrowser().getDriver())
                .moveToElement(figure, xOffset, yOffset)
                .click()
                .perform();
    }

    public boolean isEntryAdDisplayed() {
        return entryAd.state().waitForDisplayed(Duration.ofSeconds(1));
    }
}
