package com.tsystems.test.automation.school.data;

import com.tsystems.test.automation.school.data.IMenuData;

public enum ManageItemsMenuData implements IMenuData {
    ADD("ADD"),
    LIST("LIST"),
    BACK("BACK");

    private String name;

    ManageItemsMenuData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
