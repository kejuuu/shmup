package Characters;
import GameFrame.GamePanel;
import utils.Collidable;
import utils.constants;

public class Enemy extends Collidable
{
    public int health = 5;
    private double fireRate = constants.ENEMY1_FIRE_RATE; // in milliseconds

    public Enemy(String path, int health) 
    {
        super(path);
        this.transform.rotation = 180;
        this.health = health;
    }

    @Override
    public void update()
    {
        super.update();
        transform.positionY += 1;

        fireRate -= GamePanel.deltaTime();
        if (fireRate <= 0)
        {
            fireBullet();
            fireRate = constants.ENEMY1_FIRE_RATE;
        }
    }

    private void fireBullet()
    {
        Bullet instance = new EnemyBullet(constants.ENEMY1_BULLET, 10);
        instance.transform.setPosition(
                transform.positionX + image.getWidth() / 2 - instance.image.getWidth() / 2,
                transform.positionY - instance.image.getHeight());
        instance.transform.rotation = 180;
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
