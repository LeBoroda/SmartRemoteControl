package com.tsystems.test.automation.school.data;

public enum ManageItemsMenuData implements IMenuData {
    ADD("ADD"),
    LIST("LIST"),
    BACK("BACK");

    private final String name;

    ManageItemsMenuData(String name) {
        this.name = name;
    }

}
