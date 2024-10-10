package userinterface;

import gameObject.Player;
import levels.LevelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private static final int originalTileSize = 32; // 16 x 16
    private static final int scale = 2;
    public static final int tileSize = originalTileSize * scale; // 48 * 48
    public static final int maxScreenCol = 26;
    public static final int maxScreenRow = 14;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    // world setting
    public final int maxWorldCol = 50, maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol, worldHeight = tileSize * maxWorldRow;

    private KeyHander keyHander;
    private MoseHander moseHander;
    private LevelManager levelManager;

    public Player player;

    Timer myTimer = new Timer(16, this);
    public GamePanel(){
        keyHander = new KeyHander(this);
        moseHander = new MoseHander(this);
        levelManager = new LevelManager(this);
        this.addMouseListener(moseHander);
        this.addMouseMotionListener(moseHander);
        this.addKeyListener(this);

        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.pink);
        player = new Player(300, 0, 0, 0, this);

    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        levelManager.draw(g);
        player.draw((Graphics2D) g);
        g.dispose();
    }

    public void startGame(){
        myTimer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    public void update(){
        player.update();
        levelManager.update();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keyHander.processKeyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyHander.processKeyReleased(e.getKeyCode());
    }
}
