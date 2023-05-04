package com.sistemasolare;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main extends Application {
    int pressed = 0;
    int selected = 0;
    Selezione_galassie s;

    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load(), 1920, 1080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.centerOnScreen();
        stage.setTitle("Sistema Solare");
        stage.setScene(scene);
        stage.show();

        stage.getScene().setOnKeyPressed(event -> {
            if(event.getCode().toString().equals("ESCAPE"))
                stage.close();
            else {
                switch (pressed) {
                    case 0 -> {
                        Introduzione i = new Introduzione(stage, (Label) stage.getScene().getRoot().lookup("#continua"), (AnchorPane) stage.getScene().getRoot().lookup("#menu"));
                        i.start();
                        pressed++;
                    }
                    case 1 -> {
                        try {
                            s = new Selezione_galassie(stage, (AnchorPane) stage.getScene().getRoot().lookup("#menu"));
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                        s.start();
                        pressed++;
                    }
                    case 2 -> {
                        if (event.getCode().toString().equals("RIGHT")) {
                            s.right();
                        } else if (event.getCode().toString().equals("LEFT")) {
                            s.left();
                        } else if (event.getCode().toString().equals("ENTER")) {
                            selected = s.enter();
                            pressed++;
                        }
                    }
                    case 3 -> {

                    }
                    case 4 -> {
                        Lancio l = new Lancio(stage, (AnchorPane) stage.getScene().getRoot().lookup("#menu"));
                        l.Takeoff();
                        pressed++;
                    }
                    default -> {
                    }
                }

            }
        });
    }



    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        /*if(screenSize.getHeight() != 1080 || screenSize.getWidth() != 1920) {
            System.out.println("La risoluzione dello schermo non è 1920x1080, il programma non si avvierà");
            System.exit(0);
        }*/
        launch();
    }
}