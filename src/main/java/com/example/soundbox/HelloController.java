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
    @FXML
    private ComboBox<String> playlistBox;


    ArrayList<String> albumlist = new ArrayList<>();
    ArrayList<String> songlist = new ArrayList<>();
    ArrayList<String> interpreterlist = new ArrayList<>();
    //ArrayList<String> Playlist1 = new ArrayList<>();
    //ArrayList<String> Playlist2 = new ArrayList<>();
    //int i = -1;
    //int selectedSong;


    public HelloController() {
        albumlist.add("A Head Full of Dreams");
        albumlist.add("Ghost Stories");
        albumlist.add("Parachutes");
        albumlist.add("Mylo Xyloto");
        albumlist.add("X&Y");

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

        // A modifier, juste pour tester l'attribution de songList (et ajouter la majuscule !!)
        songlist.addAll(HelloApplication.getNameList());
        System.out.println(songlist);

    }

    /**
     * Create method for searching music or artist to find a song
     *
     * @return we return index i. The index contain a song type String that can be show on the label stateSong
     */
    @FXML
    protected int research() {

        //ToDo ajouter la fonction de convertissement en minuscules

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
        } else if (HelloApplication.getMainInterpreterList().contains(research)) {
            //i = -1;
            while (i < HelloApplication.getMainInterpreterList().size()) {
                i++;
                if (HelloApplication.getMainInterpreterList().get(i).equalsIgnoreCase(research)) {
                    System.out.println(HelloApplication.getMainInterpreterList().get(i));
                    System.out.println(i);
                    break;
                } else {
                    System.out.println("i++");
                }
            }
        }
        if (found) {
            stateSong.setText(research);
        } else {
            stateSong.setText("L'élément recherché n'existe pas");

        }
        return i;
    }

    /**
     * Method which add a song to a playlist
     * If the song doesn't exit research, you can't add
     * the song on the playlist1. If the song exist you can.
     */

    @FXML
    protected void addSongPlaylist() {
        String songResearchBarre = researchBarre.getText();
        if (songResearchBarre.equals("L'élément recherché n'existe pas")) {
           stateSong.setText(" ");
        } else if (HelloApplication.getNameList().contains(songResearchBarre) || HelloApplication.getMainInterpreterList().contains(songResearchBarre)) {
            playlistBox.getItems().add(songResearchBarre);
            researchBarre.clear();
        } else {
            stateSong.setText("Impossible d'ajouter dans la playlist");
        }
    }
    /**
     * Method which delete a song of a playlist
     */
    @FXML
    protected void deleteSongPlaylist(ActionEvent event) {
        String selectedSong = playlistBox.getValue();
        String currentSong = stateSong.getText();
        if (selectedSong != null && selectedSong.equals(currentSong)) {
            stateSong.setText("");
        }
        playlistBox.getItems().remove(selectedSong);
    }

    @FXML
    protected void selectionSongPlaylist(ActionEvent event) {
        stateSong.setText(playlistBox.getValue());
    }

    /**
     * Method stop the song which is on the stateSong
     * The method check if there is a String on the stateSong and put " est en pause " or " est en cours " or " Pas de musique" if stateSong is empty.
     * This is better because we this button don't work with the method research because it's more complicated
     * to do the difference between researchButton and Sélection musique.
     */
    @FXML
    protected void stopSong() {
        String currentSong = stateSong.getText();
        if (currentSong.equals("L'élément recherché n'existe pas")) {
            stateSong.setText("Aucune musique");
        } else if (!currentSong.isEmpty() && !currentSong.equals("Aucune musique")) {
            if (!currentSong.endsWith(" est en pause")) {
                currentSong = currentSong.replace(" est en cours", "");
                stateSong.setText(currentSong + " est en pause");
            }
        }

    }

    /**
     * Method play the song which is on the stateSong
     * The method check if there is a String on the stateSong and put " est en pause " or " est en cours " or " Pas de musique" if stateSong is empty.
     * This is better because we this button don't work with the method research because it's more complicated
     * to do the difference between researchButton and Sélection musique.
     */
    @FXML
    protected void playSong() {
        String currentSong = stateSong.getText();
        if (currentSong.equals("L'élément recherché n'existe pas")) {
            stateSong.setText("Aucune musique");
        } else if (!currentSong.isEmpty() && !currentSong.equals("Aucune musique")) {
            if (!currentSong.endsWith(" est en cours")) {
                currentSong = currentSong.replace(" est en pause", "");
                stateSong.setText(currentSong + " est en cours");
            }

        }

    }
}

