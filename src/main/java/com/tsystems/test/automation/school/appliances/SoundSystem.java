package com.tsystems.test.automation.school.appliances;

import com.tsystems.test.automation.school.exceptions.DeviceIsOffException;
import com.tsystems.test.automation.school.exceptions.VolumeLevelOutOfRangeException;

import java.time.LocalDateTime;

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
    public void turnOn() {
        super.turnOn();
        this.volumeLevel = 15;
        System.out.printf("Device %s default volume level is %d.\n", this.getDeviceID(), this.getVolumeLevel());
    }

    void setVolume(String volume) {
        try {
            if (this.getDeviceStatus().equals("off")) {
                throw new DeviceIsOffException(this.getDeviceID());
            } else {
                int volToSet = Integer.parseInt(checkNumberInput(volume));

                if (volToSet < minVolume || volToSet > maxVolume) {
                    throw new VolumeLevelOutOfRangeException(this.getDeviceID(), minVolume, maxVolume);
                } else {
                    setVolumeLevel(volToSet);
                    System.out.printf("Device %s volume level is set to %d at %s.\n", this.getDeviceID(), volToSet, LocalDateTime.now().toString());
                }
            }
        } catch (DeviceIsOffException | VolumeLevelOutOfRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
