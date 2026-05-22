package ui.pages;

import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import ui.constants.DropdownOptions;

public class DropdownPage extends Form {

    private final IComboBox dropdown = getElementFactory().getComboBox(By.id("dropdown"), "Dropdown");

    public DropdownPage() {
        super(By.id("dropdown"), "Dropdown Page");
    }

    public void chooseOption(DropdownOptions option) {
        dropdown.selectByValue(option.getValue());
    }

    public String getSelectedText() {
        return dropdown.getSelectedText();
    }
}
