package com.example.soundbox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Login {
    @FXML
    TextField idField;
    @FXML
    PasswordField pwField;
    @FXML
    Button login;
    @FXML
    Button register;
    @FXML
    Button admin;
    @FXML
    Button user;
    @FXML
    Label warningText;


    private Stage stage;
    private Scene scene;
    private Parent root;
    ArrayList<String> adminList = new ArrayList<>();

    /**
     *
     */
    public Login(){
        adminList.add("Noah");
        adminList.add("Julien");
        adminList.add("Nathan");

    }

    /**
     *         //récupérer l'id et le pw dans les champs
     *         //voir si l'id existe
     *         //si oui, comparer au pw
     *         //si pw ok, accepter
     *         //si non, rejeter pour mauvais pw
     *         //si non, rejeter pour compte inexistant
     */
    @FXML
    protected void loginButton(){
        String id;
        String pw;

        //récupérer l'id et le pw dans les champs
        id = idField.getText();
        pw = pwField.getText();
        int i = 0;

        //voir si l'id existe
        if(HelloApplication.getUserList().contains(id)) {
            System.out.println(id + " " + pw);
            //si oui, comparer au pw
            while(i < HelloApplication.getUserList().size()){
                if (id.equals(HelloApplication.getUserList().get(i))){
                    System.out.println(HelloApplication.getUserList().get(i));
                    System.out.println(i);
                    break;
                }else{
                    i++;
                    System.out.println("Searching...");
                }
            }
            //si pw ok, accepter
            if (pw.equals(HelloApplication.getUserPasswords().get(i))){
                System.out.println("Accepté");
                login.setVisible(false);
                register.setVisible(false);
                if (adminList.contains(id)){
                    admin.setVisible(true);
                }
                user.setVisible(true);
            }else{ //si non, rejeter pour mauvais pw
                warningText.setText("Mot de passe incorrect");
                System.out.println("Mot de passe incorrect");
            }
            // si non, rejeter pour compte inexistant
        }else{
            warningText.setText("Compte inexistant");
            System.out.println("Compte inexistant");
        }
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void switchToAdmin(ActionEvent event) throws IOException {
        System.out.println("Trying to switch to Admin...");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("admin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void switchToUser(ActionEvent event) throws IOException {
        System.out.println("Trying to switch to User...");
        Parent root = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
