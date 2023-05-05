package com.sistemasolare;
import java.awt.*;
import java.awt.event.*;
public class Sistema_Solare extends Frame implements ActionListener {
    private Button startButton;
    private boolean isRunning = false;
    private int angle = 0;
    private int sunX = 300;
    private int sunY = 250;
    private int earthX = 100;
    private int earthY = 100;
    private int marsX = 150;
    private int marsY = 150;
    private int venusX = 200;
    private int venusY = 200;
    private int moonX = earthX + 20;
    private int moonY = earthY;
    public Sistema_Solare() {
        super("Sistema Solare");
        setSize(600, 500);
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
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 500);
        g.setColor(Color.YELLOW);
        g.fillOval(sunX, sunY, 50, 50);
        g.setColor(Color.BLUE);
        g.fillOval(earthX, earthY, 20, 20);
        g.setColor(Color.RED);
        g.fillOval(marsX, marsY, 30, 30);
        g.setColor(Color.ORANGE);
        g.fillOval(venusX, venusY, 25, 25);
        g.setColor(Color.WHITE);
        g.fillOval(moonX, moonY, 10, 10);
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
                    angle++;
                    double radians = Math.toRadians(angle);
                    earthX = (int)(sunX + 100 * Math.cos(radians));
                    earthY = (int)(sunY + 100 * Math.sin(radians));
                    marsX = (int)(sunX + 150 * Math.cos(radians * 0.5));
                    marsY = (int)(sunY + 150 * Math.sin(radians * 0.5));
                    venusX = (int)(sunX + 80 * Math.cos(radians * 1.2));
                    venusY = (int)(sunY + 80 * Math.sin(radians * 1.2));
                    moonX = earthX + 20;
                    moonY = earthY;
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
    public static void main(String[] args) {
        new Sistema_Solare();
    }
}