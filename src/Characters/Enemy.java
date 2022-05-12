package Characters;
import GameFrame.GamePanel;
import utils.PhysicsGameObject;
import utils.Transform;
import utils.constants;
import utils.data;
import utils.Attackable;


public class Enemy extends PhysicsGameObject implements Attackable
{
	private int health = 5;
    private double fireRate = data.getENEMY1_FIRE_RATE(); // in milliseconds
    private float speed;

    public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}
	
	public float getSpeed()
	{
		return speed;
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}

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
            fireRate = data.getENEMY1_FIRE_RATE();
        }
    }
    
    @Override
    public void fireBullet()
    {
        Bullet instance = new EnemyBullet(constants.ENEMY1_BULLET, 10);
        instance.transform.setPosition(
                transform.positionX + image.getWidth() / 2 - 15,
                transform.positionY + image.getHeight());
        instance.transform.rotation = 180;
        instance.speed = (int)(this.speed + 8);
    }

    @Override
    public void onCollide(PhysicsGameObject collider)
    {
        if(collider.getClass().getSimpleName().equals("PlayerBullet"))
        {
            health--;
            destroy(collider);
            
            Transform particleLoc = new Transform(transform.positionX + image.getWidth() / 2, transform.positionY + image.getHeight() / 2, 0);
            new ShootParticle(particleLoc);
            if(health <= 0)
            {
            	data.addSCORE(100);
                destroy(this);
            }
		}
	}
}
