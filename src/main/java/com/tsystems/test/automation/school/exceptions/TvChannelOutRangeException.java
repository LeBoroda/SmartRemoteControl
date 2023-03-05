package com.tsystems.test.automation.school.exceptions;

public class TvChannelOutRangeException extends Exception{
    public TvChannelOutRangeException(String deviceName, int minChannel, int maxChannel){
        super(String.format("Device %s min channel number is %d and max channel number is %d.", deviceName, minChannel, maxChannel));
    }
}
