package com.sistemasolare;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

public class Tabella extends Frame {

    JPanel p1 = new JPanel(new GridLayout(11, 7));
    JPanel p2 = new JPanel(new FlowLayout());
    JButton b = new JButton("Continua");

    public Tabella() {
        setTitle("Tabella Pianeti");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLayout(new BorderLayout());
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        p2.setBackground(Color.BLACK);
        p2.add(b);
        p1.setBackground(Color.BLACK);
        p1.setForeground(Color.GREEN);
        p1.add(new Label("Pianeta"));
        p1.add(new Label("Nome"));
        p1.add(new Label("Posizione X"));
        p1.add(new Label("Posizione Y"));
        p1.add(new Label("Grado di Inclinazione"));
        p1.add(new Label("Distanza dall'oggetto"));
        p1.add(new Label("Lune"));
        b.addActionListener(e -> Creation());


        for(int i = 1; i <= 10; i++) {
            p1.add(new Label("Pianeta " + i));
            TextField nomeField = new TextField();
            p1.add(nomeField);
            TextField posXField = new TextField();
            p1.add(posXField);
            TextField posYField = new TextField();
            p1.add(posYField);
            TextField inclinazioneField = new TextField();
            p1.add(inclinazioneField);
            TextField distanzaField = new TextField();
            p1.add(distanzaField);
            Vector<Integer> lune = new Vector<>();

            for(int j = 0; j <= 10; j++) {
                lune.add(j);
            }

            JComboBox<Integer> luneComboBox = new JComboBox<>(lune);
            p1.add(luneComboBox);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }

        });
        setVisible(true);
    }

    public void Creation() {
        int count = 0;
        Component[] components = p1.getComponents();
        for (Component component : components) {
            if (component instanceof TextField textField) {
                if (!textField.getText().isEmpty()) {
                    count++;
                    /*TODO: Creare pianeti con i dati*/
                }
            }
        }
        System.out.println("Numero di TextField di nome riempite: " + count);
        dispose();
    }

    public static void main(String[] args) {
        new Tabella();
    }
}