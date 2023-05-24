package com.example.soundbox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Scanner;
public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to SoundBox");
    }

    /**
     * Create a method to researchAlbum
     * User can entry a song with Scanner
     * Test with an ArrayList
     * Use Try/Catch if the user write something that doesn't exist in the data base
     */
    @FXML
    public void researchSong(){
            ArrayList<String> playlist = new ArrayList<>();
            playlist.add("One More time");
            playlist.add("Red Flag");
            playlist.add("StarLight");
            playlist.add("In the End");
            playlist.add("In Too Deep");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entry a Song : ");
        String searchSong = scanner.nextLine();

            try {
                boolean songExists = false;

                for (String song : playlist) {
                    if (song.equalsIgnoreCase(searchSong)) {
                        songExists = true;
                        break;
                    }
                }

                if (songExists) {
                    System.out.println(searchSong);
                } else {
                    throw new Exception("The Song " + searchSong + " doesn't exist");
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    /**
     * Create a method to researchAlbum
     * User can entry an album name with Scanner
     * Test with an ArrayList
     * Use Try/Catch if the user write something that doesn't exist in the database
     */
    @FXML
    public void researchAlbum(){
        ArrayList<String> Album = new ArrayList<>();
        Album.add("A Head Full of Dreams");
        Album.add("Ghost Stories");
        Album.add("Parachutes");
        Album.add("Mylo Xyloto");
        Album.add("X&Y");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entry an album : ");
        String searchAlbum = scanner.nextLine();

        try {
            boolean songExists = false;

            for (String song : Album) {
                if (song.equalsIgnoreCase(searchAlbum)) {
                    songExists = true;
                    break;
                }
            }

            if (songExists) {
                System.out.println(searchAlbum);
            } else {
                throw new Exception("Album " + searchAlbum + " doesn't exist");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Create a method to researchInterpreterm
     * User can entry an Interpreter with Scanner
     * Test with an ArrayList
     * Use Try/Catch if the user write something that doesn't exist in the database
     */
    @FXML
    public void researchInterpreter(){
        ArrayList<String> Interpreter = new ArrayList<>();
        Interpreter.add("Linkin Park");
        Interpreter.add("Cold Play");
        Interpreter.add("DaftPunk");
        Interpreter.add("AC/DC");
        Interpreter.add("Hardwell");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entry an Interpreter : ");
        String searchAlbum = scanner.nextLine();

        try {
            boolean songExists = false;

            for (String song : Interpreter) {
                if (song.equalsIgnoreCase(searchAlbum)) {
                    songExists = true;
                    break;
                }
            }

            if (songExists) {
                System.out.println(searchAlbum);
            } else {
                throw new Exception("Interpreter " + searchAlbum + " doesn't exist");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    }