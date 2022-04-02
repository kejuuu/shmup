package Characters;
import GameFrame.GamePanel;
import utils.Collidable;
import utils.Transform;
import utils.constants;
import utils.data;


public class Enemy extends Collidable
{
    public int health = 5;
    private double fireRate = data.ENEMY1_FIRE_RATE; // in milliseconds
    public float speed;

    public Enemy(String path, int health) 
    {
        super(path, 3);
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
                transform.positionX + image.getWidth() / 2 - 15,
                transform.positionY + image.getHeight());
        instance.transform.rotation = 180;
        instance.speed = (int)(this.speed + 8);
    }

    @Override
    public void onCollide(Collidable collider)
    {
        if(collider.getClass().getSimpleName().equals("PlayerBullet"))
        {
            health--;
            destroy(collider);
            
            Transform particleLoc = new Transform(transform.positionX + image.getWidth() / 2, transform.positionY + image.getHeight() / 2, 0);
            new ShootParticle(particleLoc);
            if(health <= 0)
            {
                destroy(this);
            }
        }
    }
}
