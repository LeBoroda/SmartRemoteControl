package com.tsystems.test.automation.school.data;

import com.tsystems.test.automation.school.data.IMenuData;

public enum MainMenuCommandsData implements IMenuData {
    CONTROL("CONTROL"),
    MANAGE("MANAGE"),
    EXIT("EXIT");

    private String name;

    MainMenuCommandsData(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
