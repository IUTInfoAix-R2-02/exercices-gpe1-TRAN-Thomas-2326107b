package fr.amu.iut.exercice15;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button okBtn;

    @FXML
    public void initialize(){
        createBindings();
    }

    private static BooleanBinding id6Carac;
    private static BooleanBinding mdp8Carac;
    private static BooleanBinding cancelVide;


    private void createBindings() {

        id6Carac = new BooleanBinding() {
            {
                this.bind(userId.textProperty());
            }
            @Override
            protected boolean computeValue() {
                if (userId.getLength() < 6){
                    return false;
                }
                return true;
            }
        };
        pwd.editableProperty().bind(id6Carac);

        cancelVide = new BooleanBinding() {
            {
                this.bind(userId.textProperty(), pwd.textProperty());
            }
            @Override
            protected boolean computeValue() {
                if (userId.getLength() != 0 || pwd.getLength() != 0){
                    return false;
                }
                return true;
            }
        };
        cancelBtn.disableProperty().bind(cancelVide);


        mdp8Carac = new BooleanBinding() {
            {
                this.bind(pwd.textProperty());
            }
            @Override
            protected boolean computeValue() {
                if (pwd.getLength() > 8 ){
                    boolean maj = false;
                    boolean chiffre = false;
                    for (int i = 0; i<=pwd.getLength();++i){
                        if (pwd.getText().charAt(i) >= 65 && pwd.getText().charAt(i) <= 90){
                            maj = true;
                        }
                        if (pwd.getText().charAt(i) >= 48 && pwd.getText().charAt(i) <= 57){
                            chiffre = true;
                        }
                        if (maj && chiffre){
                            return false;
                        }
                    }
                }
                return true;
            }
        };
        okBtn.disableProperty().bind(mdp8Carac);

    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}