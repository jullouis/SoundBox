package com.example.soundbox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static com.example.soundbox.HelloApplication.*;

public class Admin extends HelloController {
    @FXML
    public TextField adminName;
    public TextField adminYear;
    public TextField adminMainInterpreter;
    public TextField adminDuration;
    public TextField adminAlbum;
    public ImageView adminPicture;
    public ImageView adminMP3;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public TextField adminSearch;
    public Label adminError;

    /**
     * This method is for choosing pics files from our disk for the song in the interface.
     */
    @FXML
    protected void ChooserPics() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src/main/resources/pics"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image img = new Image(file.toURI().toString());
            adminPicture.setImage(img);
        }
    }

    /**
     * This method is for choosing the MP3 files from our disk for the song in the interface, but we don't use it again
     */
    @FXML
    protected void ChooserSongs() { // --> not in function
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("src/main/resources/songs"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image img = new Image(file.toURI().toString());
            adminMP3.setImage(img);
        }
    }

    /**
     * This method is used to add the sounds features in the lists and in the csv files with all the criteria fields filled.
     */
    @FXML
    protected void addSong() throws IOException {
        FileWriter writer = new FileWriter("data/database/songs_db.csv", true);
        writer.append("\n");
        writer.append("song");
        writer.append(";");
        writer.append(adminName.getText());
        HelloApplication.nameList.add(adminName.getText());
        writer.append(";");
        writer.append(adminAlbum.getText());
        HelloApplication.albumList.add(adminAlbum.getText());
        writer.append(";");
        writer.append(adminYear.getText());
        HelloApplication.yearList.add(adminYear.getText());
        writer.append(";");
        writer.append(adminMainInterpreter.getText());
        HelloApplication.mainInterpreterList.add(adminMainInterpreter.getText());
        writer.append(";");
        //take the right path of the url
        String FullURL = adminPicture.getImage().getUrl();
        int Index = FullURL.indexOf("src");
        String URL = FullURL.substring(Index);
        writer.append(URL);
        HelloApplication.coverUrlList.add(URL);
        writer.append(";");
        writer.append(adminDuration.getText());
        HelloApplication.durationList.add(adminDuration.getText());
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        writer.append(";");
        writer.append("");
        //writer.append(adminMP3.getImage().getUrl());      --> we don't use it now
        writer.close();
        adminName.clear();
        adminDuration.clear();
        adminYear.clear();
        adminMainInterpreter.clear();
        adminAlbum.clear();
        //adminMP3.setImage(null);      --> we don't use it now
        adminPicture.setImage(null);
    }

    /**
     * This method is used to delete the sounds features in the different lists and we write again the csv with these new lists
     */
    @FXML
    protected void deleteSong() throws IOException {
        String Value = adminName.getText();
        int index = nameList.indexOf(Value);
        FileWriter writer = new FileWriter("data/database/songs_db.csv", false);
        nameList.remove(index);
        albumList.remove(index);
        yearList.remove(index);
        mainInterpreterList.remove(index);
        coverUrlList.remove(index);
        durationList.remove(index);
        adminName.clear();
        adminDuration.clear();
        adminYear.clear();
        adminMainInterpreter.clear();
        adminAlbum.clear();
        //adminMP3.setImage(null);      --> we don't use it now
        adminPicture.setImage(null);
        int i = 0;
        while (i < nameList.size()){
            writer.append("song");
            writer.append(";");
            writer.append(nameList.get(i));
            writer.append(";");
            writer.append(albumList.get(i));
            writer.append(";");
            writer.append(yearList.get(i));
            writer.append(";");
            writer.append(mainInterpreterList.get(i));
            writer.append(";");
            writer.append(coverUrlList.get(i));
            writer.append(";");
            writer.append(durationList.get(i));
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append(""); // --> to replace when using the MP3
            writer.append("\n");
            i ++;

        }
        writer.close();
    }

    /**
     * This method is used to modify the sound features with the news, in the lists and we write again the csv with these new lists.
     */
    @FXML
    protected void modSong() throws IOException {
        String Value = adminName.getText();
        int index = HelloApplication.nameList.indexOf(Value);
        FileWriter writer = new FileWriter("data/database/songs_db.csv", false);
        HelloApplication.albumList.set(index,adminAlbum.getText());
        HelloApplication.yearList.set(index,adminYear.getText());
        HelloApplication.mainInterpreterList.set(index,adminMainInterpreter.getText());
        //take the right path of the url
        String FullURL = adminPicture.getImage().getUrl();
        int Index = FullURL.indexOf("src");
        String URL = FullURL.substring(Index);
        HelloApplication.coverUrlList.set(index,URL);
        HelloApplication.durationList.set(index,adminDuration.getText());
        adminName.clear();
        adminDuration.clear();
        adminYear.clear();
        adminMainInterpreter.clear();
        adminAlbum.clear();
        //adminMP3.setImage(null);      --> we don't use it now
        adminPicture.setImage(null);
        int i = 0;
        while (i < nameList.size()){
            writer.append("song");
            writer.append(";");
            writer.append(HelloApplication.nameList.get(i));
            writer.append(";");
            writer.append(HelloApplication.albumList.get(i));
            writer.append(";");
            writer.append(HelloApplication.yearList.get(i));
            writer.append(";");
            writer.append(HelloApplication.mainInterpreterList.get(i));
            writer.append(";");
            writer.append(HelloApplication.coverUrlList.get(i));
            writer.append(";");
            writer.append(HelloApplication.durationList.get(i));
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");
            writer.append(";");
            writer.append("");// --> to replace when using the MP3MP3
            writer.append("\n");
            i++;
        }
        writer.close();
    }

    /**
     * This method is for switch to scene.
     */
    @FXML
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method is used to search the song in the list and add them to the interface
     */
    @FXML
    public void search(){
        String searchName = adminSearch.getText();
        int index = nameList.indexOf(searchName);
        if (index != -1) {
            adminName.setText(nameList.get(index));
            adminYear.setText(yearList.get(index));
            adminMainInterpreter.setText(mainInterpreterList.get(index));
            adminDuration.setText(durationList.get(index));
            adminAlbum.setText(albumList.get(index));
            // Create the Image object :
            Image image = new Image(new File(coverUrlList.get(index)).toURI().toString());
            adminPicture.setImage(image);
            adminSearch.setText("");
            adminError.setText("");
        } else {
            adminError.setText("Le nom est inexistant");
            adminSearch.setText("");
        }
    }
}

