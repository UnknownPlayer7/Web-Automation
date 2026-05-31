package ui.pages;

import aquality.selenium.forms.Form;
import interfaces.IHasNavigation;
import org.openqa.selenium.By;
import ui.constants.FramesPageLink;
import utils.NavigationUtils;

public class FramesPage extends Form implements IHasNavigation<FramesPageLink> {

    public FramesPage() {
        super(By.xpath("//*[text()='Frames']"), "Frames Page");
    }

    @Override
    public void navigateTo(FramesPageLink link) {
        NavigationUtils.navigateTo(link);
    }
}
