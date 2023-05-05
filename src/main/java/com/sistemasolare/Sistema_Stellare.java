package com.sistemasolare;

import com.sistemasolare.objects.Star;

import java.awt.*;
import java.awt.event.*;

public class Sistema_Stellare extends Frame implements ActionListener {
    private Star Stella;
    private Button startButton;
    private boolean isRunning = false;

    Sistema_Stellare(Star Stella) {
        super("Sistema Solare");
        this.Stella = Stella;
        CreateFrame();
    }

    private void CreateFrame() {
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        startButton = new Button("Start");
        startButton.setBounds(50, 50, 80, 30);
        startButton.addActionListener(this);
        add(startButton);
        setVisible(true);
    }

    public void paint(Graphics g) {
        for(int i=0; i < Stella.getPlanets().length; i++) {
            g.setColor(new Color((int)(Math.random() * 0x1000000)));
            g.fillOval((int) Stella.getPlanets()[i].getX(), (int) Stella.getPlanets()[i].getY(), 20, 20);
        }
    }

    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new Sistema_Stellare(new Star());
    }
}