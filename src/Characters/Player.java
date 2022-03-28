package Characters;

import utils.Collidable;
import java.awt.MouseInfo;

public class Player extends Collidable
{
    public int health = 5;

    public Player(String path, int health) 
    {
        super(path, 3);
        this.health = health;
    }

    public void update()
    {
        super.update();
        transform.setPosition(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
    }

    @Override
    public void onCollide(String collider)
    {
        if(collider.equals("EnemyBullet"))
        {
            health--;
            if(health <= 0)
            {
                destroy(this);
            }
        }
    }

}
