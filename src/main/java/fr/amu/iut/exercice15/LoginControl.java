package fr.amu.iut.exercice15;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    public void initialize(){
        createBindings();
    }

    private static BooleanBinding id6Carac;
    private static BooleanProperty bon;

    private void createBindings() {
        bon = new SimpleBooleanProperty();

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
        bon.bind(id6Carac);
        pwd.editableProperty().bind(bon);
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