package com.sistemastellare;

import com.sistemastellare.objects.Moon;
import com.sistemastellare.objects.Planet;
import com.sistemastellare.objects.Star;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.function.Consumer;
import javax.swing.*;

public class Tabella extends Frame {

    JPanel p1 = new JPanel(new GridLayout(11, 5));
    JPanel p2 = new JPanel(new FlowLayout());
    JButton b = new JButton("Continua");
    Star stella;
    Planet[] pianeti;
    int centerx, centery;

    public Tabella(Consumer < Star > consumer) {
        setTitle("Tabella Pianeti");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        p2.setBackground(Color.BLACK);
        p2.add(b);
        p1.setBackground(Color.BLACK);
        p1.setForeground(Color.GREEN);
        p1.add(new Label("Pianeta"));
        p1.add(new Label("Nome"));
        p1.add(new Label("Grado di Inclinazione"));
        p1.add(new Label("Distanza dalla stella"));
        p1.add(new Label("Lune"));
        b.addActionListener(e -> {
            stella = Creation();
            consumer.accept(stella);
        });

        centerx = getWidth() / 2;
        centery = getHeight() / 2;

        for (int i = 1; i <= 10; i++) {
            p1.add(new Label("Pianeta " + i));
            TextField nomeField = new TextField();
            p1.add(nomeField);
            TextField inclinazioneField = new TextField();
            p1.add(inclinazioneField);
            TextField distanzaField = new TextField();
            p1.add(distanzaField);
            Vector < Integer > lune = new Vector < > ();

            for (int j = 0; j <= 10; j++) {
                lune.add(j);
            }

            JComboBox < Integer > luneComboBox = new JComboBox < > (lune);
            p1.add(luneComboBox);
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
        setVisible(true);
    }

    public Star Creation() {
        int count = 0;
        Component[] components = p1.getComponents();
        for (int i = 0; i < components.length; i++) {
            Component component = components[i];
            if (component instanceof TextField textField) {
                if (!textField.getText().isEmpty()) {
                    count++;
                    i += 3;
                }
            }
        }
        pianeti = new Planet[count];
        count = 0;
        components = p1.getComponents();
        for (int i = 0; i < components.length; i++) {
            Component component = components[i];
            if (component instanceof TextField textField) {
                if (!textField.getText().isEmpty()) {
                    String nome = textField.getText();
                    TextField inclinazioneField = (TextField) components[i + 1];
                    int inclinazione = Integer.parseInt(inclinazioneField.getText());
                    TextField distanzaField = (TextField) components[i + 2];
                    double distanza = Double.parseDouble(distanzaField.getText());
                    @SuppressWarnings("unchecked")
                    JComboBox < Integer > luneComboBox = (JComboBox < Integer > ) components[i + 3];
                    Integer selectedItem = (Integer) luneComboBox.getSelectedItem();
                    int lune = selectedItem != null ? selectedItem : 0; /* se selectedItem è null, allora lune == 0 */
                    Moon[] moon = new Moon[lune];
                    for (int j = 0; j < lune; j++) {
                        moon[j] = new Moon(Math.random() % 10, (int)(Math.random() * 360), centerx, centery);
                    }
                    pianeti[count] = new Planet(moon, distanza, inclinazione, Math.random() * 3000, nome, centerx, centery);
                    count++;
                    i += 3;
                }
            }
        }
        stella = new Star(pianeti, Math.random() * 30000);
        dispose();
        return stella;
    }
}