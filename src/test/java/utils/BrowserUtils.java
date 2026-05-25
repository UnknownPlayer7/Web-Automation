package utils;

import lombok.experimental.UtilityClass;

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
}
