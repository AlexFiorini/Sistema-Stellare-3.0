package com.sistemasolare;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Lancio {

    private final Stage stage;
    private final AnchorPane root;

    Lancio(Stage stage, AnchorPane menu) {
        this.stage = stage;
        this.root = menu;
    }

    public void Takeoff(){
        String foto = "https://www.mieleriamoltoni.it/wp-content/uploads/2016/06/placeholder.jpg";
        stage.getScene().getRoot().setStyle("-fx-background-image: url('" + foto + "') ;");
        Rectangle r = new Rectangle(stage.getHeight()/2, stage.getWidth()/2, stage.getHeight()/2+50, stage.getWidth()/2+50);
        r.setFill(Color.TRANSPARENT);
        root.getChildren().add(r);
    }
}
