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
        for(int i=0; i < Stella.getPlanets().length; i++) {
            Stella.getPlanets()[i].setX(this.getWidth() /2);
            Stella.getPlanets()[i].setY((int) (this.getHeight()/2 + Stella.getPlanets()[i].getDistance() + 50 + i*20));
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(this.getWidth()/2-10, this.getHeight()/2-10, 20, 20);
        for(int i=0; i < Stella.getPlanets().length; i++) {
            g.setColor(Stella.getPlanets()[i].getColor());
            g.fillOval(Stella.getPlanets()[i].getX(), Stella.getPlanets()[i].getY(), 20, 20);
            g.setColor(Color.WHITE);
            int orbitDiameter = (int) (Stella.getPlanets()[i].getDistance() + 50) * 2;
            drawCenteredCircle(g, this.getWidth()/2, this.getHeight()/2, orbitDiameter);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (isRunning) {
            isRunning = false;
            startButton.setLabel("Start");
        } else {
            isRunning = true;
            startButton.setLabel("Stop");
            Thread t = new Thread(() -> {
                while (isRunning) {
                    int centerX = getWidth() / 2;
                    int centerY = getHeight() / 2;
                    for(int i=0; i < Stella.getPlanets().length; i++) {
                        if(Stella.getPlanets()[i].getAngle() >= 360) {
                            Stella.getPlanets()[i].setAngle(0);
                        }
                        Stella.getPlanets()[i].setAngle(Stella.getPlanets()[i].getAngle() + 1);
                        double radians = Math.toRadians(Stella.getPlanets()[i].getAngle());
                        int x = (int) (Stella.getPlanets()[i].getDistance() * Math.cos(radians) + Stella.getPlanets()[i].getDistance() * 2);
                        int y = (int) (Stella.getPlanets()[i].getDistance() * Math.sin(radians) + Stella.getPlanets()[i].getDistance() * 2);
                        Stella.getPlanets()[i].setX(centerX + x);
                        Stella.getPlanets()[i].setY(centerY + y);
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

    public void drawCenteredCircle(Graphics g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.drawOval(x,y,r,r);
    }

    public static void main(String[] args) {
        new Sistema_Stellare(new Star());
    }
}