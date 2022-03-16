package Characters;
import utils.Collidable;

public class Enemy extends Collidable
{
    public int health = 5;

    public Enemy(String path, int health) 
    {
        super(path);
        this.transform.rotation = 180;
        this.health = health;
    }

    @Override
    public void onCollide(String collider)
    {
        if(collider.equals("PlayerBullet"))
        {
            health--;
            if(health <= 0)
            {
                destroy(this);
            }
        }
    }
}
