package com.example.soundbox;

import java.util.ArrayList;

public class Album {
//Declaration of the attributs
    String albumName;
    int year;
    String mainInterpreter;
    String coverURL;
    int albumDuration;
    ArrayList<String> songList;
    int numberSongs;

//Constructor

    /**
     * @param year
     * @param mainInterpreter
     * @param coverURL
     */

    public Album(int year, String mainInterpreter, String coverURL){
        this.albumName = albumName;
        this.year = year;
        this.mainInterpreter = mainInterpreter;
        this.coverURL = coverURL;
        this.songList = songList;

    }
    String getAlbumName(){
        return albumName;
    }

    int getYear(){
        return year;
    }

    String getMainInterpreter(){
        return mainInterpreter;
    }

    String getCoverURL(){
        return coverURL;
    }
    int getAlbumDuration(){
        // Récupérer les durées des différents titres "Song" de l'ArrayList "songList" et en faire la somme
        return albumDuration;
    }
    public ArrayList<String> getSongList() {
        return songList;
    }

    public int getNumberSongs() {
        numberSongs = songList.toArray().length;
        return numberSongs;
    }
}
