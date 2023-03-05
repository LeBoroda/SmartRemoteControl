package com.tsystems.test.automation.school.appliances;

import com.tsystems.test.automation.school.data.appliancemenudata.HeatingMenuData;
import com.tsystems.test.automation.school.exceptions.DeviceIsOffException;
import com.tsystems.test.automation.school.exceptions.TemperatureOutOfRangeException;

import java.time.LocalDateTime;

import static com.tsystems.test.automation.school.Runner.getUserInput;

public class Heating extends AbsDevice {
    private int temp;
    private final int minTemp = 16;
    private final int maxTemp = 75;

    public Heating(String deviceID) {
        super(deviceID);
    }

    private void setTemp(int temp) {
        this.temp = temp;
    }

    private int getTemp() {
        return temp;
    }

    @Override
    public void showMenu() {
        System.out.println("Please choose the action from below:");
        for (HeatingMenuData menuItem : HeatingMenuData.values()) {
            System.out.printf(" / %s / ", menuItem);
        }
        System.out.println();
    }

    @Override
    public void doControl() {
        System.out.println("Please input your command.");
        String commandToDo = getUserInput();
        try {
            switch (HeatingMenuData.valueOf(commandToDo)) {
                case ON:
                    this.turnOn();
                    break;
                case OFF:
                    this.turnOff();
                    break;
                case TEMPCHECK:
                    checkTemp();
                    break;
                case TEMPSET:
                    System.out.printf("Please input desired temperature for %s.\n", this.getDeviceID());
                    String userInput = getUserInput();
                    setTemperature(userInput);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void turnOn() {
        super.turnOn();
        this.temp = 17;
        System.out.printf("Device %s default temperature is %d.\n", this.getDeviceID(), this.getTemp());
    }

    private void setTemperature(String temp) {
        try {
            if (this.getDeviceStatus().equals("off")) {
                throw new DeviceIsOffException(this.getDeviceID());
            } else {
                int tempToSet = Integer.parseInt(checkNumberInput(temp));
                if (tempToSet < minTemp || tempToSet > maxTemp) {
                    throw new TemperatureOutOfRangeException(this.getDeviceID(), minTemp, maxTemp);
                } else {
                    setTemp(tempToSet);
                    System.out.printf("Device %s temperature is set to %d at %s.\n", this.getDeviceID(), tempToSet, LocalDateTime.now().toString());
                }
            }
        } catch (DeviceIsOffException | TemperatureOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkTemp() {
        try {
            if (this.getDeviceStatus().equals("off")) {
                throw new DeviceIsOffException(this.getDeviceID());
            } else {
                System.out.printf("Device %s temperature is set to %d.\n", this.getDeviceID(), this.getTemp());
            }
        } catch (DeviceIsOffException e) {
            System.out.println(e.getMessage());
        }
    }
}




