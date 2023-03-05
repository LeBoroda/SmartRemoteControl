package com.tsystems.test.automation.school.data;

public enum ControlItemsMenuData implements IMenuData {
    DEVICE("DEVICE"),
    BACK("BACK");
    private final String name;

    ControlItemsMenuData(String name) {
        this.name = name;
    }
}
