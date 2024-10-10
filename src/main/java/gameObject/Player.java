package gameObject;

import userinterface.GamePanel;
import utilz.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static utilz.constants.PlayerConstants.*;

public class Player extends Entity{

    GamePanel gamePanel;
    private boolean moving = false, attacking = false;

    private BufferedImage[][] animations;
    private BufferedImage[] ani;
    private HashMap<String, BufferedImage[]> mapAni;


    private int aniTick, aniIndex, aniSpeed = 20;
    private int playerAction = IDLE;// chỉ hành động của ng chơi

    private boolean left, right, up, down;

    public Player(int x, int y, int speedX, int speedY, GamePanel gamePanel) {
        super(x, y, speedX, speedY);
        this.gamePanel = gamePanel;
        loadAnimation();
    }

    public void draw(Graphics2D g2d){
//        g2d.setColor(Color.black);
//        g2d.fillRect((int)x, (int)y, GamePanel.tileSize, GamePanel.tileSize);
        //g2d.drawImage(animations[playerAction][aniIndex], (int)getX(),(int)getY(), 64 * 2,  40 * 2, null);
        //kame
//        if(aniIndex == 6){
//            g2d.drawImage(ani[aniIndex - 1], (int)getX(), (int)getY(), 68 * 2, 68 * 2, null);
//            g2d.drawImage(ani[aniIndex], (int)getX() + 110, (int)getY() - 43, ani[aniIndex].getWidth() * 2, ani[aniIndex].getHeight() * 2, null);
//        }
//        else{
//            g2d.drawImage(ani[aniIndex], (int)getX(), (int)getY(), 68 * 2, 68 * 2, null);
//        }

        //drawHitBox((Graphics) g2d);

        // chem
        g2d.drawImage(mapAni.get("chem")[aniIndex], (int)getX(),(int)getY(), 95 * 2,  95 * 2, null);
    }
    public void update(){
        updatePos();
        updateHitbox();
        updateAnimationTick();
        setAnimation();
    }

    public void updatePos(){

        moving = false;

        if(speedY < gravity){
            setSpeedY(speedY + 1);
        }

        if(y + speedY < 400  ) setY(y + speedY);
        else setSpeedY(0);


        if(left && !right){
            setX(x + speedX);
            moving = true;
        }else if(right && !left){
            setX(x + speedX);
            moving = true;
        }

    }

    private void setAnimation() {

        int startAni = playerAction;

        if(moving){
            playerAction = RUNNING;
        }else playerAction = IDLE;

        if (attacking) {
            playerAction = ATTACK_1;
        }

        if(startAni != playerAction){
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updateAnimationTick() {
        aniTick++;
        if(aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
//            if(aniIndex >= getSpriteAmount(playerAction)){
//                aniIndex = 0;
//                attacking = false;
//            }
//            if(aniIndex >= 7){
//                aniIndex = 0;
//            }
              if(aniIndex >= 12){
                aniIndex = 0;
            }
        }
    }

    private void loadAnimation() {
            BufferedImage image = LoadSave.getSpriteAtlas(LoadSave.PLAYER_ATLAS);
             // BufferedImage image_kame = LoadSave.getSpriteAtlas(LoadSave.GOKU_KAME);
            animations = new BufferedImage[9][6];
            //  ani = new BufferedImage[7];
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = image.getSubimage(i * 64, j * 40, 64, 40);
                }
            }
//             for(int i = 0; i < 6; i++){
//                 ani[i] = image_kame.getSubimage(i * 68, 0, 68, 68);
//             }
//        try {
//            ani[6] = ImageIO.read(new File(LoadSave.GOKU_KAME2));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
          // load hanh dong
        mapAni = new HashMap<>();
        //1 chem

            String name = "chem";
            image = LoadSave.getSpriteAtlas(LoadSave.GOKU_CHEM);
            BufferedImage[] chem = new BufferedImage[12];
            for(int i = 0; i < 12; i++){
                chem[i] = image.getSubimage(i * 95, 0, 95, 95);
            }
            mapAni.put(name, chem);

            //2 lưỡi hái
        String name = "luoiHai";
        image = LoadSave.getSpriteAtlas(LoadSave.GOKU_CHEM);
        BufferedImage[] luoiHai = new BufferedImage[];
        for(int i = 0; i < 12; i++){
            chem[i] = image.getSubimage(i * 95, 0, 95, 95);
        }
        mapAni.put(name, luoiHai);

    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }
}
