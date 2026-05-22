package ui.constants;

import lombok.Getter;

@Getter
public enum DraggedElements {

    COLUMN_A("column-a"),
    COLUMN_B("column-b");

    private final String elementId;

    DraggedElements(String elementId) {
        this.elementId = elementId;
    }
}
