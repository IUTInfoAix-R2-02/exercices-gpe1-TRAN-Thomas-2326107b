package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.FloatBinding;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ConvertisseurTemperatures extends Application {
    private static DoubleBinding bindC;
    private static DoubleBinding bindF;

    @Override
    public void start(Stage primaryStage) {
        VBox panneauCelsius = new VBox(30);

        Label C = new Label("°C");

        Slider sliderC = new Slider(0, 100, 0);
        sliderC.setShowTickMarks(true);
        sliderC.setShowTickLabels(true);
        sliderC.setMajorTickUnit(10);
        sliderC.setBlockIncrement(10);
        sliderC.setOrientation(Orientation.VERTICAL);
        sliderC.setMinHeight(450);

        TextField textC = new TextField();
        textC.setMaxWidth(60);

        panneauCelsius.getChildren().addAll(C, sliderC, textC);


        VBox panneauFahrenheit = new VBox(30);

        Label F = new Label("°F");

        Slider sliderF = new Slider(0, 212, 32);
        sliderF.setShowTickMarks(true);
        sliderF.setShowTickLabels(true);
        sliderF.setMajorTickUnit(10);
        sliderF.setOrientation(Orientation.VERTICAL);
        sliderF.setMinHeight(450);

        TextField textF = new TextField();
        textF.setMaxWidth(60);

        panneauFahrenheit.getChildren().addAll(F, sliderF,textF);

        sliderC.valueProperty().addListener(((observableValue, oldV, newV) -> sliderF.setValue(newV.doubleValue() * 9/5 + 32) ));
        sliderF.valueProperty().addListener(((observableValue, oldV, newV) -> sliderC.setValue((newV.doubleValue() - 32) * 5/9 )));

        Bindings.bindBidirectional(textC.textProperty(), sliderC.valueProperty(), new NumberStringConverter());
        Bindings.bindBidirectional(textF.textProperty(), sliderF.valueProperty(), new NumberStringConverter());
        

        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }





}