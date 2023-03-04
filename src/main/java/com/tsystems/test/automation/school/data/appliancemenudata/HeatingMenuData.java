package com.tsystems.test.automation.school.data.appliancemenudata;

public enum HeatingMenuData {
    ON("ON"),
    OFF("OFF"),
    TEMPSET("TEMPSET"),
    TEMPCHECK("TEMPCHECK");

    private String name;

    HeatingMenuData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
