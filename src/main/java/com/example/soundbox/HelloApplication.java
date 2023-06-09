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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class HelloApplication extends Application {
    static ArrayList<String> nameList = new ArrayList<>();
    static ArrayList<String> yearList = new ArrayList<>();
    static ArrayList<String> mainInterpreterList = new ArrayList<>();
    static ArrayList<String> coverUrlList = new ArrayList<>();
    static ArrayList<String> durationList = new ArrayList<>();
    static ArrayList<String> songList = new ArrayList<>();
    //static ArrayList<String> featList = new ArrayList<>();
    static ArrayList<String> userList = new ArrayList<>();
    static ArrayList<String> userPasswords = new ArrayList<>();



    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 740, 500);
        stage.setTitle("SoundBox limited");
        stage.setScene(scene);
        stage.show();*/

        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 740, 500);
        stage.setTitle("SoundBox limited");
        stage.setScene(scene);
        stage.show();







        // A supprimer
        /*try {

            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }*/

        /*FXMLLoader adminLoader;
        adminLoader = new FXMLLoader(HelloApplication.class.getResource("admin.fxml"));
        Scene adminScene = new Scene(adminLoader.load(), 800, 600);
        stage.setTitle("SoundBox limited");
        stage.setScene(adminScene);
        stage.show();*/
    }


    public HelloApplication() throws FileNotFoundException {

        String csvFile = "data/database/songs_db.csv";
        String delimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] numberColumns = line.split(delimiter); //contrôle le nombre de colonnes entrées

                String[] columns = line.split(delimiter);
                // Ajouter les valeurs de la colonne souhaitée à la liste
                nameList.add(columns[1]); // Modifier l'indice selon la colonne souhaitée
                yearList.add(columns[2]);
                mainInterpreterList.add(columns[3]);
                coverUrlList.add(columns[4]);
                // code modifié car il n'affichait pas le temps remplacée columns.length >= 6 par columns.length >= 7 et le temps est sur la colonne 6 et pas 5
                if (columns.length >= 7 && !columns[5].isEmpty()) {
                    durationList.add(columns[6]);
                }
                if (columns[0].equals("album")){
                        songList.add(columns[6]);
                }

                //songList.add(columns[6]);
                //featList.add(columns[8]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*

        ### Marquer qu'on pourrait faire une base de données pour les utilisateurs avec leurs infos de connexion,
            playlists,...

         */

        // Afficher les valeurs de la liste
            System.out.println(nameList);
            System.out.println(yearList);
            System.out.println(mainInterpreterList);
            System.out.println(coverUrlList);
            System.out.println(durationList);
            System.out.println(songList);
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

        //Ajout des comptes User
        userList.add("Noah");
        userPasswords.add("Noah123");

        userList.add("Julien");
        userPasswords.add("Julien321");

        userList.add("Nathan");
        userPasswords.add("Nathan345");

        userList.add("Demo");
        userPasswords.add("demo");
    }

    public static void main(String[] args) {
        launch();
    }

    //Liste des identifiants et mots de passe
    //C'est clairement pas une version sûre de sécuriser un mot de passe, puisque n'importe qui peut y accéder
    //s'il a accès à ce code. Ils devraient être stockés ailleurs, dans une base de données chiffées
    public static ArrayList<String> getUserList(){
        return userList;
    }
    public static ArrayList<String> getUserPasswords(){
        return userPasswords;
    }

    // Donner la liste nameList pour plus loin
    public static ArrayList<String> getNameList(){ // Donner la liste nameList pour plus loin
        return nameList;
    }
    //ToDo ajouter l'album à la liste ?
    public static ArrayList<String> getYearList(){ // Donner la liste nameList pour plus loin
        return yearList;
    }
    public static ArrayList<String> getMainInterpreterList(){ // Donner la liste nameList pour plus loin
        return mainInterpreterList;
    }

    //public static ArrayList<String> getCoverUrlList(){ // Donner la liste nameList pour plus loin
       // return coverUrlList;
    //}
    public static ArrayList<String> getDurationList(){
        return durationList;
    }

    //public static ArrayList<String> getSongList(){ // Donner la liste nameList pour plus loin
        //return songList;
    //}

    //-------------------------------Main.java-------------------------------------



}