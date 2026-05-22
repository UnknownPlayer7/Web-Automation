package ui.pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GalleryPage extends Form {

    public GalleryPage() {
        super(By.xpath("//*[text()='Not Found']"), "Gallery Page");
    }
}
