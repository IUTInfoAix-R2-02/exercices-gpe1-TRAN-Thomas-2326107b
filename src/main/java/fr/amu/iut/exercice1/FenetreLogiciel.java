package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // code de l'exercice 1
        BorderPane root = new BorderPane();
        //separateur
        Separator separatorV = new Separator(Orientation.VERTICAL);
        Separator separatorH = new Separator(Orientation.HORIZONTAL);

        //partie haut
        //menu1
        Menu menu1 = new Menu("File");
        MenuItem item1M1 = new MenuItem("New");
        MenuItem item2M1 = new MenuItem("Open");
        MenuItem item3M1 = new MenuItem("Save");
        MenuItem item4M1 = new MenuItem("Close");
        menu1.getItems().addAll(item1M1, item2M1, item3M1, item4M1);
        //menu2
        Menu menu2 = new Menu("Edit");
        MenuItem item1M2 = new MenuItem("Cut");
        MenuItem item2M2 = new MenuItem("Copy");
        MenuItem item3M2 = new MenuItem("Paste");
        menu2.getItems().addAll(item1M2, item2M2, item3M2);
        //menu3
        Menu menu3 = new Menu("Help");

        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        root.setTop(menuBar);


        //partie gauche
        VBox boxGauche = new VBox();
        Label bouton = new Label("Boutons :");
        Button bouton1 = new Button("Bouton 1");
        Button bouton2 = new Button("Bouton 2");
        Button bouton3 = new Button("Bouton 3");
        boxGauche.getChildren().addAll(bouton, bouton1, bouton2, bouton3);
        boxGauche.setAlignment(Pos.CENTER);
        boxGauche.setSpacing(10);
        HBox hBoxGauche = new HBox();
        hBoxGauche.getChildren().addAll(boxGauche, separatorV);
        root.setLeft(hBoxGauche);


        //partie milieu
        VBox vBoxMilieu = new VBox();
        GridPane boxMilieu = new GridPane();
        Label name = new Label("Name:");
        TextField nameText = new TextField();
        boxMilieu.add(name,0,0);
        boxMilieu.add(nameText,1,0);

        Label email = new Label("Email:");
        TextField emailText = new TextField();
        boxMilieu.add(email,0,1);
        boxMilieu.add(emailText,1,1);

        Label password = new Label("Password:");
        TextField passwordText = new TextField();
        boxMilieu.add(password,0,2);
        boxMilieu.add(passwordText,1,2);
        boxMilieu.setHgap(10);
        boxMilieu.setVgap(10);

        HBox hBoxBoutonMilieu = new HBox();
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        hBoxBoutonMilieu.getChildren().addAll(submit,cancel);
        hBoxBoutonMilieu.setSpacing(10);
        hBoxBoutonMilieu.setAlignment(Pos.CENTER);

        vBoxMilieu.getChildren().addAll(boxMilieu, hBoxBoutonMilieu);
        vBoxMilieu.setSpacing(10);
        vBoxMilieu.setAlignment(Pos.CENTER);


        HBox hBoxMilieu = new HBox();
        hBoxMilieu.getChildren().addAll(vBoxMilieu);
        hBoxMilieu.setAlignment(Pos.CENTER);
        root.setCenter(hBoxMilieu);



        //partie bas
        VBox vBoxBas = new VBox();
        Label bas = new Label("Ceci est un label de bas de page");
        vBoxBas.getChildren().addAll(separatorH, bas);
        vBoxBas.setAlignment(Pos.CENTER);
        root.setBottom(vBoxBas);



        Scene scene = new Scene(root);
        primaryStage.setHeight(435);
        primaryStage.setWidth(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

