package utils;

import aquality.selenium.elements.interfaces.ILink;
import interfaces.IHrefSupplier;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

@UtilityClass
public class NavigationUtils {

    public void navigateTo(IHrefSupplier link) {
        getNavigationLink(link).click();
    }

    private ILink getNavigationLink(IHrefSupplier link) {
        return getElementFactory().getLink(getElementLocator(link), link.getLinkName());
    }

    private By getElementLocator(IHrefSupplier link) {
        return By.xpath("//*[@href='%s']".formatted(link.getHref()));
    }
}
