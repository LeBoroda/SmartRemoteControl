package com.tsystems.test.automation.school.data;

public enum DeviceData implements IMenuData {
    HEATING("HEATING"),
    AUDIO("AUDIO"),
    VIDEO("VIDEO"),
    LIGHTING("LIGHTING");

    private String name;

    public String getName() {
        return name;
    }

    DeviceData(String name) {
        this.name = name;
    }
}
