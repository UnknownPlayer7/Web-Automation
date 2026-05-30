package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class LoginPage extends Form {

    private final ITextBox usernameInput = getElementFactory().getTextBox(By.id("username"), "Username Input");
    private final ITextBox passwordInput = getElementFactory().getTextBox(By.id("password"), "Password Input");
    private final IButton loginButton = getElementFactory().getButton(
            By.xpath("//button[@type='submit']"), "Login Button");

    public LoginPage() {
        super(By.xpath("//*[text()='Login Page']"), "Login Page");
    }

    public void enterUsername(String username) {
        usernameInput.typeSecret(username);
    }

    public void enterPassword(String password) {
        passwordInput.typeSecret(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
