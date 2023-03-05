package com.tsystems.test.automation.school.appliances;

import java.time.LocalDateTime;

import static com.tsystems.test.automation.school.Runner.getUserInput;

public class AbsDevice {
    private final String deviceID;
    private boolean deviceState;

    public AbsDevice(String deviceID) {
        this.deviceID = deviceID;
        this.deviceState = false;
        System.out.printf("Device %s is added. \n", this.deviceID);
        System.out.printf("Device %s is %s\n", this.deviceID, this.getDeviceStatus());
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void showMenu() {
        System.out.println("This is my menu");
    }

    public void doControl() {
        System.out.println("This is robot rebellion! You give me money and kiss my shiny metal ass!");
    }

    public void turnOff() {
        if (deviceState) {
            this.deviceState = false;
            System.out.printf("Device %s is off at %s.\n", this.deviceID, LocalDateTime.now().toString());
        } else {
            System.out.printf("Device %s is already off.\n", this.deviceID);
        }
    }

    public void turnOn() {
        if (!deviceState) {
            this.deviceState = true;
            System.out.printf("Device %s is on at %s.\n", this.deviceID, LocalDateTime.now().toString());
        } else {
            System.out.printf("Device %s is already on.\n", this.deviceID);
        }
    }

    public String getDeviceStatus() {
        if (!deviceState) {
            return "off";
        } else {
            return "on";
        }
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ignoring) {
            return false;
        }
    }

    public static String checkNumberInput(String numberInput) {
        String userInput = numberInput;
        while (!isNumber(userInput)) {
            System.out.println("Please input whole number only.");
            userInput = getUserInput();
        }
        return userInput;
    }
}
