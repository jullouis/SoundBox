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

public class HelloApplication extends Application {
    static ArrayList<String> nameList = new ArrayList<>();
    static ArrayList<String> yearList = new ArrayList<>();
    static ArrayList<String> albumList =new ArrayList<>();
    static ArrayList<String> mainInterpreterList = new ArrayList<>();
    static ArrayList<String> coverUrlList = new ArrayList<>();
    static ArrayList<String> durationList = new ArrayList<>();
    static ArrayList<String> songList = new ArrayList<>();
    static ArrayList<String> userList = new ArrayList<>();
    static ArrayList<String> userPasswords = new ArrayList<>();



    /**
     * Launch application in window
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
         * Reading information from the CSV file
         * Write to corresponding lists
         */
        String csvFile = "data/database/songs_db.csv";
        String delimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] numberColumns = line.split(delimiter);
                String[] columns = line.split(delimiter);
                // Add values of the column in the list
                nameList.add(columns[1]);
                albumList.add(columns[2]);
                yearList.add(columns[3]);
                mainInterpreterList.add(columns[4]);
                coverUrlList.add(columns[5]);

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

        System.out.println(nameList.size());
        System.out.println(albumList.size());
        System.out.println(yearList.size());
        System.out.println(mainInterpreterList.size());
        System.out.println(coverUrlList.size());
        System.out.println(durationList.size());
        System.out.println(songList.size());


        /**
         * Add users to the list of logins and passwords
         *
         * This is clearly not a secure version of password protection, since anyone can access it
         * if they have access to this code. They should be stored elsewhere, in an encrypted database
         * @return
         */

        userList.add("Noah");
        userPasswords.add("Noah123");

        userList.add("Julien");
        userPasswords.add("Julien321");

        userList.add("Nathan");
        userPasswords.add("Nathan345");

        userList.add("Prof");
        userPasswords.add("Informatic");

        userList.add("Demo");
        userPasswords.add("demo");

        userList.add("User");
        userPasswords.add("hes");
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * The following two methods return lists of users and their passwords
     * created in this class, so that they can be used in the Login class.
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
     * The following methods return the lists created by reading the CSV file
     * file used as our database
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