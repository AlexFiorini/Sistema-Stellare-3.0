package com.sistemasolare;

import javafx.fxml.FXML;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller {
    public AnchorPane menu;
    @FXML
    Label continua;
    public ScaleTransition scaleTransition;

    public void initialize() {
        scaleTransition = new ScaleTransition(Duration.seconds(1), continua);
        scaleTransition.setByX(0.5);
        scaleTransition.setByY(0.5);
        scaleTransition.setCycleCount(100);
        scaleTransition.setAutoReverse(true);
        scaleTransition.play();
    }
}