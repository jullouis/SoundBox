package com.example.soundbox;

import java.util.ArrayList;

public class Song extends Album {
    ArrayList<String> feat = new ArrayList<>();
    int duration;
    String titleName;

    public Song(int duration, String titleName, String feat, String year, String coverURL, String mainInterpreter){
        this.duration = duration;
        this.titleName = titleName;
        this.feat = feat;
        super.year = year;
        super.coverURL = coverURL;
        super.mainInterpreter = mainInterpreter;

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
        return feat + mainInterpreter;
    }
    public String getTitleName() {
        return titleName;
    }
    public int getTitleDuration(){
        return duration;
    }
}

