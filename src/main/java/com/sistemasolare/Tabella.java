package com.sistemasolare;

import java.awt.*;

import java.awt.event.*;

import java.util.Vector;

import javax.swing.*;

public class Tabella extends Frame {

    public Tabella() {

        setTitle("Tabella Pianeti");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setLayout(new GridLayout(11, 7));
        setBackground(Color.BLACK);
        setForeground(Color.GREEN);
        add(new Label("Pianeta"));
        add(new Label("Nome"));
        add(new Label("Posizione X"));
        add(new Label("Posizione Y"));
        add(new Label("Grado di Inclinazione"));
        add(new Label("Distanza dall'oggetto"));
        add(new Label("Lune"));

        for(int i = 1; i <= 10; i++) {
            add(new Label("Pianeta " + i));
            TextField nomeField = new TextField();
            add(nomeField);
            TextField posXField = new TextField();
            add(posXField);
            TextField posYField = new TextField();
            add(posYField);
            TextField inclinazioneField = new TextField();
            add(inclinazioneField);
            TextField distanzaField = new TextField();
            add(distanzaField);
            Vector<Integer> lune = new Vector<>();

            for(int j = 0; j <= 10; j++) {
                lune.add(j);
            }

            JComboBox<Integer> luneComboBox = new JComboBox<>(lune);
            add(luneComboBox);

        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }

        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tabella();
    }
}