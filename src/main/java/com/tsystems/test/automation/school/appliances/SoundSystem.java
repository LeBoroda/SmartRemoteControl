package com.tsystems.test.automation.school.appliances;

import com.tsystems.test.automation.school.appliances.AbsDevice;

import java.time.LocalDateTime;

import static com.tsystems.test.automation.school.Runner.getUserInput;

public class SoundSystem extends AbsDevice {
    private int volumeLevel;
    private final int maxVolume = 100;
    private final int minVolume = 0;
    public SoundSystem(String deviceID) {
        super(deviceID);
    }
    int getVolumeLevel() {
        return volumeLevel;
    }
    private void setVolumeLevel(int volumeLevel) {
        this.volumeLevel = volumeLevel;
    }
    @Override
    public void turnOn(){
        super.turnOn();
        this.volumeLevel = 15;
        System.out.printf("Device %s default volume level is %d.\n", this.getDeviceID(), this.getVolumeLevel());
        System.out.printf("Device %s max volume level is %d.\n", this.getDeviceID(), this.maxVolume);
    }
    void setVolume(String volume){
        if (this.getDeviceStatus().equals("off")) {
            System.out.printf("Device %s is off.\n", this.getDeviceID());
        } else {
            int volToSet = Integer.parseInt(checkNumberInput(volume));
            while (true) {
                if (volToSet < 0) {
                    System.out.printf("This device min volume level is %d.\n", minVolume);
                    volToSet = Integer.parseInt(checkNumberInput(getUserInput()));
                } else if (volToSet > maxVolume) {
                    System.out.printf("This device max volume level is %d.\n", maxVolume);
                    volToSet = Integer.parseInt(checkNumberInput(getUserInput()));
                } else {
                    setVolumeLevel(volToSet);
                    System.out.printf("Device %s volume level is set to %d at %s.\n", this.getDeviceID(), volToSet, LocalDateTime.now().toString());
                    break;
                }
            }
        }
    }
}
