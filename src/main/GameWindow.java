package main;

import javax.swing.*;

public class GameWindow {
    JFrame jframe = new JFrame();

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setSize(1000, 700);
        jframe.setLocationRelativeTo(null);
        jframe.add(gamePanel);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
