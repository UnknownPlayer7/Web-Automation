package constants;

import lombok.Getter;

@Getter
public enum MainPageLink {

    AD_TESTING("/abtest"),
    ADD_REMOVE_ELEMENTS("/add_remove_elements/"),
    BASIC_AUTH("/basic_auth"),
    BROKEN_IMAGES("/broken_images");

    private final String href;

    MainPageLink(String href) {
        this.href = href;
    }
}
