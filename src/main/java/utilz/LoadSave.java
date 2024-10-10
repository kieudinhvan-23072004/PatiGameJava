package utilz;

import userinterface.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LoadSave {

    public static final String PLAYER_ATLAS = "data/player_sprites.png";
    public static final String LEVEL_ATLAS = "data/outside_sprites.png";
    public static final String LEVEL_ONE_DATA = "data/level_one_data.png";
    public static final String GOKU_GONG = "data/goku_gong.png";
    public static final String GOKU_JUMP = "data/goku_jump.png";
    public static final String GOKU_KAME = "data/goku_kame.png";
    public static final String GOKU_KAME2 = "data/goku_kame2.png";
    public static final String GOKU_CHEM= "data/goku_chem.png";

    public static BufferedImage getSpriteAtlas(String fileName){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(fileName));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static int[][] getLevelData(){
        int[][] lvData = new int[GamePanel.maxScreenRow][GamePanel.maxScreenCol];
        BufferedImage image = getSpriteAtlas(LEVEL_ONE_DATA);
        for(int j = 0; j < image.getHeight(); j++){
            for(int i = 0; i < image.getWidth(); i++){
                Color color = new Color(image.getRGB(i, j));
                int value = color.getRed();
                if(value >= 48) value = 0;
                lvData[j][i] = value;
            }
        }
        return lvData;
    }
}
