package screens;
import java.awt.*;

import Characters.Player;
import Characters.PlayerBullet;
import Characters.Spawner;
import GUI.HeartGUI;
import GameFrame.GamePanel;
import states.GameState;
import states.GameStateManager;
import utils.Background;
import utils.constants;
import utils.data;

public class Level1 extends GameState
{
    private Player player;

    private boolean isFiring = false;
    private double fireRate = data.PLAYER_FIRE_RATE; // in milliseconds


    public Level1(GameStateManager gsm) 
    {
        this.gsm = gsm;

        new Background(constants.BACKGROUND, 1);
        player = new Player(constants.PLAYER, 5);
        new Spawner(3000);

        player.transform.setPosition(GamePanel.SCREEN_WIDTH / 2 - player.image.getWidth() / 2, 960);
        

        new HeartGUI(constants.PLAYER);

    }

    public void update()
    {
        for (int i=0; i<data.drawable.size(); i++)
            data.drawable.get(i).update();
        
        for (int i=0; i<data.animatedSprite.size(); i++)
            data.animatedSprite.get(i).update();
        
        if (isFiring)
        {
            fireRate -= GamePanel.deltaTime();
            if (fireRate <= 0)
            {
                firePlayerBullet();
                fireRate = data.PLAYER_FIRE_RATE;
            }
        }
    }

    public void firePlayerBullet()
    {
        PlayerBullet instance = new PlayerBullet(constants.PLAYER_BULLET, 10);
        instance.transform.setPosition(
                player.transform.positionX + player.image.getWidth() / 2 - instance.image.getWidth() / 2,
                player.transform.positionY - instance.image.getHeight());
    }

    public void draw(Graphics2D g)
    {
        for (int i = 0; i < data.drawable.size(); i++)
            data.drawable.get(i).draw(g);
        
        for (int i = 0; i < data.animatedSprite.size(); i++)
            data.animatedSprite.get(i).draw(g);
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
