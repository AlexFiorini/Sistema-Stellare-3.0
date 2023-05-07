package com.sistemasolare;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Sistema_Solare extends JFrame implements ActionListener {
    JButton button = new JButton();
    final int width = 1920, height = 1080;
    final Dimension screenSize = new Dimension(width, height);
    boolean isRunning = false;
    JPanel btnPnl = new JPanel();
    private final int sun_x = width/2, sun_y = height/2;
    private int mercury_x = sun_x - 58, mercury_y = sun_y - 50;
    private final int mercury_aphelion = (int)(Math.pow(70, 2)), mercury_perihelion = (int)(Math.pow(46, 2));
    private int venus_x = sun_x - 108, venus_y = sun_y - 90;
    private final int venus_aphelion = (int)(Math.pow(109, 2)), venus_perihelion = (int)(Math.pow(107, 2));
    private int earth_x = sun_x - 150, earth_y = sun_y - 120;
    private final int earth_aphelion = (int)(Math.pow(152, 2)), earth_perihelion = (int)(Math.pow(147, 2));
    private int mars_x = sun_x - 228, mars_y = sun_y - 180;
    private final int mars_aphelion = (int)(Math.pow(249, 2)), mars_perihelion = (int)(Math.pow(207, 2));
    private int jupiter_x = sun_x - 778, jupiter_y = sun_y - 700;
    private final int jupiter_aphelion = (int)(Math.pow(741, 2)), jupiter_perihelion = (int)(Math.pow(817, 2));
    private int saturn_x = sun_x - 1430, saturn_y = sun_y - 1000;
    private final int saturn_aphelion = (int)(Math.pow(1513, 2)), saturn_perihelion = (int)(Math.pow(1349, 2));
    private int uranus_x = sun_x - 2870, uranus_y = sun_y - 2000;
    private final int uranus_aphelion = (int)(Math.pow(3004, 2)), uranus_perihelion = (int)(Math.pow(2741, 2));
    private int neptune_x = sun_x - 4500, neptune_y = sun_y - 3500;
    private final int neptune_aphelion = (int)(Math.pow(4554, 2)), neptune_perihelion = (int)(Math.pow(4453, 2));
    private int angle = 0;

    public Sistema_Solare() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(screenSize);
        this.setLayout(new BorderLayout());

        button.setBounds(50, 50, 80, 30);
        button.setBackground(Color.white);
        button.setText("Start");
        button.setFocusable(false);
        button.addActionListener(this);
        btnPnl.setLayout(new BorderLayout());
        btnPnl.add(button, BorderLayout.WEST);

        this.add(btnPnl, BorderLayout.NORTH);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.yellow);
        g.fillOval(sun_x, sun_y, 50, 50);
        g.setColor(new Color(170, 170, 170));
        g.fillOval(mercury_x, mercury_y, 5, 5);
        g.setColor(new Color(255, 255, 102));
        g.fillOval(venus_x, venus_y, 12, 12);
        g.setColor(new Color(0, 128, 255));
        g.fillOval(earth_x, earth_y, 13, 13);
        g.setColor(new Color(255, 102, 0));
        g.fillOval(mars_x, mars_y, 7, 7);
        g.setColor(new Color(255, 192, 0));
        g.fillOval(jupiter_x, jupiter_y, 140, 140);
        g.setColor(new Color(255, 15, 0));
        g.fillOval(saturn_x, saturn_y, 116, 116);
        g.setColor(new Color(0, 204, 204));
        g.fillOval(uranus_x, uranus_y, 51, 51);
        g.setColor(new Color(0, 0, 153));
        g.fillOval(neptune_x, neptune_y, 49, 49);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            isRunning = false;
            button.setText("Start");
        }
        else {
            isRunning = true;
            button.setText("Stop");
            Thread t = new Thread(() -> {
                while (isRunning) {
                    angle++;
                    double radians = Math.toRadians(angle);
                    mercury_x = (int)(Math.sqrt((1 - mercury_y/mercury_perihelion) * mercury_aphelion));
                    mercury_y = (int)(Math.sqrt((1 - mercury_x/mercury_aphelion) * mercury_perihelion));
                    venus_x = (int)(Math.sqrt((1 - venus_y/venus_perihelion) * venus_aphelion));
                    venus_y = (int)(Math.sqrt((1-venus_x/venus_aphelion) * venus_perihelion));
                    earth_x = (int)(Math.sqrt((1 - earth_y/earth_perihelion) * earth_aphelion));
                    earth_y = (int)(Math.sqrt((1 - earth_x/earth_aphelion) * earth_perihelion));
                    mars_x = (int)(Math.sqrt((1 - mars_y/mars_perihelion) * mars_aphelion));
                    mars_y = (int)(Math.sqrt((1 - mars_x/mars_aphelion) * mars_perihelion));
                    jupiter_x = (int)(Math.sqrt((1 - jupiter_y/jupiter_perihelion) * jupiter_aphelion));
                    jupiter_y = (int)(Math.sqrt((1 - jupiter_x/jupiter_aphelion) * jupiter_perihelion));
                    saturn_x = (int)(Math.sqrt((1 - saturn_y/saturn_perihelion) * saturn_aphelion));
                    saturn_y = (int)(Math.sqrt((1 - saturn_x/saturn_aphelion) * saturn_perihelion));
                    uranus_x = (int)(Math.sqrt((1 - uranus_y/uranus_perihelion) * uranus_aphelion));
                    uranus_y = (int)(Math.sqrt((1 - uranus_x/uranus_aphelion) * uranus_perihelion));
                    neptune_x = (int)(Math.sqrt((1 - neptune_y/neptune_perihelion) * neptune_aphelion));
                    neptune_y = (int)(Math.sqrt((1 - neptune_x/neptune_aphelion) * neptune_perihelion));
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