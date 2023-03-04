package com.tsystems.test.automation.school.appliances;

import com.tsystems.test.automation.school.appliances.SoundSystem;
import com.tsystems.test.automation.school.data.appliancemenudata.AudioMenuData;

import static com.tsystems.test.automation.school.Runner.getUserInput;

public class Audio extends SoundSystem {
    public Audio(String deviceID) {
        super(deviceID);
    }
    @Override
    public void showMenu(){
        System.out.println("Please choose the action from below:");
        for(AudioMenuData menuItem: AudioMenuData.values()){
            System.out.printf(" / %s / ", menuItem);
        }
        System.out.println();
    }

    @Override
    public void doControl(){
        System.out.println("Please input your command.");
        String commandToDo = getUserInput();
        try{
            int desiredVol;
            switch (AudioMenuData.valueOf(commandToDo)){
                case ON:
                    this.turnOn();
                    break;
                case OFF:
                    this.turnOff();
                    break;
                case MUTE:
                    setVolume("0");
                    break;
                case VOLUMEUP:
                    desiredVol = getVolumeLevel()+1;
                    setVolume(Integer.toString(desiredVol));
                    break;
                case VOLUMEDOWN:
                    desiredVol = getVolumeLevel()-1;
                    setVolume(Integer.toString(desiredVol));
                    break;
                case VOLUMESET:
                    System.out.printf("Please input desired volume level for %s.\n", this.getDeviceID());
                    String userInput = getUserInput();
                    setVolume(userInput);
                    break;
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
}
