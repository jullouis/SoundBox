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
    }
    public HelloApplication() throws FileNotFoundException {

        String csvFile = "data/database/Database.csv";
        String delimiter = ";";
        List<String> albumList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(delimiter);
                // Ajouter les valeurs de la colonne souhaitée à la liste
                albumList.add(columns[0]); // Modifier l'indice selon la colonne souhaitée
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Afficher les valeurs de la liste
        for (String album : albumList) {
            System.out.println(album);
        }
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
        System.out.println(albumList);
    }

    public static void main(String[] args) {
        launch();
    }
}