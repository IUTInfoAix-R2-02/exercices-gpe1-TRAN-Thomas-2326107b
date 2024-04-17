package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IHMPendu extends Application {
    private int vies = 7;
    private Label vie;
    private Label labelMot;
    private Dico dico;
    private String mot;
    private String motCache;
    private Image image;
    private ImageView imageView;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #dafdf7");

        vie = new Label("Nombre de vies " + vies);
        vie.setStyle("-fx-font-weight: bold; -fx-font-size: 20");

        dico = new Dico();
        mot = dico.getMot();
        motCache = "*".repeat(mot.length());
        labelMot = new Label(motCache);
        labelMot.setStyle("-fx-font-weight: bold; -fx-font-size: 20");



        //les boutons

        HBox hbox1 = new HBox();
        hbox1.setAlignment(Pos.CENTER);
        HBox hbox2 = new HBox();
        hbox2.setAlignment(Pos.CENTER);
        HBox hbox3 = new HBox();
        hbox3.setAlignment(Pos.CENTER);
        char[] liste1 = {'a','e','i','o','u','y'};
        char[] liste2 = {'b','c','d','f','g','h','j','k','l','m'};
        char[] liste3 = {'n','p','q','r','s','t','v','w','x','z'};

        for (int i =0; i < liste1.length; ++i) {

            char carac = liste1[i];
            Button btn = new Button(String.valueOf(carac));
            btn.setStyle("-fx-background-color: transparent;" +
                    " -fx-border-color: orange;" +
                    " -fx-border-radius: 10;" +
                    " -fx-border-width: 1.4;" +
                    " -fx-font-size: 20;" +
                    " -fx-text-fill:#5ec9b7");
            btn.setPrefWidth(50);
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, aEvent -> ButtonClickHandler( aEvent, carac, btn));

            hbox1.getChildren().add(btn);
            hbox1.setSpacing(1);
        }

        for (int i =0; i < liste2.length; ++i) {

            char carac = liste2[i];
            Button btn = new Button(String.valueOf(carac));
            btn.setStyle("-fx-background-color: transparent;" +
                    " -fx-border-color: orange;" +
                    " -fx-border-radius: 10;" +
                    " -fx-border-width: 1.4;" +
                    " -fx-font-size: 20;" +
                    " -fx-text-fill:#5ec9b7 ");
            btn.setPrefWidth(50);
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, aEvent -> ButtonClickHandler( aEvent, carac, btn));

            hbox2.getChildren().add(btn);
            hbox2.setSpacing(1);
        }

        for (int i =0; i < liste3.length; ++i) {

            char carac = liste3[i];
            Button btn = new Button(String.valueOf(carac));
            btn.setStyle("-fx-background-color: transparent;" +
                    " -fx-border-color: orange;" +
                    " -fx-border-radius: 10;" +
                    "-fx-border-width: 1.4;" +
                    " -fx-font-size: 20;" +
                    " -fx-text-fill:#5ec9b7");
            btn.setPrefWidth(50);
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, aEvent -> ButtonClickHandler( aEvent, carac, btn));

            hbox3.getChildren().add(btn);
            hbox3.setSpacing(1);
        }

        VBox lettre = new VBox();
        lettre.getChildren().addAll(hbox1, hbox2, hbox3);
        lettre.setSpacing(1);


        //image
        image = new Image(IHMPendu.class.getResource("/exercice6/pendu"+vies+".png").toString());
        imageView = new ImageView();
        imageView.setImage(image);


        //rejouer
        Button rejouer = new Button("Rejouer");


        root.getChildren().addAll(imageView, vie, labelMot, lettre,rejouer);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

    public void ButtonClickHandler(Event event, char c, Button btn){
        if (dico.getPositions(c, mot).isEmpty()) {
            vies -= 1;
            vie.setText("Nombre de vies " + vies);
            if (vies<=0){
                vie.setText("VOUS AVEZ PERDU !");
                labelMot.setText("Le mot etait : " + mot);
            }
            btn.setDisable(true);
            image = new Image(IHMPendu.class.getResource("/exercice6/pendu"+vies+".png").toString());
            imageView.setImage(image);
        }
        else {
            int j=0;
            for (int i= 0; i <motCache.length() ; ++i) {
                if (i == dico.getPositions(c, mot).get(j)){
                    motCache = motCache.substring(0, i) + c + motCache.substring(i+1);
                    labelMot.setText(motCache);
                    ++j;
                    if (j == dico.getPositions(c, mot).size()){
                        break;
                    }
                }
            }
            if (motCache.indexOf('*') == -1){
                vie.setText("VOUS AVEZ GAGNE !");
                image = new Image(IHMPendu.class.getResource("/exercice6/penduWin.png").toString());
                imageView.setImage(image);
            }
            btn.setStyle("-fx-background-color: transparent;" +
                    " -fx-border-color: darkblue;" +
                    " -fx-border-radius: 10;" +
                    " -fx-font-size: 20;" +
                    " -fx-text-fill:#5ec9b7");
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
