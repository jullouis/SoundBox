package com.example.soundbox;

import java.util.ArrayList;

public class Song extends Album {
    ArrayList<String> feat = new ArrayList<>();
    int titleDuration;
    String titleName;

    public Song(int titleDuration, String titleName, ArrayList<String> feat, int year, String coverURL, String mainInterpreter){
        super(year, coverURL, mainInterpreter);
        this.titleDuration = titleDuration;
        this.titleName = titleName;
        this.feat = feat;
    }

    public void playSong() {
        System.out.println("The song is playing");
    }
    public void stopSong(){
        System.out.println("The song is stopped");
    }
    public void repeatSong(){
        System.out.println("The song will repeat");
    }
    public ArrayList<String> getFeat() {
        return feat; //+ mainInterpreter;
    }
    public String getTitleName() {
        return titleName;
    }
    public int getTitleDuration(){
        return titleDuration;
    }
}

