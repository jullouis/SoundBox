package com.example.soundbox;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class HelloApplication extends Application {
    static ArrayList<String> nameList = new ArrayList<>();
    static ArrayList<String> yearList = new ArrayList<>();
    static ArrayList<String> albumList =new ArrayList<>();
    static ArrayList<String> mainInterpreterList = new ArrayList<>();
    static ArrayList<String> coverUrlList = new ArrayList<>();
    static ArrayList<String> durationList = new ArrayList<>();
    static ArrayList<String> songList = new ArrayList<>();
    //static ArrayList<String> featList = new ArrayList<>();
    static ArrayList<String> userList = new ArrayList<>();
    static ArrayList<String> userPasswords = new ArrayList<>();



    /**
     * Lancement de l'application dans la fenêtre
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 716, 477);
        stage.setTitle("SoundBox limited");
        stage.setScene(scene);
        stage.show();
    }


    public HelloApplication() throws FileNotFoundException {

        /**
         * Lecture des informations dans le fichier CSV
         * Ecriture dans les listes correspondant
         */
        String csvFile = "data/database/songs_db.csv";
        String delimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] numberColumns = line.split(delimiter); //contrôle le nombre de colonnes entrées

                String[] columns = line.split(delimiter);
                // Ajouter les valeurs de la colonne souhaitée à la liste
                nameList.add(columns[1]); // Modifier l'indice selon la colonne souhaitée
                albumList.add(columns[2]);
                yearList.add(columns[3]);
                mainInterpreterList.add(columns[4]);
                coverUrlList.add(columns[5]);
                // code modifié car il n'affichait pas le temps remplacée columns.length >= 6 par columns.length >= 7 et le temps est sur la colonne 6 et pas 5
                if (columns.length >= 7 && !columns[5].isEmpty()) {
                    durationList.add(columns[6]);
                }
                if (columns[0].equals("album")){
                        songList.add(columns[6]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(nameList);
        System.out.println(albumList);
        System.out.println(yearList);
        System.out.println(mainInterpreterList);
        System.out.println(coverUrlList);
        System.out.println(durationList);
        System.out.println(songList);

        /**
         * Ajout des utilisateurs dans les liste des identifiants et mots de passe
         *
         * C'est clairement pas une version sûre de sécuriser un mot de passe, puisque n'importe qui peut y accéder
         * s'il a accès à ce code. Ils devraient être stockés ailleurs, dans une base de données chiffées
         * @return
         */

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

    /**
     * Les deux méthodes suivantes permettent de retourner les listes d'utilisateurs et leurs mots de passes
     * créés dans cette classe afin de pouvoir les utiliser dans la classe Login
     *
     * @return userList
     * @return passwordList
     */
    public static ArrayList<String> getUserList(){
        return userList;
    }
    public static ArrayList<String> getUserPasswords(){
        return userPasswords;
    }

    /**
     * Les méthodes suivantes permettent de retourner les liste créées par la lecture du fichier CSV
     * nous servant de base de données
     *
     * @return nameList
     * @return albumList
     * @return yearList
     * @return mainInterpreterList
     * @return durationList
     */
    public static ArrayList<String> getNameList(){
        return nameList;
    }
    public static ArrayList<String> getAlbumList(){
        return albumList;
    }
    public static ArrayList<String> getYearList(){
        return yearList;
    }
    public static ArrayList<String> getMainInterpreterList(){
        return mainInterpreterList;
    }
    public static ArrayList<String> getDurationList(){
        return durationList;
    }
}