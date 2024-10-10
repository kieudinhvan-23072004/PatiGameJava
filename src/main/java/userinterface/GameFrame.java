package userinterface;

import javax.swing.*;

public class GameFrame extends JFrame {
    public static void main(String[] args) {

        GamePanel gamePanel = new GamePanel();

        JFrame window = new JFrame();
        window.add(gamePanel);
        gamePanel.startGame();
        window.setTitle("Pati Game");
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
