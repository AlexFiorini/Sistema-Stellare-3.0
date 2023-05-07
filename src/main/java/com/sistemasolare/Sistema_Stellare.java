package com.sistemasolare;

import com.sistemasolare.objects.Star;

import java.awt.*;
import java.awt.event.*;

public class Sistema_Stellare extends Frame implements ActionListener {
    private final Star Stella;
    private boolean isRunning = false;
    private final Button startButton = new Button("Start");

    Sistema_Stellare(Star Stella) {
        super("Sistema Solare");
        this.Stella = Stella;
        CreateFrame();
    }

    private void CreateFrame() {
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLayout(null);
        setBackground(Color.BLACK);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        startButton.setBounds(50, 50, 80, 30);
        startButton.addActionListener(this);
        add(startButton);
        setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        int dim = 20;
        g.fillOval(this.getWidth()/2- dim /2, this.getHeight()/2- dim /2, dim, dim);
        for(int i=0; i < Stella.getPlanets().length; i++) {
            g.setColor(Stella.getPlanets()[i].getColor());
            g.fillOval(Stella.getPlanets()[i].getX(), Stella.getPlanets()[i].getY(), dim, dim);
            for(int j=0; j<Stella.getPlanets()[i].getMoons().length; j++) {
                g.setColor(Color.WHITE);
                g.fillOval(Stella.getPlanets()[i].getMoons()[j].getX(), Stella.getPlanets()[i].getMoons()[j].getY(), 10, 10);
            }

        }
    }


    @SuppressWarnings("BusyWait")
    public void actionPerformed(ActionEvent e) {
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        if (isRunning) {
            isRunning = false;
            startButton.setLabel("Start");
        } else {
            isRunning = true;
            startButton.setLabel("Stop");
            Thread t = new Thread(() -> {
                while (isRunning) {
                    for(int i=0; i < Stella.getPlanets().length; i++) {
                        Stella.getPlanets()[i].Move(centerX, centerY);
                    }
                    repaint();
                   try {
                        Thread.sleep(50);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }

    public void Dispose() {
        dispose();
    }


    public static void main(String[] args) {
        new Sistema_Stellare(new Star());
    }
}