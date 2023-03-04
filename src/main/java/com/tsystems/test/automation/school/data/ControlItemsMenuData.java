package com.tsystems.test.automation.school.data;

public enum ControlItemsMenuData implements IMenuData {
    DEVICE("DEVICE"),
    BACK("BACK");
    private String name;

    public String getName() {
        return name;
    }
    ControlItemsMenuData(String name) {
        this.name = name;
    }
}
