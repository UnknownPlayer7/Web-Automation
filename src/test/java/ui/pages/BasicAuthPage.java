package ui.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.SettingsTestData;

public class BasicAuthPage extends Form {

    private static final String CONTENT = SettingsTestData.getAuthData().getContent();

    public BasicAuthPage() {
        super(By.xpath("//*[contains(text(),'%s')]".formatted(CONTENT)), "Basic Authentication Page");
    }
}
