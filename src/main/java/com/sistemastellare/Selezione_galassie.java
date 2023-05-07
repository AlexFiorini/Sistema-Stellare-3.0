package com.sistemastellare;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.net.MalformedURLException;

public class Selezione_galassie {
    private final AnchorPane root;
    private final Stage stage;
    private Rectangle rectangle;

    private int selected;

    Selezione_galassie(Stage stage, AnchorPane menu) throws MalformedURLException {
        this.stage = stage;
        this.root = menu;
    }

    public void start() {
        String foto = "https://shorturl.at/huW47";
        stage.getScene().getRoot().setStyle("-fx-background-image: url('" + foto + "');");
        rectangle = new Rectangle(80, 100, 418, 500);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.WHITE);
        rectangle.setStrokeWidth(10);
        root.getChildren().add(rectangle);
        selected = 1;
    }

    /**
     * Move the selection rectangle to the right
     */
    public void right() {
        switch (selected) {
            case 1 -> {
                selected++;
                rectangle.setX(rectangle.getX() + 480);
            }
            case 2 -> {
                selected++;
                rectangle.setX(rectangle.getX() + 500);
            }
            default -> {}
        }
    }

    /**
     * Move the selection rectangle to the left
     */
    public void left() {
        switch (selected) {
            case 2 -> {
                selected--;
                rectangle.setX(rectangle.getX() - 480);
            }
            case 3 -> {
                selected--;
                rectangle.setX(rectangle.getX() - 500);
            }
            default -> {}
        }
    }

    public int enter() {
        root.getChildren().remove(rectangle);
        return selected;
    }
}