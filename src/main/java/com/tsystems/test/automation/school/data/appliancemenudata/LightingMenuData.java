package com.tsystems.test.automation.school.data.appliancemenudata;

public enum LightingMenuData {
    ON("ON"),
    OFF("OFF");
    private String name;

    LightingMenuData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
