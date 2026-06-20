package ui.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import ui.constants.Arrows;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class HorizontalSliderPage extends Form {

    private final ILabel rangeLabel = getElementFactory().getLabel(By.id("range"), "Range Label");
    private final ITextBox sliderBar = getElementFactory().getTextBox(By.xpath("//div[@class='sliderContainer']/input"), "Slider Bar");

    public HorizontalSliderPage() {
        super(By.xpath("//*[text()='Horizontal Slider']"), "Horizontal Slider Page");
    }

    public String getSliderRange() {
        return rangeLabel.getText();
    }

    public void setSliderBarValue(String value) {
        getBrowser().executeScript("""
                arguments[0].value = arguments[1];
                arguments[0].dispatchEvent(new Event('change', {bubbles : true}));
                """, sliderBar.getElement(), value);
    }

    public void shiftSliderByArrow(Arrows arrow) {
        sliderBar.sendKeys(arrow.getKey());
    }


}
