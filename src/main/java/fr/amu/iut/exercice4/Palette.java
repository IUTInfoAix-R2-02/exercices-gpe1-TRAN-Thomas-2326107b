package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    public void vert(){
        nbVert +=1;
    }
    public void rouge(){
        nbRouge +=1;
    }
    public void bleu(){
        nbVert +=1;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new BorderPane();

        //label haut
        label = new Label("Vert choisi x fois");
        label.setStyle("-fx-font-size: 2em");
        HBox hBoxHaut = new HBox();
        hBoxHaut.getChildren().add(label);
        hBoxHaut.setAlignment(Pos.CENTER);
        root.setTop(hBoxHaut);

        //couleur du milieu
        panneau = new Pane();
        panneau.setStyle("-fx-background-color: black");
        root.setCenter(panneau);


        //boutton de couleur
        bas = new HBox();
        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");


        bas.getChildren().addAll(vert, rouge, bleu);
        bas.setAlignment(Pos.CENTER);
        root.setBottom(bas);


        Scene scene = new Scene(root, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

