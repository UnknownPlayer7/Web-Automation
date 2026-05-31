package ui.constants;

import interfaces.IHrefSupplier;

public enum MainPageLink implements IHrefSupplier {

    AD_TESTING("/abtest", "A/B Testing"),
    ADD_REMOVE_ELEMENTS("/add_remove_elements/", "Add/Remove Elements"),
    BROKEN_IMAGES("/broken_images", "Broken Images"),
    CHECKBOXES("/checkboxes", "Checkboxes"),
    CONTEXT_MENU("/context_menu", "Context Menu"),
    DISAPPEARING_ELEMENTS("/disappearing_elements", "Disappearing Elements"),
    DRAG_AND_DROP("/drag_and_drop", "Drag and Drop"),
    DROPDOWN("/dropdown", "Dropdown"),
    DYNAMIC_CONTENT("/dynamic_content", "Dynamic Content"),
    DYNAMIC_CONTROLS("/dynamic_controls", "Dynamic Controls"),
    DYNAMIC_LOADING("/dynamic_loading", "Dynamic Loading"),
    ENTRY_AD("/entry_ad", "Entry Ad"),
    EXIT_INTENTION("/exit_intent", "Exit Intention"),
    FILE_UPLOAD("/upload", "File Upload"),
    FILE_DOWNLOAD("/download", "File Download"),
    FLOATING_MENU("/floating_menu", "Floating Menu"),
    FORGOT_PASSWORD("/forgot_password", "Forgot Password"),
    FORM_AUTHENTICATION("/login", "Form Authentication");

    private final String href;
    private final String linkName;

    MainPageLink(String href, String linkName) {
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
