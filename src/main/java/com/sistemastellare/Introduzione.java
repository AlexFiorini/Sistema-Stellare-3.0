package com.sistemastellare;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Introduzione {
    private final Stage stage;
    private final Label label;
    private final AnchorPane root;

    Introduzione(Stage stage, Label label, AnchorPane menu) {
        this.stage = stage;
        this.label = label;
        this.root = menu;
    }

    public void start() {
        String foto = "https://shorturl.at/asFGY";
        stage.getScene().getRoot().setStyle("-fx-background-image: url('" + foto + "');");
        root.getChildren().remove(label);
    }
}
