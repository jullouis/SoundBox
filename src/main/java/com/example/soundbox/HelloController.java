package com.example.soundbox;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private TextField researchBarre;
    @FXML
    private Label stateSong;
    @FXML
    private Label addInPlaylist;
    @FXML
    private ImageView backgroungImage;


    ArrayList<String> albumlist = new ArrayList<>();
    ArrayList<String> songlist = new ArrayList<>();
    ArrayList<String> interpreterlist = new ArrayList<>();
    ArrayList<String> Playlist1 = new ArrayList<>();
    ArrayList<String> Playlist2 = new ArrayList<>();
    int i = -1;




    public HelloController() {
        albumlist.add("A Head Full of Dreams");
        albumlist.add("Ghost Stories");
        albumlist.add("Parachutes");
        albumlist.add("Mylo Xyloto");
        albumlist.add("X&Y");

        songlist.add("One More time");
        songlist.add("Red Flag");
        songlist.add("StarLight");
        songlist.add("In the End");
        songlist.add("In Too Deep");

        interpreterlist.add("Linkin Park");
        interpreterlist.add("Cold Play");
        interpreterlist.add("DaftPunk");
        interpreterlist.add("AC/DC");
        interpreterlist.add("Hardwell");
        interpreterlist.add("Eminem");

    }
    /*@FXML
    protected File printBackgroungImage(){
        Image backgroundUrl = new Image(file.toURI.C:\\\\Projet_Informatique\\\\SoundBox\\\\data\\\\pics\\\\Arrière_plan.jpg\");
        backgroungImage.setImage(file.toURI."C:\\Projet_Informatique\\SoundBox\\data\\pics\\Arrière_plan.jpg");
    }
     */
    @FXML
    protected int researchSong() {
        String research = researchBarre.getText();


        // Recherche dans la liste des chansons
        int i = -1;
        System.out.println(i);
        if (songlist.contains(research)) {
            while (i < songlist.size()) {
                i++;
                if (songlist.get(i).equalsIgnoreCase(research)) {
                    System.out.println(songlist.get(i));
                    System.out.println(i);
                    break;
                } else {
                    System.out.println("i++");
                }
            }
        } else {
            i = -2;
            System.out.println("L'élément recherché n'existe pas");
        }
        return i;
    }

 /*
        for (String song : songlist) {
            if (song.equalsIgnoreCase(research)) {
                System.out.println(i);
                System.out.println(song);
                songFound = true;
                i++;
                if()
                break;
            }
        }
*/
        // Recherche dans la liste des albums
/**
        if (!songFound) {
            i = -1;
            for (String album : albumlist) {
                if (album.equalsIgnoreCase(research)) {
                    System.out.println(album);
                    albumFound = true;
                    i++;
                    break;
                }
            }
        }

        // Recherche dans la liste des artistes
        if (!songFound && !albumFound) {
            i = -1;
            for (String artist : interpreterlist) {
                if (artist.equalsIgnoreCase(research)) {
                    System.out.println(artist);
                    artistFound = true;
                    i++;
                    break;
                }
            }
        }
        if (!songFound && !albumFound && !artistFound) {
            System.out.println("Aucun résultat trouvé.");
    }
 }
**/

    @FXML
    protected void addSong() {
        stateSong.setText("La musique " + songlist.get(researchSong()) + " est ajoutée " + addInPlaylist);
        addInPlaylist.setText(songlist.get(researchSong()));
    }
    @FXML
    protected void deleteSong() {
        stateSong.setText("La musique " + songlist.get(researchSong()) + " est supprimée à la playlist");
    }

    @FXML
    protected void stopSong() {
        stateSong.setText("Pause");
    }
    @FXML
    protected void playSong() {
        if (researchSong() == -1) {
            stateSong.setText (" no song selected " );
            System.out.println(i);
        } else {
            stateSong.setText(songlist.get(researchSong())  +  " is playing " );
            System.out.println(i);
        }
    }

}
