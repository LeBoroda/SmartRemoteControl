package com.tsystems.test.automation.school.data.appliancemenudata;

public enum AudioMenuData {
    ON("ON"),
    OFF("OFF"),
    VOLUMEUP("VOLUMEUP"),
    VOLUMEDOWN("VOLUMEDOWN"),
    VOLUMESET("VOLUMESET");
    private final String name;

    AudioMenuData(String name) {
        this.name = name;
    }

}
