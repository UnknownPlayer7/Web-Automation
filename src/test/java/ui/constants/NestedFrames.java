package ui.constants;

import interfaces.IHasFrames;

public enum NestedFrames implements IHasFrames {

    FRAME_TOP("frame-top"),
    FRAME_BOTTOM("frame-bottom"),
    FRAME_LEFT("frame-left"),
    FRAME_MIDDLE("frame-middle"),
    FRAME_RIGHT("frame-right");

    private final String frameName;

    NestedFrames(String frameName) {
        this.frameName = frameName;
    }

    @Override
    public String getFrameName() {
        return frameName;
    }
}
