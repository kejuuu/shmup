package Characters;
import GameFrame.GamePanel;
import utils.Collidable;
import utils.constants;
import utils.data;
import java.util.Random;


public class Enemy extends Collidable
{
    public int health = 5;
    private double fireRate = data.ENEMY1_FIRE_RATE; // in milliseconds
    public float speed;

    public Enemy(String path, int health) 
    {
        super(path);
        this.transform.rotation = 180;
        this.health = health;
        this.speed = 1;
    }

    @Override
    public void update()
    {
        super.update();
        transform.positionY += speed;

        fireRate -= GamePanel.deltaTime();
        if (fireRate <= 0)
        {
            fireBullet();
            fireRate = data.ENEMY1_FIRE_RATE;
        }
    }

    private void fireBullet()
    {
        Bullet instance = new EnemyBullet(constants.ENEMY1_BULLET, 10);
        instance.transform.setPosition(
                transform.positionX + image.getWidth() / 2 - instance.image.getWidth() / 2,
                transform.positionY - instance.image.getHeight());
        instance.transform.rotation = 180;
        instance.speed = (int)(this.speed + 8);
    }

    @Override
    public void onCollide(String collider)
    {
        if(collider.equals("PlayerBullet"))
        {
            health--;
            
            ShootParticle destroyParticle = new ShootParticle(this.transform);
            destroyParticle.transform.rotation = new Random().nextInt(360);
            if(health <= 0)
            {
                destroy(this);
            }
        }
    }
}
