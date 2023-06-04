package com.example.soundbox;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
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

    @FXML
    private Label title;
    @FXML
    private Label year;
    @FXML
    private Label artist;
    @FXML
    private Label duration;

    @FXML
    private GridPane songDatas;
    @FXML
    private int currentIndex = -1;
    @FXML
    private ImageView cover;

    @FXML
    private FileChooser fileChooser;



    //ArrayList<String> albumlist = new ArrayList<>();
    //ArrayList<String> songlist = new ArrayList<>();
    //ArrayList<String> interpreterlist = new ArrayList<>();
    //ArrayList<String> Playlist1 = new ArrayList<>();
    //ArrayList<String> Playlist2 = new ArrayList<>();
    //int i = -1;
    //int selectedSong;


    public HelloController() {
        //albumlist.add("A Head Full of Dreams");
        //albumlist.add("Ghost Stories");
        //albumlist.add("Parachutes");
        //albumlist.add("Mylo Xyloto");
        //albumlist.add("X&Y");

        //songlist.add("One More Time");
        //songlist.add("Red Flag");
        //songlist.add("StarLight");
        //songlist.add("In the End");
        //songlist.add("In Too Deep");

        //interpreterlist.add("Linkin Park");
        //interpreterlist.add("Cold Play");
        //interpreterlist.add("DaftPunk");
        //interpreterlist.add("AC/DC");
        //interpreterlist.add("Hardwell");
        //interpreterlist.add("Eminem");

        // A modifier, juste pour tester l'attribution de songList (et ajouter la majuscule !!)
        //songlist.addAll(HelloApplication.getNameList());
        //System.out.println(songlist);

    }

    /**
     * Create method for searching music or artist to find a song
     *
     * @return we return index i. The index contain a song type String that can be show on the label stateSong
     */
    @FXML
    protected int researchButton() {

        //ToDo ajouter la fonction de convertissement en minuscules
        String researchedText = researchBarre.getText();
        int index = research(researchedText);
        currentIndex = index;
        return index;
    }

    protected int research(String researchedSong) {

        boolean found = false;
        int i = 0;

        // Recherche dans la liste des chansons

        System.out.println(i);
        if (HelloApplication.getNameList().contains(researchedSong)) {
            while (i < HelloApplication.getNameList().size()) {
                i++;
                if (HelloApplication.getNameList().get(i).equalsIgnoreCase(researchedSong)) {
                    System.out.println(HelloApplication.getNameList().get(i));
                    System.out.println(i);
                    found = true;
                    break;
                } else {
                    System.out.println("search");
                }
            }
        } else if (HelloApplication.getMainInterpreterList().contains(researchedSong)) {
            while (i < HelloApplication.getMainInterpreterList().size()) {
                i++;
                if (HelloApplication.getMainInterpreterList().get(i).equalsIgnoreCase(researchedSong)) {
                    System.out.println(HelloApplication.getMainInterpreterList().get(i));
                    System.out.println(i);
                    break;
                } else {
                    System.out.println("i++");
                }
            }
        }
        if (found) {
            stateSong.setText(researchedSong);
        } else {
            stateSong.setText("L'élément recherché n'existe pas");
            currentIndex = 0; // rénitialiser l'index

        }
        return i;
    }
    @FXML
    protected void getSongDatas() {
        if (currentIndex != 0) {
            title.setText(HelloApplication.getNameList().get(currentIndex));
            year.setText(HelloApplication.getYearList().get(currentIndex));
            artist.setText(HelloApplication.getMainInterpreterList().get(currentIndex));
            duration.setText(HelloApplication.getDurationList().get(currentIndex));
        } else {
            // Gérer le cas où l'élément n'a pas été trouvé ou n'existe pas
            title.setText("");
            year.setText("");
            artist.setText("");
            duration.setText("");
        }
    }

    /**
     * Method which add a song to a playlist
     * If the song doesn't exit research, you can't add
     * the song on the playlist1. If the song exist you can.
     */

    @FXML
    // TODO: 04.06.2023 Faire la partie pour interpreter
    protected void addSongPlaylist() {
        String songResearchBarre = researchBarre.getText();
        if (songResearchBarre.equals("L'élément recherché n'existe pas")) {
           stateSong.setText(" ");
        } else if (HelloApplication.getNameList().contains(songResearchBarre)){//&& HelloApplication.getMainInterpreterList().contains(songResearchBarre)) {
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
        songDatas.setVisible(true);
        getSongDatas();
    }

    /**
     * Method stop the song which is on the stateSong
     * The method check if there is a String on the stateSong and put " est en pause " or " est en cours " or " Pas de musique" if stateSong is empty.
     * This is better because we this button don't work with the method research because it's more complicated
     * to do the difference between researchButton and Sélection musique.
     */
    @FXML
    protected void stopSong() {
        songDatas.setVisible(false);
        getSongDatas();
        cover.setVisible(false);
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
    // TODO: 04.06.2023 il faut trouver un  moyen pour stocker à quelque part les liens des images des titres
    @FXML
    protected void playSong() {
        songDatas.setVisible(true);
        getSongDatas();
        cover.setVisible(true);
        String currentSong = stateSong.getText();
        if (currentSong.equals("L'élément recherché n'existe pas")) {
            stateSong.setText("Aucune musique");
        } else if (!currentSong.isEmpty() && !currentSong.equals("Aucune musique")) {
            if (!currentSong.endsWith(" est en cours")) {
                currentSong = currentSong.replace(" est en pause", "");
                stateSong.setText(currentSong + " est en cours");

                //Test Affichage image avec titre Waka Waka
                Image image = new Image("C:\\Projet_Informatique\\SoundBox\\src\\main\\resources\\pics\\Waka Waka.jpg");
                cover.setImage(image);
                
                // Récupérer le chemin/nom de fichier d'image correspondant à la chanson en cours
                //int index = research(currentSong);
                //String imagePath = imageList.get(index);

                // Afficher l'image correspondante
                //Image image = new Image("file:" + imagePath); // Préfixe "file:" pour charger à partir d'un chemin de fichier
                //currentCover.setImage(image);
            }

        }

    }

}

