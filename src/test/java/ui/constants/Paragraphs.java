package ui.constants;

import lombok.Getter;

@Getter
public enum Paragraphs {

    FIRST_PARAGRAPH(0),
    SECOND_PARAGRAPH(1),
    THIRD_PARAGRAPH(2);

    private final int paragraphOrder;

    Paragraphs(int paragraphOrder) {
        this.paragraphOrder = paragraphOrder;
    }
}
