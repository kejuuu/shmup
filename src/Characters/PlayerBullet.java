package Characters;

import java.util.List;
import utils.Collision;
import utils.GameObject;

public class PlayerBullet extends GameObject
{
    public int speed;

    public PlayerBullet(String path, int speed) 
    {
        super(path);
        this.speed = speed;
    }

    public void update(List<Enemy> enemies)
    {
        transform.positionY -= speed;
        // check collision with class enemy
        for (Enemy enemy : enemies)
        {
            if (Collision.checkCollision(this, enemy))
            {
                enemy.onCollide();
            }
        }

    }
}
