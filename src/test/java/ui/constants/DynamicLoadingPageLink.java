package ui.constants;

import interfaces.IHrefSupplier;

public enum DynamicLoadingPageLink implements IHrefSupplier {

    EXAMPLE_1("/dynamic_loading/1", "Example 1: Element on page that is hidden"),
    EXAMPLE_2("/dynamic_loading/2", "Example 2: Element rendered after the fact");

    private final String href;
    private final String linkName;

    DynamicLoadingPageLink(String href, String linkName) {
        this.href = href;
        this.linkName = linkName;
    }

    @Override
    public String getHref() {
        return href;
    }

    @Override
    public String getLinkName() {
        return linkName;
    }
}
