package ui.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import ui.constants.NestedFrames;
import utils.BrowserUtils;

public class NestedFramesPage extends Form {

    private final ILabel frameContent = getElementFactory().getLabel(By.tagName("body"), "Frame Content");

    public NestedFramesPage() {
        super(By.tagName("frameset"), "Nested Frames Page");
    }

    public void switchTo(NestedFrames frame) {
        BrowserUtils.switchTo(frame);
    }

    public String getFrameContentText() {
        return frameContent.getText().trim();
    }
}
