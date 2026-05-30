package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends Form {

    private final ITextBox emailInput = getElementFactory().getTextBox(By.id("email"), "Email input");
    private final IButton retrievePasswordButton = getElementFactory().getButton(By.id("form_submit"), "Retrieve Password Button");

    public ForgotPasswordPage() {
        super(By.xpath("//*[text()='Forgot Password']"), "Forgot Password Page");
    }

    public void enterEmail(String email) {
        emailInput.typeSecret(email);
    }

    public void clickRetrievePasswordButton() {
        retrievePasswordButton.click();
    }
}
