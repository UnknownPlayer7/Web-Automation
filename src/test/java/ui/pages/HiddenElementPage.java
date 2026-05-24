package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HiddenElementPage extends Form {

    private final IButton startButton = getElementFactory().getButton(
            By.xpath("//*[@id='start']/button"), "Start Button");
    private final ILabel hiddenElement = getElementFactory().getLabel(
            By.id("finish"), "Hidden Element");

    public HiddenElementPage() {
        super(By.id("start"), "Hidden Element Page");
    }

    public void clickStartButton() {
        startButton.click();
    }

    public boolean isHiddenElementDisplayed() {
        return hiddenElement.state().waitForDisplayed();
    }

    public boolean isHiddenElementNotDisplayed() {
        return hiddenElement.state().waitForNotDisplayed();
    }
}
