package ui.constants;

import interfaces.IHrefSupplier;

public enum FramesPageLink implements IHrefSupplier {

    NESTED_FRAMES("/nested_frames", "Nested Frames"),
    IFrame("/iframe", "iFrame");

    private final String href;
    private final String linkName;

    FramesPageLink(String href, String linkName) {
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
