package com.example.soundbox;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




//import java.util.ArrayList;

/**
 * Code for USER Controller
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
    private Label album;
    @FXML
    private GridPane songDatas;
    @FXML
    private int currentIndex = -1;
    @FXML
    protected ImageView cover;
    @FXML
    private ListView<String> proposalList;
    


    /**
     * This method displays the music selected in the reasearchBar.
     * @return we return index i. The index contain a song type String that can be show on the label stateSong with the method research
     *  that this code ( int index = research(researchedText);
     */

    @FXML
    protected int researchButton() {
        songDatas.setVisible(false);
        cover.setVisible(false);
        proposalList.setVisible(false);

        String researchedText = researchBarre.getText();
        int index = 0;

        if (HelloApplication.getNameList().stream().anyMatch(researchedText::equalsIgnoreCase)) {
            index = research(researchedText);
            proposalList.setVisible(false);
        }
        else if (HelloApplication.getMainInterpreterList().stream().anyMatch(researchedText::equalsIgnoreCase)){
            index = researchArtist(researchedText);
            proposalList.setVisible(false);

        }
        else if (researchBarre.getText().toString().isEmpty()) {
            stateSong.setText("Aucune recherche");
            currentIndex = -1;
        } else {
            stateSong.setText("L'élément recherché n'existe pas");
            currentIndex = -1; // rénitialiser l'index
        }
        

        currentIndex = index;
        return index;
    }

    /**
     * The research method searches for a piece of music in the song.csv file, by writing text in the researchBarrel .
     * If it finds the music, it returns the index i, which is the position of the music in the file.
     * The index is then converted to a String, which is used to display what was found in the stateSong when the select button (researchButton) is pressed.
     * @param researchedSong
     * @return
     */
    protected int research(String researchedSong) {
        songDatas.setVisible(false);
        proposalList.setVisible(true);
        boolean found = false;
        int i = 0;

        // Searching the list of songs

        System.out.println(i);
        if (HelloApplication.getNameList().stream().anyMatch(researchedSong::equalsIgnoreCase)) {//HelloApplication.getNameList().contains(researchedSong)) {
            while (i < HelloApplication.getNameList().size()) {
                if (HelloApplication.getNameList().get(i).equalsIgnoreCase(researchedSong)) {
                    System.out.println(HelloApplication.getNameList().get(i));
                    System.out.println(i);
                    found = true;
                    break;
                } else {
                    System.out.println("search");
                }
                i++;
            }
        }

        if (found) {
            stateSong.setText(HelloApplication.getNameList().get(i));
        } else if (researchBarre.getText().toString().isEmpty()) {
            stateSong.setText("Aucune recherche");
            currentIndex = -1;
        } else {
            stateSong.setText("L'élément recherché n'existe pas");
            currentIndex = -1; // rénitialiser l'index
        }
        researchBarre.clear();
        proposalList.getItems().clear();
        return i;
    }
    protected int researchArtist(String researchedArtist) {
        songDatas.setVisible(false);
        proposalList.setVisible(true);
        boolean found = false;
        int i = 0;

        while (i < HelloApplication.getMainInterpreterList().size()) {
            i++;
            if (HelloApplication.getMainInterpreterList().get(i).equalsIgnoreCase(researchedArtist)) {
                found = true;
                break;
            }
        }

        if (found) {
            stateSong.setText(HelloApplication.getNameList().get(i));
        }
        researchBarre.clear();
        proposalList.getItems().clear();
        return i;
    }

    /**
     * This method allows you to suggest music based on what you write in the researchBar.
     * When the music has been found. Click with the mouse on the music to put it in the researchBarre.
     * As soon as you press the researchButton, it deletes the text in the proposalList and researchBarre.
     */
    @FXML
    protected void setProposalList() {
        String searchText = researchBarre.getText();
        String[] filteredSongs = filterSongs(searchText);
        String[] filteredArtists = filterArtists(searchText);

        proposalList.getItems().clear();
        proposalList.setVisible(true);
        proposalList.getItems().addAll(filteredSongs);
        proposalList.getItems().addAll(filteredArtists);
    }

    @FXML
    protected void selectSongFromList(MouseEvent event) {
        proposalList.setVisible(false);
        if (event.getClickCount() == 1) { // Checks whether a mouse click has been made
            String selectedSong = proposalList.getSelectionModel().getSelectedItem();
            if (selectedSong != null) {
                researchBarre.setText(selectedSong);
            }
        }
    }
    /**
     * Method filterSongs = filter music
     * Create a list to store filtered songs
     * Browse the list of available songs
     * Check whether the name of the song begins with the search text
     * Add the song to the filtered list
     * @param searchText Text which is written on the researchBarre
     * @return Convert the filtered list into an array of strings and return it
     */
    private String[] filterSongs(String searchText) {
        proposalList.setVisible(true);
        List<String> filteredSongs = new ArrayList<>();
        for (String song : HelloApplication.getNameList()) {
            if (song.toLowerCase().startsWith(searchText.toLowerCase())) {
                filteredSongs.add(song);
            }
        }
        return filteredSongs.toArray(new String[0]);
    }
    private String[] filterArtists(String searchText) {
        proposalList.setVisible(true);
        int i = 0;
        String textsong;
        List<String> filteredArtists = new ArrayList<>();
        for (String artist : HelloApplication.getMainInterpreterList()) {
            textsong = "";
            if (artist.toLowerCase().startsWith(searchText.toLowerCase())) {
                //text += artist;
                //text += ", ";
                textsong += HelloApplication.getNameList().get(i);
                filteredArtists.add(textsong);
            }
            i ++;
        }
        return filteredArtists.toArray(new String[0]);
    }


    /**
     * getSongDatas displays the music data retrieved from the songs.csv file in the songData.
     * To store this data in memory, we use the same index i as in the research method.
     */
    @FXML
    protected void getSongDatas() {
        if (currentIndex >= 0) {
            title.setText(HelloApplication.getNameList().get(currentIndex));
            album.setText(HelloApplication.getAlbumList().get(currentIndex));
            year.setText(HelloApplication.getYearList().get(currentIndex));
            artist.setText(HelloApplication.getMainInterpreterList().get(currentIndex));
            duration.setText(HelloApplication.getDurationList().get(currentIndex));
        } else {
            // Manage the case where the element has not been found or does not exist
            title.setText("");
            album.setText("");
            year.setText("");
            artist.setText("");
            duration.setText("");
        }
    }

    /**
     * This method adds music to the playlist.
     * If the music does not exist, it cannot be added to the playlist.
     * when we add music to the playlist we sort in alphabetical order
     */

    @FXML
    protected void addSongPlaylist() {
        String songResearchBarre = researchBarre.getText();
        proposalList.setVisible(false);

        if (songResearchBarre.equals("L'élément recherché n'existe pas")) {
            stateSong.setText(" ");
            researchBarre.clear();
            proposalList.getItems().clear();
        } else if (HelloApplication.getNameList().contains(songResearchBarre)) {
            playlistBox.getItems().add(songResearchBarre);
            playlistBox.getItems().sort(null);
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
        proposalList.setVisible(false);

        if (selectedSong != null && selectedSong.equals(currentSong)) {
            stateSong.setText("");
        }
        playlistBox.getItems().remove(selectedSong);
    }
    @FXML
    protected void selectionSongPlaylist(ActionEvent event) {
        String selectedSong = playlistBox.getValue();
        proposalList.setVisible(false);
        if (selectedSong != null) {
            int index = HelloApplication.getNameList().indexOf(selectedSong);
            // selects the correct data according to the music index
            if (index >= 0) {
                currentIndex = index;
                stateSong.setText(selectedSong);
                songDatas.setVisible(false);
                cover.setVisible(false);
            }
        }

    }

    /**
     * Method stop the song which is on the stateSong
     * The method check if there is a String on the stateSong and put " est en pause " or " est en cours " or " Pas de musique" if stateSong is empty.
     * This is better because this button don't work with the method research only with the string on the stateSong
     * Function .endswith : The endsWith() method is available for String objects in Java. It is used to check whether a character string ends with another specified string.
     */
    @FXML
    protected void stopSong() {
        getSongDatas();
        String currentSong = stateSong.getText();
        proposalList.setVisible(false);

        if (currentSong.equals("")){
            stateSong.setText("Aucun élément sélectionnné");
            songDatas.setVisible(false);
        }

        else if (currentSong.equals("L'élément recherché n'existe pas") || currentSong.equals("Impossible d'ajouter dans la playlist") || currentSong.equals("Aucune musique recherchée") || currentSong.equals("Aucune recherche") || currentSong.equals("Aucun élément sélectionnné")){
            stateSong.setText("Impossible à jouer");
            songDatas.setVisible(false);
            cover.setVisible(false);
        }
        else if (currentSong.equals("Impossible à jouer") ){
            stateSong.setText("Erreur");
            songDatas.setVisible(false);
            cover.setVisible(false);
            // For test System.out.println("else if 1 pause");

        }
        else if (!currentSong.endsWith(" est en pause") && !currentSong.equals("Erreur")) {
                currentSong = currentSong.replace(" est en cours", "");
                stateSong.setText(currentSong + " est en pause");
                songDatas.setVisible(false);
                cover.setVisible(false);
                // For test System.out.println("else if 2 pause");
            }

    }
    /**
     * Method play the song which is on the stateSong
     * The method check if there is a String on the stateSong and put " est en pause " or " est en cours " or " Pas de musique" if stateSong is empty.
     * This is better because we this button don't work with the method research because it's more complicated
     * We put inside this method codes which we can put on the cover of the song searching.
     * Function .endswith : // The endsWith() method is available for String objects in Java. It is used to check whether a character string ends with another specified string.
     */
    @FXML
    protected void playSong() {
        getSongDatas();
        String currentSong = stateSong.getText();
        proposalList.setVisible(false);

        if (currentSong.equals("")){
            stateSong.setText("Aucun élément sélectionnné");
            songDatas.setVisible(false);
        }
        else if (currentSong.equals("L'élément recherché n'existe pas") || currentSong.equals("Impossible d'ajouter dans la playlist") || currentSong.equals("Aucune musique recherchée") || currentSong.equals("Aucune recherche") || currentSong.equals("Aucun élément sélectionnné") ) {
            stateSong.setText("Impossible à jouer");
            songDatas.setVisible(false);
            cover.setVisible(false);
            // For test System.out.println("if playsong");
        }
        else if (currentSong.equals("Impossible à jouer") ){
            stateSong.setText("Erreur");
            songDatas.setVisible(false);
            cover.setVisible(false);
            // For test!!! System.out.println("else if 1 playsong");

        }
        else if (!currentSong.endsWith(" est en cours") && !currentSong.equals("Erreur")) {
                currentSong = currentSong.replace(" est en pause", "");
                stateSong.setText(currentSong + " est en cours");
                songDatas.setVisible(true);
                cover.setVisible(true);

                // For test!!! System.out.println("else if 2 playsong");


                // Code to display the music image

                // CSV file path
                String csvFilePath = ("data/database/songs_db.csv");

                try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
                    // Map to store music name - image path correspondences
                    Map<String, String> songImageMap = new HashMap<>();

                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(";");  // CSV separator
                        String songName = parts[1];  // Column containing the name of the music
                        String imagePath = parts[5];  // Column containing the image path

                        songImageMap.put(songName, imagePath);
                    }

                    // Retrieve the path to the image corresponding to the music you are looking for
                    String imagePath = songImageMap.get(currentSong);

                    if (imagePath != null) {
                        // Create the Image object
                        Image image = new Image(new File(imagePath).toURI().toString());
                        System.out.println(new File(imagePath).toURI().toString());

                        // Display the image in the ImageView
                        cover.setImage(image);

                    }
                } catch (IOException e) {
                    // Handle exceptions related to reading the CSV file
                    e.printStackTrace();
                }

            }

        }


        //permettant le switch scene
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException {
        System.out.println("Trying to switch to Admin...");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("admin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToLogin(ActionEvent event) throws IOException {
        System.out.println("Trying to switch to Login...");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}





