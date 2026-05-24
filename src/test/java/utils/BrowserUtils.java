package utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;

import static aquality.selenium.browser.AqualityServices.getBrowser;

@UtilityClass
public class BrowserUtils {

    public void refreshPage() {
        getBrowser().refresh();
    }
}
