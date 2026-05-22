package ui.constants;

import lombok.Getter;

@Getter
public enum DropdownOptions {
    OPTION_1("1", "Option 1"),
    OPTION_2("2", "Option 2");

    private final String value;
    private final String text;

    DropdownOptions(String value, String text) {
        this.value = value;
        this.text = text;
    }
}
