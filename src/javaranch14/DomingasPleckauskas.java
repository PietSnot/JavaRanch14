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
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Piet
 */
public class DomingasPleckauskas {
    
    double angle;
    float arrowLength;
    JPanel panel;
    BasicStroke bas;
    Dimension panelSize;
    BufferedImage buf;
    Path2D path;
    Point fixedPoint;
    
    public static void main(String... args) {
        SwingUtilities.invokeLater(DomingasPleckauskas::new);
    }
    
    private DomingasPleckauskas() {
        panelSize = new Dimension(500, 500);
        angle = Math.PI / 2;
        arrowLength = 100;
        fixedPoint = new Point(100, 200);
        bas = new BasicStroke(1 / arrowLength);
        
        try {
            buf = ImageIO.read(new File("D:\\Syls bestanden\\bezier.png"));
        } 
        catch (IOException ex) {
            System.out.println("Can't load image!!!");
            return;
        }
        
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                int w = this.getWidth(), h = this.getHeight();
                super.paintComponent(g);
                g.drawImage(buf, 0, 0, w, h, null);
                Graphics2D g2d = (Graphics2D) g.create();
                drawArrow(g2d);
                g2d.dispose();
            }
            @Override
            public Dimension getPreferredSize() {
                return panelSize;
            }
        };
        
        createArrow();
        
        MouseMotionListener mml = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent m) {
                double deltaX = m.getX() - fixedPoint.x;
                double deltaY = m.getY() - fixedPoint.y;
                angle = -Math.atan2(deltaX, deltaY);
                panel.repaint();
            }
        };
        
        panel.addMouseMotionListener(mml);
        
        JFrame frame = new JFrame("Aim with Arrow");
        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private void createArrow() {
        path = new Path2D.Double();
        path.moveTo(0, 0);
        path.lineTo(0, 1);
        path.moveTo(-0.1, 0.8);
        path.lineTo(0, 1);
        path.lineTo(0.1, 0.8);
        path.closePath();
    }
    
    private void drawArrow(Graphics2D g2d) {
        g2d.rotate(angle, fixedPoint.x, fixedPoint.y);
        g2d.translate(fixedPoint.x, fixedPoint.y);
        g2d.scale(arrowLength, arrowLength);
        g2d.setStroke(bas);
        g2d.setColor(Color.WHITE);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.draw(path);
    }
}