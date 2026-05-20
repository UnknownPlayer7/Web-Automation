package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddRemoveElementsPage extends Form {

    private final IButton addButton = getElementFactory().getButton(
            By.xpath("//*[@onclick='addElement()']"), "Add Button");
    private final IButton deleteButton = getElementFactory().getButton(
            By.xpath("//*[@onclick='deleteElement()']"), "Delete Button");

    public AddRemoveElementsPage() {
        super(By.xpath("//*[@onclick='addElement()']"), "Add/Remove Elements Page");
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public boolean isDeleteButtonDisplayed() {
        return deleteButton.state().isDisplayed();
    }
}
