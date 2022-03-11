package screens;

import java.awt.*;

import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.List;

import Characters.PlayerBullet;
import GameFrame.GamePanel;
import states.GameState;
import states.GameStateManager;
import utils.Background;
import utils.GameObject;

public class Level1 extends GameState {

    private Background background;
    private GameObject player;

    private boolean isFiring = false;
    private double fireRate = 0.1;

    private List<PlayerBullet> playerBullets = new ArrayList<PlayerBullet>();

    public Level1(GameStateManager gsm) {
        this.gsm = gsm;

        background = new Background("/Background/background.png", 1);
        player = new GameObject("/Ships/ship_0000.png");

        player.transform.setPosition(GamePanel.SCREEN_WIDTH / 2 - player.image.getWidth() / 2, 960);  
    }

    public void update() {
        background.scrollBg();
        player.transform.setPosition(MouseInfo.getPointerInfo().getLocation().x,
                MouseInfo.getPointerInfo().getLocation().y);
        
        if (isFiring) {
            fireRate -= 0.01;
            if (fireRate <= 0) {
                firePlayerBullet();
                fireRate = 0.1;
            }
        }

        for(int i=0;i<playerBullets.size();i++) {
            if(playerBullets.get(i).transform.positionY < 0) {
                if(playerBullets.size() > 0)
                	playerBullets.remove(0);
            }
            if(playerBullets.size() > 0)
            	playerBullets.get(i).update();
        }
    }

    public void firePlayerBullet()
    {
        PlayerBullet instance = new PlayerBullet("/Tiles/tile_0000.png", 10);
        instance.transform.setPosition(player.transform.positionX + player.image.getWidth() / 2 - instance.image.getWidth() / 2,
                player.transform.positionY - instance.image.getHeight());
        playerBullets.add(instance);
    }

    public void draw(Graphics2D g) {
        background.draw(g);
        player.draw(g);
        for(int i=0;i<playerBullets.size();i++) {
            playerBullets.get(i).draw(g);
        }
    }

    public void mousePressed(int x, int y) {
        isFiring = true;
    }

    public void mouseReleased(int x, int y) {
        isFiring = false;
    }
}
