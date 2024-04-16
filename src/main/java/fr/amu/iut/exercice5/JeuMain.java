package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        Obstacle obstacle = new Obstacle(10*Personnage.LARGEUR_PERSONNAGE, 5*Personnage.LARGEUR_PERSONNAGE);
        obstacle.setLayoutX(30*10);
        obstacle.setLayoutY(10*10);
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().add(obstacle);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome, obstacle);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2, Obstacle obstacle) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double positionIniXJ1 = j1.getLayoutX();
            double positionIniYJ1 = j1.getLayoutY();
            double positionIniXJ2 = j2.getLayoutX();
            double positionIniYJ2 = j2.getLayoutY();

            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;

                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;

            }
            if (j1.estEnCollision(j2)){
                j1.setLayoutX(0);
                j1.setLayoutY(0);
                j2.setLayoutX(20 * 10);
                j2.setLayoutY(0);
                finJeu();
            }

            else if ( j1.obstacleCollision(obstacle)){
                j1.setLayoutX(positionIniXJ1);
                j1.setLayoutY(positionIniYJ1);
            }
            else if ( j2.obstacleCollision(obstacle)){
                j2.setLayoutX(positionIniXJ2);
                j2.setLayoutY(positionIniYJ2);
            }
        });
    }

    private void finJeu(){
        Stage finStage = new Stage();
        VBox vBox = new VBox();
        Label finLabel = new Label("PERDU");
        Button btn = new Button("RECOMMENCER pour 1€");
        btn.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            finStage.close();
        });

        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(finLabel, btn);
        vBox.setSpacing(15);

        Scene scene = new Scene(vBox, 200, 100);
        finStage.setScene(scene);
        finStage.show();
    }


}
