package com.sistemastellare;

import com.sistemastellare.objects.Planet;

import javax.swing.*;
import java.awt.*;

class PlanetInfoDialog extends JDialog {
    private final JLabel nome;
    private final JLabel distanza;
    private final JLabel angolo;
    private final JLabel lune;
    private final JLabel massa;
    private final JLabel x = new JLabel();
    private final JLabel y = new JLabel();


    public PlanetInfoDialog(Planet planet) {
        super((Frame) null, true);
        setTitle("Informazioni sul pianeta");
        setLayout(new GridLayout(7, 1));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 140);
        setResizable(false);

        nome = new JLabel(getNome(planet));
        distanza = new JLabel(getDistanza(planet));
        angolo = new JLabel(getAngolo(planet));
        lune = new JLabel(getLune(planet));
        massa = new JLabel(getMassa(planet));
        add(nome);
        add(massa);
        add(distanza);
        add(angolo);
        add(x);
        add(y);
        add(lune);

        Timer timer = new Timer(10, e -> {
            nome.setText(getNome(planet));
            distanza.setText(getDistanza(planet));
            angolo.setText(getAngolo(planet));
            lune.setText(getLune(planet));
            massa.setText(getMassa(planet));
            x.setText(getX(planet));
            y.setText(getY(planet));
        });
        timer.start();
    }

    private String getNome(Planet planet) {
        return "Nome del pianeta: " + planet.getName();
    }

    private String getDistanza(Planet planet) {
        return "Distanza dalla stella: " + planet.getDistance();
    }

    private String getAngolo(Planet planet) {
        return "Angolo rispetto alla stella: " + planet.getAngle()%360;
    }

    private String getLune(Planet planet) {
        return "Numero di lune: " + planet.getMoons().length;
    }

    private String getMassa(Planet planet) {
        return "Massa: " + planet.getMass();
    }

    private String getX(Planet planet) {
        return "X: " + planet.getX();
    }

    private String getY(Planet planet) {
        return "Y: " + planet.getY();
    }
}