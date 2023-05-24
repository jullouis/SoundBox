package com.example.soundbox;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Scanner;
public class HelloController {
    ArrayList<String> albumlist = new ArrayList<>();
    ArrayList<String> songlist = new ArrayList<>();
    ArrayList<String> interpreterlist = new ArrayList<>();
    public HelloController () {
        albumlist.add("A Head Full of Dreams");
        albumlist.add("Ghost Stories");
        albumlist.add("Parachutes");
        albumlist.add("Mylo Xyloto");
        albumlist.add("X&Y");
        songlist.add("One More time");
        songlist.add("Red Flag");
        songlist.add("StarLight");
        songlist.add("In the End");
        songlist.add("In Too Deep");
        interpreterlist.add("Linkin Park");
        interpreterlist.add("Cold Play");
        interpreterlist.add("DaftPunk");
        interpreterlist.add("AC/DC");
        interpreterlist.add("Hardwell");
        interpreterlist.add("Eminem");
    }


    /**
     * Create a method to researchAlbum
     * User can entry a song with Scanner
     * Test with an ArrayList
     * Use Try/Catch if the user write something that doesn't exist in the data base
     */
    @FXML
    public void researchSong(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entry a Song : ");
        String searchSong = scanner.nextLine();

            try {
                boolean songExists = false;

                for (String song : albumlist) {
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entry an album : ");
        String searchAlbum = scanner.nextLine();

        try {
            boolean songExists = false;

            for (String song : songlist) {
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

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entry an Interpreter : ");
        String searchAlbum = scanner.nextLine();

        try {
            boolean songExists = false;

            for (String song :  albumlist) {
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
    @FXML
    public void createPlaylist() {
    }
    @FXML
    public void addSongPlaylist() {
    }
    @FXML
    public void deleteSongPlaylist() {

    }
    }