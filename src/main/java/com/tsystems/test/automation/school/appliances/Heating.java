package com.tsystems.test.automation.school.appliances;

import com.tsystems.test.automation.school.appliances.AbsDevice;
import com.tsystems.test.automation.school.data.appliancemenudata.HeatingMenuData;

import java.time.LocalDateTime;

import static com.tsystems.test.automation.school.Runner.getUserInput;

public class Heating extends AbsDevice {
    private int temp;
    public Heating(String deviceID) {
        super(deviceID);
    }
    private void setTemp(int temp){
        this.temp = temp;
    }
    private int getTemp(){
        return temp;
    }
    @Override
    public void showMenu(){
        System.out.println("Please choose the action from below:");
        for(HeatingMenuData menuItem: HeatingMenuData.values()){
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
            e.printStackTrace();
        }
    }
    @Override
    public void turnOn(){
        super.turnOn();
        this.temp = 17;
        System.out.printf("Device %s default temperature is %d.\n", this.getDeviceID(), this.getTemp());
    }

    private void setTemperature(String temp){
        if (this.getDeviceStatus().equals("off")) {
            System.out.printf("Device %s is off.\n", this.getDeviceID());
        } else {
            int tempToSet = Integer.parseInt(checkNumberInput(temp));
            while (true) {
                if (tempToSet < 16) {
                    System.out.println("This is heating, not cooler. Please enter again.");
                    tempToSet = Integer.parseInt(checkNumberInput(getUserInput()));
                } else if (tempToSet > 35 && tempToSet <= 50) {
                    System.out.println("Your power company bill will kill you. Please enter again.");
                    tempToSet = Integer.parseInt(checkNumberInput(getUserInput()));
                } else if (tempToSet > 50) {
                    System.out.println("You will be cooked in 3 hours like a turkey. Please enter again.");
                    tempToSet = Integer.parseInt(checkNumberInput(getUserInput()));
                } else {
                    setTemp(tempToSet);
                    System.out.printf("Device %s temperature is set to %d at %s.\n", this.getDeviceID(), tempToSet, LocalDateTime.now().toString());
                    break;
                }
            }
        }
    }
    private void checkTemp() {
        if (this.getDeviceStatus().equals("off")) {
            System.out.printf("Device %s is off.\n", this.getDeviceID());
        } else {
            System.out.printf("Device %s temperature is set to %d.\n", this.getDeviceID(), this.getTemp());
        }
    }
}




