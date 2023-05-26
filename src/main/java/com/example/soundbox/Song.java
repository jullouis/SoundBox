package com.example.soundbox;

import java.util.ArrayList;

public class Song extends Album {
    ArrayList<String> feat = new ArrayList<>();
    int titleDuration;
    String titleName;

    public Song(String titleName, int year, String mainInterpreter, String coverURL, int titleDuration, ArrayList<String> feat){
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
    public String getFeat() {
        String s = feat + mainInterpreter;
        return s;
    }
    public String getTitleName(){
        return titleName;
    }
    public int getTitleDuration(){
        return titleDuration;
    }
    public int getYear() {
        return year;
    }
    public String getCoverURL(){
        return coverURL;
    }
}

