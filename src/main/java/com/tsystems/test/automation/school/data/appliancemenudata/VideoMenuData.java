package com.tsystems.test.automation.school.data.appliancemenudata;

public enum VideoMenuData {
    ON("ON"),
    OFF("OFF"),
    CHOOSECHANNEL("CHOOSECHANNEL"),
    CHANNELUP("CHANNELLUP"),
    CHANNELDOWN("CHANNELDOWN"),
    VOLUMEUP("VOLUMEUP"),
    VOLUMEDOWN("VOLUMEDOWN"),
    VOLUMESET("VOLUMESET"),
    MUTE("MUTE");
    private String name;

    VideoMenuData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
