package ui.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class DynamicControlsPage extends Form {

    private final ICheckBox checkbox = getElementFactory().getCheckBox(
            By.id("checkbox"), "Checkbox");
    private final ITextBox input = getElementFactory().getTextBox(
            By.xpath("//*[@id='input-example']/input"), "Input");
    private final IButton removeCheckboxButton = getElementFactory().getButton(
            By.xpath("//*[@onclick='swapCheckbox()']"), "Remove Checkbox Button");
    private final IButton inputToggleButton = getElementFactory().getButton(
            By.xpath("//*[@onclick='swapInput()']"), "Input Toggle Button");

    public DynamicControlsPage() {
        super(By.id("checkbox-example"), "Dynamic Controls Page");
    }

    public void clickRemoveCheckboxButton() {
        removeCheckboxButton.click();
    }

    public void clickInputToggleButton() {
        inputToggleButton.click();
    }

    public void enterText(String text) {
        input.type(text);
    }

    public boolean isCheckboxDisplayed() {
        return checkbox.state().waitForDisplayed();
    }

    public boolean isCheckboxNotDisplayed() {
        return checkbox.state().waitForNotDisplayed();
    }

    public boolean isInputDisabled() {
        return input.state().waitForDisplayed();
    }

    public boolean isInputEnable() {
        return input.state().waitForEnabled();
    }

    public String getInputValue() {
        return input.getValue();
    }
}
