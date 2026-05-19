package constants;

import lombok.Getter;

@Getter
public enum MainPageLink {

    AD_TESTING("/abtest");

    private final String href;

    MainPageLink(String href) {
        this.href = href;
    }
}
