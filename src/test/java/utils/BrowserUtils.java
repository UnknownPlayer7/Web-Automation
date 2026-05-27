package utils;

import aquality.selenium.elements.interfaces.IElement;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;
import utils.models.Rectangle;
import utils.models.ValidationResult;

import java.util.Map;

import static aquality.selenium.browser.AqualityServices.getBrowser;

@UtilityClass
public class BrowserUtils {

    public void refreshPage() {
        getBrowser().refresh();
    }

    public void imitateMouseMoveBeyondViewPort() {
        getBrowser().executeScript("""
                var event = new MouseEvent('mouseleave', {
                    bubbles: true,
                    cancelable: true,
                    clientY: -10
                });
                document.documentElement.dispatchEvent(event);
                """);
    }

    public void scrollDownBy(int y) {
        getBrowser().scrollWindowBy(0, y);
    }

    public void scrollDownToPageEnd() {
        getBrowser().executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public ValidationResult validateEntireElementIsOnScreen(IElement element) {
        Rectangle screen = getScreen();
        Rectangle shape = getRectangle(element);
        StringBuilder builder = new StringBuilder();

        if (shape.getTop() < screen.getTop()) {
            builder.append("Constraint #1: the shape top should be greater than screen top!\n");
        }
        if (shape.getLeft() < screen.getLeft()) {
            builder.append("Constraint #2: the shape left should be greater than screen left!\n");
        }
        if (shape.getBottom() > screen.getBottom()) {
            builder.append("Constraint #3: the shape bottom should be less than or equal to screen bottom!\n");
        }
        if (shape.getRight() > screen.getRight()) {
            builder.append("Constraint #4: the shape right should be less than or equal to screen right!\n");
        }
        if (!builder.isEmpty()) {
            builder.append("Shape coordinates: %s\nScreen size: %s".formatted(shape, screen));
        }
        return new ValidationResult(builder.isEmpty(), builder.toString());
    }

    private Rectangle getScreen() {
        double height = ((Number) getBrowser().executeScript("return window.innerHeight;")).doubleValue();
        double width = ((Number) getBrowser().executeScript("return window.innerWidth;")).doubleValue();

        return new Rectangle(0, 0, height, width);
    }

    private Rectangle getRectangle(IElement iElement) {
        WebElement element = iElement.getElement();
        Map<String, Number> map = (Map) getBrowser().executeScript(
                "return arguments[0].getBoundingClientRect();", element);
        double top = map.get("top").doubleValue();
        double left = map.get("left").doubleValue();
        double bottom = map.get("bottom").doubleValue();
        double right = map.get("right").doubleValue();

        return new Rectangle(top, left, bottom, right);
    }
}
