package com.example.soundbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("SoundBox limited");
        stage.setScene(scene);
        stage.show();

        FXMLLoader adminLoader;
        adminLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        Scene adminScene = new Scene(adminLoader.load(), 800, 600);
        stage.setTitle("SoundBox limited");
        stage.setScene(adminScene);
        stage.show();
    }
    public HelloApplication() throws FileNotFoundException {

        String csvFile = "data/database/songs_db.csv";
        String delimiter = ";";
        List<String> albumList = new ArrayList<>();
        List<String> yearList = new ArrayList<>();
        List<String> mainInterpreterList = new ArrayList<>();
        List<String> coverUrlList = new ArrayList<>();
        List<String> durationList = new ArrayList<>();
        //List<String> songList = new ArrayList<>();
        //List<String> featList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] numberColumns = line.split(delimiter); //contrôle le nombre de colonnes entrées

                String[] columns = line.split(delimiter);
                // Ajouter les valeurs de la colonne souhaitée à la liste
                albumList.add(columns[1]); // Modifier l'indice selon la colonne souhaitée
                yearList.add(columns[2]);
                mainInterpreterList.add(columns[3]);
                coverUrlList.add(columns[4]);
                if (columns.length >= 6 && !columns[5].isEmpty()) {
                    durationList.add(columns[5]);
                }
                //songList.add(columns[6]);
                //featList.add(columns[8]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Afficher les valeurs de la liste
            System.out.println(albumList);
            System.out.println(yearList);
            System.out.println(mainInterpreterList);
            System.out.println(coverUrlList);
            System.out.println(durationList);
        //System.out.println(songList);
        //System.out.println(featList);

/*

        Scanner sc = new Scanner(new File("data/database/Database.csv"));//créer un nouveau scanner
        ArrayList<String> albumList = new ArrayList<>();//liste ou on stoque tout le contenu du fichier csv
        sc.useDelimiter(";");


//récupération des données du csv (un enplacement de la liste est une ligne du csv car le délimiteur <<sc.useDelimiter(",")>>  n'est pas défini)

        while(sc.hasNext()){
            //albumList.add(sc.next());
            String[] cols = strLine.split(cvsSplitBy);
            albumList.add(cols[4]);



        }
        sc.close();//fermeture du fichier*/
    }

    public static void main(String[] args) {
        launch();
    }
}