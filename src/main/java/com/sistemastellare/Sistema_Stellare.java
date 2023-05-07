package com.sistemastellare;

import com.sistemastellare.objects.Moon;
import com.sistemastellare.objects.Planet;
import com.sistemastellare.objects.Star;

import java.awt.*;
import java.awt.event.*;

public class Sistema_Stellare extends Frame implements ActionListener {
    private final Star[] Stella;
    private int index;
    private boolean isRunning = false;
    private final Button startButton = new Button("Start");
    private final Button[] planetButtons = new Button[3];

    Sistema_Stellare(Star[] Stella, int index) {
        super("Sistema Solare");
        this.Stella = Stella;
        this.index = index;
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
        if(Stella.length > 1) {
            for (int i = 0; i < Stella.length; i++) {
                if (Stella[i] != null) {
                    planetButtons[i] = new Button("Galassia " + (i + 1));
                    planetButtons[i].setBounds(50, 50 + 40 * (i + 1), 80, 30);
                    planetButtons[i].addActionListener(this);
                    add(planetButtons[i]);
                }
            }
        }
        setVisible(true);

        addMouseListener(new MouseAdapter() {
            /**
             * On left click, if the mouse is on a planet, a dialog with the planet's info is shown
             */
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();
                    for (Planet p: Stella[index].getPlanets()) {
                        if (mouseX >= p.getX() && mouseX <= p.getX() + 20
                                && mouseY >= p.getY() && mouseY <= p.getY() + 20) {
                            PlanetInfoDialog dialog = new PlanetInfoDialog(p);
                            dialog.setVisible(true);
                            break;
                        }
                    }
                }
            }
        });

    }

    /**
     * @deprecated This shows only a moon orbiting a planet because the moons are too close to each other
     */
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        int dim = 20;
        g.fillOval(this.getWidth() / 2 - (dim + 10) / 2, this.getHeight() / 2 - (dim + 10) / 2, dim + 10, dim + 10);
        for (Planet p: Stella[index].getPlanets()) {
            g.setColor(p.getColor());
            g.fillOval(p.getX(), p.getY(), dim, dim);
            for (Moon m: p.getMoons()) {
                g.setColor(Color.WHITE);
                g.fillOval(m.getX(), m.getY(), 10, 10);
            }

        }
    }

    /**
     * Allows the user to select a galaxy to show or to change the state of the simulation.
     */
    @SuppressWarnings("BusyWait")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == planetButtons[0]) {
            index = 0;
        } else if (e.getSource() == planetButtons[1]) {
            index = 1;
        } else if (e.getSource() == planetButtons[2]) {
            index = 2;
        } else if (e.getSource() == startButton) {
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
                        for (Planet p: Stella[index].getPlanets()) {
                            p.Move(centerX, centerY);
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
    }
}