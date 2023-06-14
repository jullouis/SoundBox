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
     * Ajout des utilisateurs autorisés au niveau administrateur
     */
    public Login(){
        adminList.add("Noah");
        adminList.add("Julien");
        adminList.add("Nathan");
        adminList.add("Prof");

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
        int i = 0;

        // Pick id and pw in the fields
        id = idField.getText();
        pw = pwField.getText();

        //Look if id is in the userList
        if(HelloApplication.getUserList().contains(id)) {
            System.out.println(id + " " + pw);
            //If id is in userList, compare with is pw
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

            //If pw is correct, accept access
            if (pw.equals(HelloApplication.getUserPasswords().get(i))){
                System.out.println("Access accepted");
                login.setVisible(false);
                register.setVisible(false);
                if (adminList.contains(id)){
                    admin.setVisible(true);
                }
                user.setVisible(true);
            //If pw is not correct, denied access
            }else{
                warningText.setText("Mot de passe incorrect");
                System.out.println("Incorrect password");
            }
        //If id isn't in userList, reject for inexistant account
        }else{
            warningText.setText("Compte inexistant");
            System.out.println("Inexistant account");
        }
    }

    @FXML
    public void onEnter(ActionEvent ae){
        System.out.println("ENTER key pressed") ;
        loginButton();
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
