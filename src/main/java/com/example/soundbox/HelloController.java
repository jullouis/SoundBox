package com.example.soundbox;

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
    protected ImageView cover;
    @FXML
    private ListView<String> proposalList;




    //@FXML


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
        songDatas.setVisible(false);
        cover.setVisible(false);
        String researchedText = researchBarre.getText();
        int index = research(researchedText);
        currentIndex = index;
        return index;

    }

    protected int research(String researchedSong) {
        songDatas.setVisible(false);
        boolean found = false;
        int i = 0;

        // Recherche dans la liste des chansons

        System.out.println(i);
        if (HelloApplication.getNameList().stream().anyMatch(researchedSong::equalsIgnoreCase)) {//HelloApplication.getNameList().contains(researchedSong)) {
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
            stateSong.setText(HelloApplication.getNameList().get(i));
        } else if (researchBarre.getText().toString().isEmpty()) {
            stateSong.setText("Aucune musique recherchée");
        } else {
            stateSong.setText("L'élément recherché n'existe pas");
            currentIndex = -1; // rénitialiser l'index
        }
        researchBarre.clear();
        proposalList.getItems().clear();
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
            researchBarre.clear();
            proposalList.getItems().clear();
        } else if (HelloApplication.getNameList().contains(songResearchBarre)) {//&& HelloApplication.getMainInterpreterList().contains(songResearchBarre)) {
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
        String selectedSong = playlistBox.getValue();
        if (selectedSong != null) {
            int index = HelloApplication.getNameList().indexOf(selectedSong);
            if (index >= 0) { // permet de prendre les bonnes données selon l'index de la musique
                currentIndex = index;
                stateSong.setText(selectedSong);
                songDatas.setVisible(true);
                cover.setVisible(true);
            }
        }

    }

    @FXML
    protected void setProposalList() {
        String searchText = researchBarre.getText();
        String[] filteredSongs = filterSongs(searchText);

        proposalList.getItems().clear();
        proposalList.getItems().addAll(filteredSongs);
    }

    // filtrer les musiques en fonction
    private String[] filterSongs(String searchText) {
        // Création d'une liste pour stocker les chansons filtrées
        List<String> filteredSongs = new ArrayList<>();
        // Parcours de la liste des chansons disponibles
        for (String song : HelloApplication.getNameList()) {
            // Vérification si le nom de la chanson commence par le texte de recherche (ignorant la casse)
            if (song.toLowerCase().startsWith(searchText.toLowerCase())) {
                // Ajout de la chanson à la liste filtrée
                filteredSongs.add(song);
            }
        }
        // Conversion de la liste filtrée en tableau de chaînes et le retourner
        return filteredSongs.toArray(new String[0]);
    }

    @FXML
    protected void selectSongFromList(MouseEvent event) {
        if (event.getClickCount() == 1) { // Vérifie si un clic a été effectué
            String selectedSong = proposalList.getSelectionModel().getSelectedItem();
            if (selectedSong != null) {
                researchBarre.setText(selectedSong);
            }
        }
    }


    /**
     * Method stop the song which is on the stateSong
     * The method check if there is a String on the stateSong and put " est en pause " or " est en cours " or " Pas de musique" if stateSong is empty.
     * This is better because we this button don't work with the method research because it's more complicated
     * to do the difference between researchButton and Sélection musique.
     */
    @FXML
    protected void stopSong() {
        getSongDatas();
        String currentSong = stateSong.getText();

        if (currentSong.equals("L'élément recherché n'existe pas") || currentSong.equals("Impossible d'ajouter dans la playlist") || currentSong.equals("Aucune musique recherchée")){
            stateSong.setText("Impossible à jouer");
            songDatas.setVisible(false);
            cover.setVisible(false);
        }
        else if (currentSong.equals("Impossible à jouer") ){
            stateSong.setText("Erreur");
            songDatas.setVisible(false);
            cover.setVisible(false);
            System.out.println("else if 1 pause");

        }
        else if (!currentSong.endsWith(" est en pause") && !currentSong.equals("Erreur")) {
                // Le texte de l'état actuel ne se termine pas par " est en pause"
                // Cela signifie qu'il y a un changement d'état de pause à lecture
                // Donc, nous affichons le texte supplémentaire et mettons à jour la visibilité des éléments.
                currentSong = currentSong.replace(" est en cours", "");
                stateSong.setText(currentSong + " est en pause");
                songDatas.setVisible(false);
                cover.setVisible(false);
            System.out.println("else if 2 pause");
            }

    }





    /**
     * Method play the song which is on the stateSong
     * The method check if there is a String on the stateSong and put " est en pause " or " est en cours " or " Pas de musique" if stateSong is empty.
     * This is better because we this button don't work with the method research because it's more complicated
     * to do the difference between researchButton and Sélection musique.
     * We put inside this method codes which we can put on the cover of the song searching.
     */
    @FXML
    protected void playSong() {
        getSongDatas();
        String currentSong = stateSong.getText();

        if (currentSong.equals("L'élément recherché n'existe pas") || currentSong.equals("Impossible d'ajouter dans la playlist") || currentSong.equals("Aucune musique recherchée")) {
            stateSong.setText("Impossible à jouer");
            songDatas.setVisible(false);
            cover.setVisible(false);
            System.out.println("if playsong");
        }
        else if (currentSong.equals("Impossible à jouer") ){
            stateSong.setText("Erreur");
            songDatas.setVisible(false);
            cover.setVisible(false);
            System.out.println("else if 1 playsong");

        }
        else if (!currentSong.endsWith(" est en cours") && !currentSong.equals("Erreur")) {
                // Le texte de l'état actuel ne se termine pas par " est en cours"
                // Cela signifie qu'il y a un changement d'état de pause à lecture
                // Donc, nous affichons le texte supplémentaire et mettons à jour la visibilité des éléments.
                //La méthode endsWith() est une méthode disponible pour les objets de type String en Java. Elle permet de vérifier si une chaîne de caractères se termine par une autre chaîne spécifiée.
                currentSong = currentSong.replace(" est en pause", "");
                stateSong.setText(currentSong + " est en cours");
                songDatas.setVisible(true);
                cover.setVisible(true);
                System.out.println("else if 2 playsong");


                // Chemin du fichier CSV
                String csvFilePath = ("data/database/songs_db.csv");

                try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
                    // Map pour stocker les correspondances nom de la musique - chemin de l'image
                    Map<String, String> songImageMap = new HashMap<>();

                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(";");  // Séparateur CSV, ajustez-le si nécessaire
                        String songName = parts[1];  // Colonne contenant le nom de la musique
                        String imagePath = parts[5];  // Colonne contenant le chemin de l'image

                        songImageMap.put(songName, imagePath);
                    }

                    // Récupération du chemin de l'image correspondant à la musique recherchée
                    String imagePath = songImageMap.get(currentSong);

                    if (imagePath != null) {
                        // Création de l'objet Image
                        Image image = new Image(new File(imagePath).toURI().toString());
                        // image = new Image("file:C:\\Projet_Informatique\\SoundBox\\src\\main\\resources\\pics\\Damso.jpg");
                        System.out.println(new File(imagePath).toURI().toString());

                        // Affichage de l'image dans l'objet ImageView
                        cover.setImage(image);
                        //cover.setImage(new Image("C:\\Projet_Informatique\\SoundBox\\src\\main\\resources\\pics\\Damso.jpg"));
                    }
                } catch (IOException e) {
                    // Gérer les exceptions liées à la lecture du fichier CSV
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

}





