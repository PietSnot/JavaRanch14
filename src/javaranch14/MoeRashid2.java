/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaranch14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Piet
 */
public class MoeRashid2 {

}

class Lab4GUI2 {

    private JFrame frame;
    private String player = "X";
    private JButton cg;
    private JButton cn;
    private JButton ce;
    private JButton ng;
    private JButton ne;
    private JButton tn;
    private JButton ln;
    private JButton le;
    private JButton lg;

    public void checkWin() {
        if (!cg.getText().equals("") && cg.getText().equals(cn.getText()) && cg.getText().equals(ce.getText())) {
            JOptionPane.showMessageDialog(null, cg.getText() + " WINS!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
        } else if (!ng.getText().equals("") && ng.getText().equals(tn.getText()) && ng.getText().equals(ne.getText())) {
            JOptionPane.showMessageDialog(null, ng.getText() + " WINS!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
        } else if (!lg.getText().equals("") && lg.getText().equals(ln.getText()) && lg.getText().equals(le.getText())) {
            JOptionPane.showMessageDialog(null, lg.getText() + " WINS!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
        } else if (!cg.getText().equals("") && cg.getText().equals(ng.getText()) && cg.getText().equals(lg.getText())) {
            JOptionPane.showMessageDialog(null, cg.getText() + " WINS!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
        } else if (!cn.getText().equals("") && cn.getText().equals(tn.getText()) && cn.getText().equals(ln.getText())) {
            JOptionPane.showMessageDialog(null, cn.getText() + " WINS!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
        } else if (!ce.getText().equals("") && ce.getText().equals(ne.getText()) && ce.getText().equals(le.getText())) {
            JOptionPane.showMessageDialog(null, ce.getText() + " WINS!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
        } else if (!cg.getText().equals("") && cg.getText().equals(tn.getText()) && cg.getText().equals(le.getText())) {
            JOptionPane.showMessageDialog(null, cg.getText() + " WINS!", "WINNER", JOptionPane.INFORMATION_MESSAGE);
        } else if (!lg.getText().equals("") && lg.getText().equals(tn.getText()) && cg.getText().equals(ce.getText())) {
            JOptionPane.showMessageDialog(null, "WINNER", lg.getText() + " WINS!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
//                    TicTacToeGUI window = new TicTacToeGUI();
//                    window.frame.setVisible(true);
                      new Lab4GUI2().initialize();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void TicTacToeGUI() {
        initialize();
    }

    private void choosePlayer() {
        if (player.equalsIgnoreCase("X")) {
            player = "O";
        } else {
            player = "X";
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(3, 3, 1, 1));

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        cg = new JButton("");
        cg.setFont(new Font("Tahoma", Font.PLAIN, 96));

        cg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                cg.setText(player);
                cg.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    cg.setForeground(Color.red);

                } else {
                    cg.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }

        });
        panel_1.add(cg, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        ng = new JButton("");
        ng.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ng.setText(player);
                ng.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    ng.setForeground(Color.red);
                } else {
                    ng.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }
        });
        ng.setFont(new Font("Tahoma", Font.PLAIN, 96));
        panel_2.add(ng, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));

        lg = new JButton("");
        lg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lg.setText(player);
                lg.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    lg.setForeground(Color.red);
                } else {
                    lg.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }
        });
        lg.setFont(new Font("Tahoma", Font.PLAIN, 96));
        panel_3.add(lg, BorderLayout.CENTER);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_4);
        panel_4.setLayout(new BorderLayout(0, 0));

        cn = new JButton("");
        cn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cn.setText(player);
                cn.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    cn.setForeground(Color.red);
                } else {
                    cn.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }
        });
        cn.setFont(new Font("Tahoma", Font.PLAIN, 96));
        panel_4.add(cn, BorderLayout.CENTER);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_5);
        panel_5.setLayout(new BorderLayout(0, 0));

        tn = new JButton("");
        tn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tn.setText(player);
                tn.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    tn.setForeground(Color.red);
                } else {
                    tn.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }
        });
        tn.setFont(new Font("Tahoma", Font.PLAIN, 96));
        panel_5.add(tn, BorderLayout.CENTER);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));

        ln = new JButton("");
        ln.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ln.setText(player);
                ln.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    ln.setForeground(Color.red);
                } else {
                    ln.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }
        });
        ln.setFont(new Font("Tahoma", Font.PLAIN, 96));
        panel_6.add(ln, BorderLayout.CENTER);

        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_7);
        panel_7.setLayout(new BorderLayout(0, 0));

        ce = new JButton("");
        ce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ce.setText(player);
                ce.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    ce.setForeground(Color.red);
                } else {
                    ce.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }
        });
        ce.setFont(new Font("Tahoma", Font.PLAIN, 96));
        panel_7.add(ce, BorderLayout.CENTER);

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_8);
        panel_8.setLayout(new BorderLayout(0, 0));

        ne = new JButton("");
        ne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ne.setText(player);
                ne.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    ne.setForeground(Color.red);
                } else {
                    ne.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }
        });
        ne.setFont(new Font("Tahoma", Font.PLAIN, 96));
        panel_8.add(ne, BorderLayout.CENTER);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        panel.add(panel_9);
        panel_9.setLayout(new BorderLayout(0, 0));

        le = new JButton("");
        le.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                le.setText(player);
                le.removeActionListener(this);
                if (player.equalsIgnoreCase("X")) {
                    le.setForeground(Color.red);
                } else {
                    le.setForeground(Color.blue);
                }
                choosePlayer();
                checkWin();
            }
        });
        le.setFont(new Font("Tahoma", Font.PLAIN, 96));
        panel_9.add(le, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }

}
