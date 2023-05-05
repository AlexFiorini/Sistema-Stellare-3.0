package com.sistemasolare;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.MalformedURLException;

public class Main extends Application {
    int pressed = 0;
    int selected = 0;
    Selezione_galassie s;

    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Schermata.fxml"));
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
                        Lancio l = new Lancio(stage);
                        l.Takeoff();
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        pressed++;
                    }
                    case 4 -> {
                        stage.close();
                        for(int i = 0; i < selected; i++) {
                            Tabella t = new Tabella();
                        }
                        pressed++;
                    }
                    case 5 -> {
                        Sistema_Solare ss = new Sistema_Solare();
                    }

                    default -> {
                    }
                }

            }
        });
    }



    public static void main(String[] args) {
        launch();
    }
}
