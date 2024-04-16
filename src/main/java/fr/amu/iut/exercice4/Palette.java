package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private int vert = 0;
    private int rouge = 0;
    private int bleu = 0;

    private Button vertBtn;
    private Button rougeBtn;
    private Button bleuBtn;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;


    @Override
    public void start(Stage primaryStage) throws Exception {

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);

        root = new BorderPane();

        //label haut
        label = new Label("");
        label.setStyle("-fx-font-size: 2em");
        HBox hBoxHaut = new HBox();
        hBoxHaut.getChildren().add(label);
        hBoxHaut.setAlignment(Pos.CENTER);
        root.setTop(hBoxHaut);

        //couleur du milieu
        panneau = new Pane();
        panneau.setStyle("-fx-background-color: white");
        root.setCenter(panneau);


        //boutton de couleur
        bas = new HBox();
        vertBtn = new Button("Vert");
        rougeBtn = new Button("Rouge");
        bleuBtn = new Button("Bleu");

        vertBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, vertEvent -> {
            vert += 10;
            nbVert+=1;
            label.setText("Vert cliqué " + nbVert + " fois");
            panneau.setStyle("-fx-background-color: rgb("+rouge+","+vert+","+bleu+")");
        });

        rougeBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, vertEvent -> {
            rouge += 10;
            nbRouge+=1;
            label.setText("Rouge cliqué " + nbRouge + " fois");
            panneau.setStyle("-fx-background-color: rgb("+rouge+","+vert+","+bleu+")");
        });

        bleuBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, vertEvent -> {
            bleu += 10;
            nbBleu+=1;
            label.setText("Bleu cliqué " + nbBleu + " fois");
            panneau.setStyle("-fx-background-color: rgb("+rouge+","+vert+","+bleu+")");
        });


        bas.getChildren().addAll(vertBtn, rougeBtn, bleuBtn);
        bas.setAlignment(Pos.CENTER);
        bas.setSpacing(10);
        root.setBottom(bas);

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

