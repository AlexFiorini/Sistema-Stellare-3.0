package com.sistemasolare;

import javafx.stage.Stage;

public class Lancio {

    private final Stage stage;

    Lancio(Stage stage) {
        this.stage = stage;
    }

    public void Takeoff(){
        String foto = "https://shorturl.at/sNOSY";
        stage.getScene().getRoot().setStyle("-fx-background-image: url('" + foto + "') ;");
    }
}
