package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    private String mdp= "";
    @FXML
    private TextField utilisateur;
    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        System.out.print(utilisateur.getText());

        for (int i = 0 ; i<pwd.getText().length(); ++i){
            mdp += "*";
        }
        System.out.println(" " + mdp);
    }
    @FXML
    private void cancelClicked() {
        utilisateur.clear();
        pwd.clear();
    }
}