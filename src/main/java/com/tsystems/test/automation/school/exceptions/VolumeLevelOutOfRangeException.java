package com.tsystems.test.automation.school.exceptions;

public class VolumeLevelOutOfRangeException extends Exception{
    public VolumeLevelOutOfRangeException(String deviceName, int minVol, int maxVol){
        super(String.format("Device %s min volume level is %d and max volume level is %d.", deviceName, minVol, maxVol));
    }
}
