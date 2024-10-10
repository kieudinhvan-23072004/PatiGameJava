package userinterface;

import java.awt.event.KeyEvent;

import static utilz.constants.Directions.*;

public class KeyHander {

    GamePanel gamePanel;

    public KeyHander(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void processKeyPressed(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_A:
                gamePanel.player.setLeft(true);
                gamePanel.player.setSpeedX(-5);
                break;
            case KeyEvent.VK_D:
                gamePanel.player.setRight(true);
                gamePanel.player.setSpeedX(5);
                break;
            case KeyEvent.VK_ENTER:
                System.out.println("Enter");
                break;
            case KeyEvent.VK_SPACE:
            if(gamePanel.player.getSpeedY() == 0){
                gamePanel.player.setSpeedY(-15);
            }
                break;
        }
    }

    public void processKeyReleased(int keyCode){
        switch (keyCode){
            case KeyEvent.VK_A:
                gamePanel.player.setSpeedX(0);
                gamePanel.player.setLeft(false);
                break;
            case KeyEvent.VK_D:
                gamePanel.player.setSpeedX(0);
                gamePanel.player.setRight(false);
                break;
            case KeyEvent.VK_ENTER:
                System.out.println("Enterhehe");
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("spacehehe");
                break;
        }
    }
}
