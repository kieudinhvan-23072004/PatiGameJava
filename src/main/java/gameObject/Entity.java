package gameObject;

import userinterface.GamePanel;

import java.awt.*;

public class Entity {
   public double x, y, speedX, speedY;
   protected double gravity;
   protected Rectangle hitBox;

    public Entity(int x, int y, int speedX, int speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        gravity = 10;

        hitBox = new Rectangle(x, y, 64 * 2, 40 * 2);

    }

    public void drawHitBox(Graphics g){
        g.setColor(Color.red);
        g.drawRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
    }
    public void updateHitbox(){
        hitBox.x = (int)x;
        hitBox.y = (int)y;
    }

    public Rectangle getHitBox(){
        return hitBox;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
}