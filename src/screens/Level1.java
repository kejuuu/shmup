package screens;

import java.awt.*;

import java.awt.MouseInfo;
import java.util.ArrayList;
import java.util.List;

import Characters.Enemy;
import Characters.PlayerBullet;
import GameFrame.GamePanel;
import states.GameState;
import states.GameStateManager;
import utils.Background;
import utils.GameObject;
import utils.constants;

public class Level1 extends GameState
{

    private Background background;
    private GameObject player;
    private Enemy enemy;

    private boolean isFiring = false;
    private double fireRate = 0.1;

    private List<PlayerBullet> playerBullets = new ArrayList<PlayerBullet>();
    private List<Enemy> enemies = new ArrayList<Enemy>();

    public Level1(GameStateManager gsm) 
    {
        this.gsm = gsm;

        background = new Background(constants.BACKGROUND, 1);
        player = new GameObject(constants.PLAYER);
        enemy = new Enemy(constants.ENEMY1, 5);

        player.transform.setPosition(GamePanel.SCREEN_WIDTH / 2 - player.image.getWidth() / 2, 960);
        enemy.transform.setPosition(GamePanel.SCREEN_WIDTH / 2 - enemy.image.getWidth() / 2, 200);
        enemy.transform.setRotation(180);
        enemies.add(enemy);
    }

    public void update()
    {
        background.scrollBg();
        player.transform.setPosition(MouseInfo.getPointerInfo().getLocation().x,
                MouseInfo.getPointerInfo().getLocation().y);

        if (isFiring)
        {
            fireRate -= 0.01;
            if (fireRate <= 0)
            {
                firePlayerBullet();
                fireRate = 0.1;
            }
        }

        for (int i = 0; i < playerBullets.size(); i++)
        {
            if (playerBullets.get(i).transform.positionY < 0)
            {
                if (playerBullets.size() > 0)
                    playerBullets.remove(0);
            }
            if (playerBullets.size() > 0)
            {
                playerBullets.get(i).update(enemies);
                if (playerBullets.get(i).hasCollidedWithEnemy)
                {
                    if (playerBullets.size() > 0)
                        playerBullets.remove(i);
                }
            }
        }
    }

    public void firePlayerBullet()
    {
        PlayerBullet instance = new PlayerBullet(constants.PLAYER_BULLET, 10);
        instance.transform.setPosition(
                player.transform.positionX + player.image.getWidth() / 2 - instance.image.getWidth() / 2,
                player.transform.positionY - instance.image.getHeight());
        playerBullets.add(instance);
    }

    public void draw(Graphics2D g)
    {
        background.draw(g);
        for (int i = 0; i < playerBullets.size(); i++)
        {
            playerBullets.get(i).draw(g);
        }
        player.draw(g);
        for (int i = 0; i < enemies.size(); i++)
        {
            if (enemies.get(i).health <= 0)
            {
                if (enemies.size() > 0)
                    enemies.remove(i);
            }
        }

    }

    public void mousePressed(int x, int y)
    {
        isFiring = true;
    }

    public void mouseReleased(int x, int y)
    {
        isFiring = false;
    }
}
