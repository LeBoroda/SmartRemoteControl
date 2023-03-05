package com.tsystems.test.automation.school.data.appliancemenudata;

public enum HeatingMenuData {
    ON("ON"),
    OFF("OFF"),
    TEMPSET("TEMPSET"),
    TEMPCHECK("TEMPCHECK");

    private final String name;

    HeatingMenuData(String name) {
        this.name = name;
    }

}
