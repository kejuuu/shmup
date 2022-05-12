package entity;
import GameFrame.GamePanel;
import utils.PhysicsGameObject;
import utils.Transform;
import utils.Constants;
import utils.Data;
import utils.Attackable;


public class EnemyShip extends Ship implements Attackable
{
	private int health = 5;
    private float speed;
    
	public EnemyShip(String path, int health) 
    {
        super(path, 3, Data.getENEMY1_FIRE_RATE());
        this.transform.setRotation(180);
        this.health = health;
        this.speed = 1;
    }

    public int getHealth()
	{
		return health;
	}
	
	public float getSpeed()
	{
		return speed;
	}

	public void setSpeed(float speed)
	{
		this.speed = speed;
	}

    @Override
    public void update()
    {
        super.update();
        if(transform.getPositionY() > GamePanel.getScreenHeight() + image.getHeight() * 3 / 2)
            destroy(this);
        transform.setPositionY((int)(transform.getPositionY() + speed));

        fireRate -= GamePanel.deltaTime();
        if (fireRate <= 0)
        {
            fireBullet();
            fireRate = Data.getENEMY1_FIRE_RATE();
        }
    }
    
    @Override
    public void fireBullet()
    {
        Bullet instance = new EnemyBullet(Constants.ENEMY1_BULLET, 10);
        instance.transform.setPosition(
                transform.getPositionX() + image.getWidth() / 2 - 15,
                transform.getPositionY() + image.getHeight());
        instance.transform.setRotation(180);
        instance.speed = (int)(this.speed + 8);
    }

    @Override
    public void onCollide(PhysicsGameObject collider)
    {
        if(collider.getClass().getSimpleName().equals("PlayerBullet"))
        {
            health--;
            destroy(collider);
            
            Transform particleLoc = new Transform(transform.getPositionX() + image.getWidth() / 2, transform.getPositionY() + image.getHeight() / 2, 0);
            new ShootParticle(particleLoc);
            if(health <= 0)
            {
            	Data.addSCORE(500);
                destroy(this);
            }
		}
	}
}
