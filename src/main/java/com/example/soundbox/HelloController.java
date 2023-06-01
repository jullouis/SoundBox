package com.example.soundbox;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

/**
 * Create element for userinterface
 */
public class HelloController {
    @FXML
    private TextField researchBarre;
    @FXML
    private Label stateSong;
    //@FXML
    //private Label addInPlaylist;
    //@FXML
    //private ImageView backgroungImage;
    @FXML
    private ComboBox<String> playlistBox;


    ArrayList<String> albumlist = new ArrayList<>();
    ArrayList<String> songlist = new ArrayList<>();
    ArrayList<String> interpreterlist = new ArrayList<>();
    //ArrayList<String> Playlist1 = new ArrayList<>();
    //ArrayList<String> Playlist2 = new ArrayList<>();
    int i = -1;


    public HelloController() {
        albumlist.add("A Head Full of Dreams");
        albumlist.add("Ghost Stories");
        albumlist.add("Parachutes");
        albumlist.add("Mylo Xyloto");
        albumlist.add("X&Y");
        //nameList.add;

        songlist.add("One More Time");
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

    /**
     * Create method for searching music or artist to find a song
     *
     * @return
     */
    @FXML
    protected int researchSong() {
        String research = researchBarre.getText();
        boolean found = false;


        // Recherche dans la liste des chansons
        int i = -1;
        System.out.println(i);
        if (HelloApplication.getNameList().contains(research)) {
            while (i < HelloApplication.getNameList().size()) {
                i++;
                if (HelloApplication.getNameList().get(i).equalsIgnoreCase(research)) {
                    System.out.println(HelloApplication.getNameList().get(i));
                    System.out.println(i);
                    found = true;
                    break;
                } else {
                    System.out.println("search");
                }
            }
        } else if (interpreterlist.contains(research)) {
            i = -1;
            while (i < interpreterlist.size()) {
                i++;
                if (interpreterlist.get(i).equalsIgnoreCase(research)) {
                    System.out.println(interpreterlist.get(i));
                    System.out.println(i);
                    break;
                } else {
                    System.out.println("i++");
                }
            }
        }
        if (found) {
            stateSong.setText(research);
        } else{
            stateSong.setText("L'élément recherché n'existe pas");
            //i = -1; // rénitialiser la valeur i
        }
        return i;
    }

    /**
     * Method which add a song to a playlist
     */

    @FXML
    protected void addSongPlaylist() {
        playlistBox.getItems().add(researchBarre.getText());
        researchBarre.clear();
    }

    /**
     * Method which delete a song of a playlist
     */
    @FXML
    protected void deleteSongPlaylist(ActionEvent event) {
        playlistBox.getItems().remove(stateSong.getText());

    }

    @FXML
    protected void selectionSongPlaylist(ActionEvent event) {
        stateSong.setText(playlistBox.getValue());
    }

    /**
     * Method which stop a song during the play
     */
    @FXML
    protected void stopSong() {
        int result = researchSong();
        if (result >= 0) {
            stateSong.setText(songlist.get(result) + " est en pause");
            System.out.println(i);
        }
        else if (result == -1) {
            stateSong.setText("Pas de musique a jouer");
            System.out.println(i);
        }
        else if (result == -2) {
            String selectedPlaylist = playlistBox.getValue();
            if (selectedPlaylist != null) {
                stateSong.setText(selectedPlaylist + " est en pause");
            } else {
                stateSong.setText("Aucune musique sélectionnée");
            }
        }
    }

    /**
     * Method which play a song
     */
    @FXML
    //switch case
    protected void playSong() {
        int result = researchSong();
        if (result >= 0) {
            stateSong.setText(HelloApplication.getNameList().get(result) + " est lancée");
            System.out.println(i);
            System.out.println(HelloApplication.getNameList()); // Appel de la liste du CSV
        }
        else if (result == -1) {
            stateSong.setText("Pas de musique sélectionnée");
            System.out.println(i);
        }
        else if (result == -2) {
            String selectedPlaylist = playlistBox.getValue();
            if (selectedPlaylist != null) {
                stateSong.setText(selectedPlaylist + " est lancée");
            } else {
                stateSong.setText("Aucune musique sélectionnée dans la playlist");
                 }
            }
     }

}

