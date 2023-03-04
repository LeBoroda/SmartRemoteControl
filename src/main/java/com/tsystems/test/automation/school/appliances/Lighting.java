package com.tsystems.test.automation.school.appliances;

import com.tsystems.test.automation.school.appliances.AbsDevice;
import com.tsystems.test.automation.school.data.appliancemenudata.LightingMenuData;

import static com.tsystems.test.automation.school.Runner.getUserInput;

public class Lighting extends AbsDevice {
    public Lighting(String deviceID) {
        super(deviceID);
    }
    @Override
    public void showMenu() {
        System.out.println("Please choose the action from below:");
        for (LightingMenuData menuItem : LightingMenuData.values()) {
            System.out.printf(" / %s / ", menuItem);
        }
        System.out.println();
    }
    @Override
    public void doControl() {
        System.out.println("Please input your command.");
        String commandToDo = getUserInput();
        try {
            switch (LightingMenuData.valueOf(commandToDo)) {
                case ON:
                    this.turnOn();
                    break;
                case OFF:
                    this.turnOff();
                    break;
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
