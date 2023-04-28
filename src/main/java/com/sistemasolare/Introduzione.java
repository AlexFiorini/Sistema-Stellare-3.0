package com.sistemasolare;

import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Introduzione {
    private final Stage stage;
    private final Label label;

    Introduzione(Stage stage, Label label) {
        this.stage = stage;
        this.label = label;
    }

    public void start() {
        stage.getScene().getRoot().setStyle("-fx-background-image: url('https://lh3.googleusercontent.com/u/2/drive-viewer/AFGJ81rVvJOiD-jU6Z7mhQ8ZQrSwtRj22DL8YieZCgqvMbyPbHBgxsd7Srh7Kln7ciVKOCGyP0SOEJt2WBLRH_393AfWNU2g7Q');");
        label.setVisible(false);

    }
}
