package com.sistemasolare;

import javafx.fxml.FXML;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HelloController {
    @FXML
    Pane menu;
    @FXML
    Label continua;

    //Make label blink
    public void initialize() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(1), continua);
        scaleTransition.setByX(0.5);
        scaleTransition.setByY(0.5);
        scaleTransition.setCycleCount(100);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }
}