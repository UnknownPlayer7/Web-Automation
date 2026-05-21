package ui.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import ui.constants.MainPageLink;
import org.openqa.selenium.By;

public class MainPage extends Form {

    public MainPage() {
        super(By.xpath("//*[text()='Welcome to the-internet']"), "Main Page");
    }

    public void navigateTo(MainPageLink link) {
        getNavigationLink(link).click();
    }

    private ILink getNavigationLink(MainPageLink link) {
        return getElementFactory().getLink(getElementLocator(link), link.name());
    }

    private By getElementLocator(MainPageLink link) {
        return By.xpath("//*[@href='%s']".formatted(link.getHref()));
    }
}
