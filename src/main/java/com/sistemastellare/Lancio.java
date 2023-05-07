package com.sistemastellare;

import javafx.stage.Stage;

public class Lancio {

    private final Stage stage;

    Lancio(Stage stage) {
        this.stage = stage;
    }

    public void Takeoff() {
        String foto = "https://shorturl.at/fgI06";
        stage.getScene().getRoot().setStyle("-fx-background-image: url('" + foto + "');");
    }
}