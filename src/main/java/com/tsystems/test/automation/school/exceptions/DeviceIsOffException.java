package com.tsystems.test.automation.school.exceptions;

public class DeviceIsOffException extends Exception{
    public DeviceIsOffException(String deviceName){
        super(String.format("Device %s is turned off.\n", deviceName));
    }
}
