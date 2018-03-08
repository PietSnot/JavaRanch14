/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Piet
 */
public class DomingasPleckauskas2 {
    
    double angle;
    JPanel panel;
    final Dimension labelSize;
    final int nrOfLabels;
    BufferedImage buf;
    Path2D path;
    Point2D aimPoint;
    
    public static void main(String... args) {
        SwingUtilities.invokeLater(DomingasPleckauskas2::new);
    }
    
    private DomingasPleckauskas2() {
        labelSize = new Dimension(50, 50);
        nrOfLabels = 10;
//        fixedPoint = new Point2D.Double(50, 50);
        aimPoint = new Point2D.Double();
        angle = Math.PI / 2;
        Dimension panelSize = new Dimension(labelSize.width * nrOfLabels, labelSize.height * nrOfLabels);
        createPath();
        
        try {
            buf = ImageIO.read(new File("D:\\Syls bestanden\\bezier.png"));
        }
        catch (IOException e) {
            System.out.println("Can't load image!!!!");
            return;
        }
        
        panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return panelSize;
            }
            
            @Override
            public void paint(Graphics g) {
                paintComponent(g);
                super.paintBorder(g);
                super.paintChildren(g);
                Graphics2D g2d = (Graphics2D) g.create();
                drawArrow(g2d);
                g2d.dispose();
            }
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int w = this.getWidth(), h = this.getHeight();
                g.drawImage(buf, 0, 0, w, h, null);
            }
        };
        panel.setLayout(new GridLayout(0, nrOfLabels));
        Random r = new Random();
        for (int row = 0; row < nrOfLabels; row++) {
            for (int col = 0; col < nrOfLabels; col++) {
                panel.add(createLabel(r));
            }
        }
        
        MouseMotionListener mml = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent m) {
                aimPoint = m.getPoint();
                panel.repaint();
            }
        };
        
        panel.addMouseMotionListener(mml);
        
        JFrame frame = new JFrame("Arrow aimer version 2");
        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private JLabel createLabel(Random r) {
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);
        int alpha = r.nextInt(128);
        Color c = new Color(red, green, blue, alpha);
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(c);
        return label;
    }
    
    private void createPath() {
        path = new Path2D.Double();
        path.moveTo(0, 0);
        path.lineTo(0, 1);
        path.moveTo(-0.1, 0.8);
        path.lineTo(0, 1);
        path.lineTo(0.1, 0.8);
        path.closePath();
    }
    
    private void drawArrow(Graphics2D g2d) {
        Point2D fixedPoint = getFixedPoint();
        double length = fixedPoint.distance(aimPoint);
        if (length == 0.0) return;
        double dx = aimPoint.getX() - fixedPoint.getX();
        double dy = aimPoint.getY() - fixedPoint.getY();
        angle = -Math.atan2(dx, dy);
        g2d.rotate(angle, fixedPoint.getX(), fixedPoint.getY());
        g2d.translate(fixedPoint.getX(), fixedPoint.getY());
        g2d.scale(length, length);
        g2d.setStroke(new BasicStroke( 2 / (float) length));
        g2d.setColor(Color.WHITE);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(path);
    }
    
    private Point2D getFixedPoint() {
        return new Point2D.Double(panel.getWidth() / 2.0, panel.getHeight());
    }
}
