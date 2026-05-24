package ui.pages;

import aquality.selenium.forms.Form;
import interfaces.IHasNavigation;
import org.openqa.selenium.By;
import ui.constants.DynamicLoadingPageLink;
import utils.NavigationUtils;

public class DynamicLoadingPage extends Form implements IHasNavigation<DynamicLoadingPageLink> {

    public DynamicLoadingPage() {
        super(By.xpath("//*[text()='Dynamically Loaded Page Elements']"), "Dynamic Loading Page");
    }

    @Override
    public void navigateTo(DynamicLoadingPageLink link) {
        NavigationUtils.navigateTo(link);
    }
}
