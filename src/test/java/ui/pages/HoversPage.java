package ui.pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class HoversPage extends Form {

    private final List<ILabel> userFigure = getElementFactory().findElements(
            By.xpath("//div[@class='figure']"), "User Figure", ElementType.LABEL);

    public HoversPage() {
        super(By.xpath("//*[text()='Hovers']"), "Hovers Page");
    }

    public void hoverOverUserFigure(int imageNumber) {
        userFigure.get(imageNumber).getMouseActions().moveMouseToElement();
    }

    public void moveMouseFromUserFigure(int imageNumber) {
        userFigure.get(imageNumber).getMouseActions().moveMouseFromElement();
    }

    public boolean isUserDataDisplayed(int imageNumber) {
        return getUserDataLabel(imageNumber).state().waitForDisplayed();
    }

    private ILabel getUserDataLabel(int imageNumber) {
        return userFigure.get(imageNumber)
                .findChildElement(By.className("figcaption"), "User Data Label", ElementType.LABEL);
    }

    public boolean isUserDataHidden(int imageNumber) {
        return getUserDataLabel(imageNumber).state().waitForNotDisplayed();
    }

    public String getUserLabelText(int imageNumber) {
        return getUserDataLabel(imageNumber).findChildElement(By.tagName("h5"), "User Label", ElementType.LABEL)
                .getText();
    }

    public void clickUserLink(int imageNumber) {
        getUserLink(imageNumber).click();
    }

    private ILink getUserLink(int imageNumber) {
        return userFigure.get(imageNumber).findChildElement(By.tagName("a"), "User Link", ElementType.LINK);
    }

    public String getUserLinkText(int imageNumber) {
        return getUserLink(imageNumber).getText();
    }
}
