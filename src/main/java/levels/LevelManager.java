package levels;

import userinterface.GamePanel;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager {

    GamePanel gamePanel;
    private BufferedImage[] levelSprite;
    private Level levelOne;

    public LevelManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        importOutsideSprites();
        levelOne = new Level(LoadSave.getLevelData());
    }

    private void importOutsideSprites() {
        BufferedImage image = LoadSave.getSpriteAtlas(LoadSave.LEVEL_ATLAS);
        levelSprite = new BufferedImage[48];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 12; j++){
                int index = i * 12 + j;
                levelSprite[index] = image.getSubimage(j * 32, i * 32, 32, 32);
            }
        }
    }

    public void draw(Graphics g){
        for(int j = 0; j < GamePanel.maxScreenRow; j++){
            for(int i = 0; i < GamePanel.maxScreenCol; i++){
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite[index], i * GamePanel.tileSize ,j * GamePanel.tileSize,GamePanel.tileSize, GamePanel.tileSize,null);
            }
        }
    }

    public void update(){

    }
}
