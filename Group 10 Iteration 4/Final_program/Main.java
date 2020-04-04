import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


import javax.swing.Timer;
import javax.swing.*;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Size choosing
        JFrame intro = new JFrame("Ricochet Robots - Choose game mode");
        JPanel icky = new JPanel();
        JButton simple = new JButton("Simple");
        simple.setBackground(Color.GREEN);
        JButton complex = new JButton("Complex");
        complex.setBackground(Color.ORANGE);
        JLabel welcome = new JLabel("Welcome to Ricochet Robots by Group 10");
        icky.setBackground(Color.lightGray);

        JTextField P1 = new JTextField("Enter the name of Player 1");
        icky.add(P1);
        JTextField P2 = new JTextField("Enter the name of Player 2");
        icky.add(P2);
        JTextField P3 = new JTextField("Enter the name of Player 3");
        icky.add(P3);
        JTextField P4 = new JTextField("Enter the name of Player 4"); 
        icky.add(P4);

        String player_1_name = P1.getText();
        Player Player_1 = new Player(player_1_name);

        String player_2_name = P2.getText();
        Player Player_2 = new Player(player_2_name);

        String player_3_name = P3.getText();
        Player Player_3 = new Player(player_3_name);

        String player_4_name = P4.getText();
        Player Player_4 = new Player(player_4_name);

        simple.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new RicochetRobots(Player_1, Player_2, Player_3, Player_4);
                RicochetRobots.simple();
                intro.dispose();

            }
        });
            complex.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    new RicochetRobots(Player_1, Player_2, Player_3, Player_4);
                    RicochetRobots.complex();
                    intro.dispose();
                    }});
            
            
            intro.setSize(500,200);
            icky.setLayout(new GridLayout(5,5));
            //adds buttons to Label
            icky.add(welcome);
            icky.add(simple);
            icky.add(complex);
            intro.add(icky);
            intro.setLocationRelativeTo(null);
            intro.setVisible(true);
            }
        
}           