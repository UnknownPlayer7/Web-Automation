package ui.constants;

import lombok.Getter;

@Getter
public enum MainPageLink {

    AD_TESTING("/abtest"),
    ADD_REMOVE_ELEMENTS("/add_remove_elements/"),
    BROKEN_IMAGES("/broken_images"),
    CHECKBOXES("/checkboxes"),
    CONTEXT_MENU("/context_menu"),
    DISAPPEARING_ELEMENTS("/disappearing_elements");

    private final String href;

    MainPageLink(String href) {
        this.href = href;
    }
}
