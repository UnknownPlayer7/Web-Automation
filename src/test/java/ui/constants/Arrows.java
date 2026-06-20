package ui.constants;

import lombok.Getter;
import org.openqa.selenium.Keys;

@Getter
public enum Arrows {

    LEFT(Keys.ARROW_LEFT),
    RIGHT(Keys.ARROW_RIGHT);

    private final Keys key;

    Arrows(Keys key) {
        this.key = key;
    }
}
