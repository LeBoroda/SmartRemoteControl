package com.tsystems.test.automation.school.appliances;

import com.tsystems.test.automation.school.appliances.SoundSystem;
import com.tsystems.test.automation.school.data.appliancemenudata.VideoMenuData;

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
    public void showMenu(){
        System.out.println("Please choose the action from below:");
        for(VideoMenuData menuItem: VideoMenuData.values()){
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
            int desiredChannel;
            String userInput;
            switch (VideoMenuData.valueOf(commandToDo)){
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
                    userInput = getUserInput();
                    setVolume(userInput);
                    break;
                case CHANNELUP:
                    desiredChannel = getChannel()+1;
                    setChannel(Integer.toString(desiredChannel));
                    break;
                case CHANNELDOWN:
                    desiredChannel = getChannel()-1;
                    setChannel(Integer.toString(desiredChannel));
                    break;
                case CHOOSECHANNEL:
                    System.out.printf("Please input desired channel number for %s.\n", this.getDeviceID());
                    userInput = getUserInput();
                    setChannel(userInput);
                    break;
            }
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    public void turnOn(){
        super.turnOn();
        this.channel = 1;
        System.out.printf("Device %s default channel is %d.\n", this.getDeviceID(), channel);
        System.out.printf("Device %s max volume level is %d.\n", this.getDeviceID(), this.maxChannel);
    }
    void setChannel(String channel){
        if (this.getDeviceStatus().equals("off")) {
            System.out.printf("Device %s is off.\n", this.getDeviceID());
        } else {
            int channelToSet = Integer.parseInt(checkNumberInput(channel));
            while (true) {
                if (channelToSet < minChannel) {
                    System.out.printf("This device min channel is %d.\n", minChannel);
                    channelToSet = Integer.parseInt(checkNumberInput(getUserInput()));
                } else if (channelToSet > maxChannel) {
                    System.out.printf("This device max channel is %d.\n", maxChannel);
                    channelToSet = Integer.parseInt(checkNumberInput(getUserInput()));
                } else {
                    setChannel(channelToSet);
                    System.out.printf("Device %s channel is set to %d at %s.\n", this.getDeviceID(), channelToSet, LocalDateTime.now().toString());
                    break;
                }
            }
        }
    }
}
