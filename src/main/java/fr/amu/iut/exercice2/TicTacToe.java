package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Random;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {

        //creation de la grille
        GridPane root = new GridPane();

        //creation de chaque case
        for (int i = 0; i<3; i++){
            for ( int j = 0; j<3; j++){
                Random random = new Random();

                //random pour avoir des grilles aleatoires
                int nombre = random.nextInt(3);
                Label label = new Label();
                if (nombre == 0) {
                    label.setGraphic((new ImageView("exercice2/Croix.png")));
                }
                else if (nombre == 1) {
                    label.setGraphic((new ImageView("exercice2/Rond.png")));
                }
                else {
                    label.setGraphic((new ImageView("exercice2/Vide.png")));
                }

                //bordure des cases
                label.setStyle("-fx-border-color: black");

                root.add(label, j, i);

            }
        }

        Scene scene = new Scene(root);
        primaryStage.setWidth(135);
        primaryStage.setHeight(180);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}

