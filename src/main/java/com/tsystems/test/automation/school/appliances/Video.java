package com.tsystems.test.automation.school.appliances;

import com.tsystems.test.automation.school.data.appliancemenudata.VideoMenuData;
import com.tsystems.test.automation.school.exceptions.DeviceIsOffException;
import com.tsystems.test.automation.school.exceptions.TvChannelOutRangeException;

import java.time.LocalDateTime;

import static com.tsystems.test.automation.school.Runner.getUserInput;

public class Video extends SoundSystem {
    private int channel;
    private final int maxChannel = 100;
    private final int minChannel = 1;

    public Video(String deviceID) {
        super(deviceID);
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void showMenu() {
        System.out.println("Please choose the action from below:");
        for (VideoMenuData menuItem : VideoMenuData.values()) {
            System.out.printf(" / %s / ", menuItem);
        }
        System.out.println();
    }

    @Override
    public void doControl() {
        System.out.println("Please input your command.");
        String commandToDo = getUserInput();
        try {
            int desiredVol;
            int desiredChannel;
            String userInput;
            switch (VideoMenuData.valueOf(commandToDo)) {
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
                    desiredVol = getVolumeLevel() + 1;
                    setVolume(Integer.toString(desiredVol));
                    break;
                case VOLUMEDOWN:
                    desiredVol = getVolumeLevel() - 1;
                    setVolume(Integer.toString(desiredVol));
                    break;
                case VOLUMESET:
                    System.out.printf("Please input desired volume level for %s.\n", this.getDeviceID());
                    userInput = getUserInput();
                    setVolume(userInput);
                    break;
                case CHANNELUP:
                    desiredChannel = getChannel() + 1;
                    setDesiredChannel(Integer.toString(desiredChannel));
                    break;
                case CHANNELDOWN:
                    desiredChannel = getChannel() - 1;
                    setDesiredChannel(Integer.toString(desiredChannel));
                    break;
                case CHOOSECHANNEL:
                    System.out.printf("Please input desired channel number for %s.\n", this.getDeviceID());
                    userInput = getUserInput();
                    setDesiredChannel(userInput);
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void turnOn() {
        super.turnOn();
        this.channel = 1;
        System.out.printf("Device %s default channel is %d.\n", this.getDeviceID(), channel);
        System.out.printf("Device %s max volume level is %d.\n", this.getDeviceID(), this.maxChannel);
    }

    void setDesiredChannel(String channel) {
        int channelToSet;
        try {
            if (this.getDeviceStatus().equals("off")) {
                throw new DeviceIsOffException(this.getDeviceID());
            } else {
                channelToSet = Integer.parseInt(checkNumberInput(channel));
                if (channelToSet < minChannel || channelToSet > maxChannel) {
                    throw new TvChannelOutRangeException(this.getDeviceID(), minChannel, maxChannel);
                } else {
                    setChannel(channelToSet);
                    System.out.printf("Device %s channel is set to %d at %s.\n", this.getDeviceID(), channelToSet, LocalDateTime.now().toString());
                }
            }
        } catch (DeviceIsOffException | TvChannelOutRangeException e) {
            System.out.println(e.getMessage());
        }
    }
}
