package com.tsystems.test.automation.school.data;

public enum DeviceData implements IMenuData {
    HEATING("HEATING"),
    AUDIO("AUDIO"),
    VIDEO("VIDEO"),
    LIGHTING("LIGHTING");

    private final String name;

    DeviceData(String name) {
        this.name = name;
    }
}
