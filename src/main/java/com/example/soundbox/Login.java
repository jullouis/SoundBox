package com.example.soundbox;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
    @FXML
    TextField idField;

    @FXML
    PasswordField pwField;

    @FXML
    protected void loginButton(){
        String id;
        String pw;

        //récupérer l'id et le pw dans les champs
        //voir si l'id existe
        //si oui, comparer au pw
        //si pw ok, accepter
        //si non, rejeter pour mauvais pw
        //si non, rejeter pour compte inexistant


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
            }else{ //si non, rejeter pour mauvais pw
                System.out.println("Mot de passe incorrect");
            }

            // si non, rejeter pour compte inexistant
        }else{
            System.out.println("Compte inexistant");

        }
    }
}
