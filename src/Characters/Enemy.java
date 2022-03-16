package Characters;
import utils.Collidable;

public class Enemy extends Collidable
{
    public int health = 5;

    public Enemy(String path, int health) 
    {
        super(path);
        this.health = health;
    }

    @Override
    public void onCollide(String collider)
    {
        if(collider.equals("PlayerBullet"))
        {
            System.out.println(health);
            health--;
            if(health <= 0)
            {
                destroy(this);
            }
        }
    }
}
