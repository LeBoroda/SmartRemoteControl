package com.tsystems.test.automation.school.data;

public enum MainMenuCommandsData implements IMenuData {
    CONTROL("CONTROL"),
    MANAGE("MANAGE"),
    EXIT("EXIT");

    private final String name;

    MainMenuCommandsData(String name) {
        this.name = name;
    }
}
