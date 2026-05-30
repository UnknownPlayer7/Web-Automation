package ui.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SecureAreaPage extends Form {

    public SecureAreaPage() {
        super(By.xpath("//*[text()=' Secure Area']"), "Secure Area Page");
    }
}
