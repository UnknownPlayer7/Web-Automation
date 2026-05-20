package pages;

import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CheckboxesPage extends Form {

    private final ICheckBox firstCheckBox = getElementFactory().getCheckBox(
            By.xpath("//input[@type='checkbox'][1]"), "First CheckBox");
    private final ICheckBox secondCheckBox = getElementFactory().getCheckBox(
            By.xpath("//input[@type='checkbox'][2]"), "Second CheckBox");

    public CheckboxesPage() {
        super(By.id("checkboxes"), "Checkboxes Page");
    }

    public boolean isFirstCheckBoxChecked() {
        return firstCheckBox.isChecked();
    }

    public boolean isSecondCheckBoxChecked() {
        return secondCheckBox.isChecked();
    }

    public void checkFirstCheckBox() {
        firstCheckBox.check();
    }

    public void uncheckSecondCheckBox() {
        secondCheckBox.uncheck();
    }
}
