/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaranch14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Piet
 */
public class HuaMinChen {
    public static void main(String... args) {
        JPanel panel = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);
        JLabel label1 = createLabel(300, 300, Color.BLUE);
        JLabel label2 = createLabel(300, 300, Color.RED);
        GridBagConstraints c = new GridBagConstraints();
        gbl.setConstraints(label1, c);
        panel.add(label1);
        gbl.setConstraints(label2, c);
        panel.add(label2);
        
        JFrame frame = new JFrame("GridBagLayout");
        frame.setContentPane(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static JLabel createLabel(int width, int height, Color color) {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(width, height));
        label.setOpaque(true);
        label.setBackground(color);
        return label;
    }
}
