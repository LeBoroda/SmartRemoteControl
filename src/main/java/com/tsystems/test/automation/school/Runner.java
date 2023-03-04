package com.tsystems.test.automation.school;

import com.tsystems.test.automation.school.appliances.*;
import com.tsystems.test.automation.school.data.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Runner {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<AbsDevice> deviceList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Welcome to Smart Remote Control Center!");
        boolean timeToQuit = false;
        while(!timeToQuit){
            runMenu(MainMenuCommandsData.values());
            String userInput = getUserInput();
            try {
                switch (MainMenuCommandsData.valueOf(userInput)) {
                    case CONTROL:
                        runControlMenu(ControlItemsMenuData.values());
                        break;
                    case MANAGE:
                        runManageMenu(ManageItemsMenuData.values());
                        break;
                    case EXIT:
                        System.exit(0);
                }
            }catch (IllegalArgumentException e) {
                System.out.println("There is no such menu item. Please try again");
            }
        }
    }
    private static void runMenu(IMenuData[] menuItems){
        System.out.println("Please chose menu item from below:");
        for(IMenuData menuItem : menuItems){
            System.out.printf(" / %s / ", menuItem);
        }
        System.out.println();
    }
    private static void runManageMenu(IMenuData[] menuItems){
        boolean timeToQuit = false;
        while(!timeToQuit){
            runMenu(menuItems);
            String userInput = getUserInput();
            try {
                switch (ManageItemsMenuData.valueOf(userInput)){
                    case LIST:
                        showDevicesList();
                        break;
                    case ADD:
                        runMenu(DeviceData.values());
                        String userDeviceTypeInput = getUserInput();
                        try{
                            switch (DeviceData.valueOf(userDeviceTypeInput)){
                                case HEATING:
                                    System.out.println("Please input device ID");
                                    String deviceID = getUserInput();
                                    deviceList.add(new Heating(deviceID));
                                    break;
                                case AUDIO:
                                    System.out.println("Please input device ID");
                                    deviceID = getUserInput();
                                    deviceList.add(new Audio(deviceID));
                                    break;
                                case VIDEO:
                                    System.out.println("Please input device ID");
                                    deviceID = getUserInput();
                                    deviceList.add(new Video(deviceID));
                                    break;
                                case LIGHTING:
                                    System.out.println("Please input device ID");
                                    deviceID = getUserInput();
                                    deviceList.add(new Lighting(deviceID));
                                    break;
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("There is no such device type. Please try again");
                        }
                        break;
                    case BACK:
                        timeToQuit = true;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("There is no such menu Item. Please try again");
            }
        }
    }
    private static void runControlMenu(IMenuData[] menuItems) {
        boolean timeToQuit = false;
        while (!timeToQuit) {
            runMenu(menuItems);
            String userInput = getUserInput();
            try {
                switch (ControlItemsMenuData.valueOf(userInput)) {
                    case DEVICE:
                        if(deviceList.size() !=0) {
                            showDevicesList();
                            System.out.println("Please chose a device");
                            String userDeviceInput = getUserInput();
                            AbsDevice chosenDevice = getChosenDevice(userDeviceInput);
                            chosenDevice.showMenu();
                            chosenDevice.doControl();
                        } else {
                            System.out.println("There are no devices added. Please add device.");
                        }
                        break;
                    case BACK:
                        timeToQuit = true;
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("There is no such menu item. Please try again");
            }
        }
    }
    public static String getUserInput(){
        String userInput="";
        try{
            userInput = reader.readLine().toUpperCase().trim();
        } catch (IOException e){
            e.printStackTrace();
        }
        return userInput;
    }
    private static void showDevicesList(){
        if(deviceList.size()==0){
            System.out.println("No items registered. Please add your device.");
        } else {
            System.out.println("You have the following devices added:");
            for(AbsDevice device : deviceList){
                System.out.printf(" / %s / ", device.getDeviceID());
            }
            System.out.println();
        }
    }
    private static AbsDevice getChosenDevice(String userInput){
        String result=userInput;
        AbsDevice resultDevice = null;
        boolean deviceExists = false;
        while (!deviceExists){
            for(AbsDevice device: deviceList){
                if(result.equals(device.getDeviceID())){
                    deviceExists = true;
                    resultDevice = device;
                }
            }
            if(!deviceExists){
                System.out.printf("There is no device %s, please check your input.\n", result);
                try {
                    result = reader.readLine().toUpperCase().trim();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return resultDevice;
    }
}