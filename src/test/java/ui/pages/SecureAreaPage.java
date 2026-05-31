package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SecureAreaPage extends Form {

    private final ILabel successMessage = getElementFactory().getLabel(By.id("flash"), "Success Message");
    private final IButton logoutButton = getElementFactory().getButton(
            By.xpath("//*[@href='/logout']"), "Logout Button");

    public SecureAreaPage() {
        super(By.xpath("//*[text()=' Secure Area']"), "Secure Area Page");
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.state().waitForDisplayed();
    }

    public String getSuccessMessageText() {
        return successMessage.getText().replace("×","").trim();
    }

    public void logout() {
        logoutButton.click();
    }
}
