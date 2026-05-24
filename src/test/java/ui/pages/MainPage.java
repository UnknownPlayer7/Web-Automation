package ui.pages;

import aquality.selenium.forms.Form;
import interfaces.IHasNavigation;
import ui.constants.MainPageLink;
import org.openqa.selenium.By;
import utils.NavigationUtils;

public class MainPage extends Form implements IHasNavigation<MainPageLink> {

    public MainPage() {
        super(By.xpath("//*[text()='Welcome to the-internet']"), "Main Page");
    }

    @Override
    public void navigateTo(MainPageLink link) {
        NavigationUtils.navigateTo(link);
    }
}
