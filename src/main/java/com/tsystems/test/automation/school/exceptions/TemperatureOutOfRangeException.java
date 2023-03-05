package com.tsystems.test.automation.school.exceptions;

public class TemperatureOutOfRangeException extends Exception{
    public TemperatureOutOfRangeException(String deviceName, int minTemp, int maxTemp){
        super(String.format("This device %s min temperature is %d and max temperature is %d.", deviceName, minTemp, maxTemp));
    }
}
