package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {
    private int vies = 7;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Dico dico = new Dico();
        VBox root = new VBox();
        Label vie = new Label("Nombre de vies " + vies);
        String mot = dico.getMot();
        Label motCache = new Label(dico.getMot());

        Button a = new Button("a");
        a.addEventHandler(MouseEvent.MOUSE_CLICKED, aEvent -> {
            if (dico.getPositions('a', mot).isEmpty()) {
                vies -= 1;
                vie.setText("Nombre de vies " + vies);
            }
        });


        root.getChildren().addAll(vie, motCache, a);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
