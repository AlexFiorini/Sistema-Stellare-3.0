package com.sistemasolare;

import com.sistemasolare.objects.Star;
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
    Star[] stelle;
    boolean first = true;
    Sistema_Stellare[] ss;

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
                            Lancio l = new Lancio(stage);
                            l.Takeoff();
                            pressed++;
                        }
                    }
                    case 3 -> {
                        if(first) {
                            stage.close();
                            stelle = new Star[selected];
                            ss = new Sistema_Stellare[selected];
                            for(int i = 0; i < selected; i++) {
                                int j = i;
                                Tabella t = new Tabella(stella -> stelle[j] = stella);
                            }
                            while(stelle[0] == null) {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            ss[0] = new Sistema_Stellare(stelle[0]);
                        } else {
                            if(event.getCode().toString().equals("1")) {
                                dispose();
                                ss[0] = new Sistema_Stellare(stelle[0]);
                            } else if (event.getCode().toString().equals("2")) {
                                dispose();
                                ss[1] = new Sistema_Stellare(stelle[1]);
                            } else if (event.getCode().toString().equals("3")) {
                                dispose();
                                ss[2] = new Sistema_Stellare(stelle[2]);
                            }
                        }
                    }

                    default -> {
                    }
                }

            }
        });
    }

    public void dispose() {
        for(int i = 0; i < 3; i++) {
            if(ss[i] != null) {
                ss[i].dispose();
                ss[i] = null;
                break;
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
