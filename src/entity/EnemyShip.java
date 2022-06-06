package entity;
import GameFrame.GamePanel;
import utils.PhysicsGameObject;
import utils.Transform;
import utils.Constants;
import utils.Data;
import utils.ShootImpl;


public class EnemyShip extends Ship implements ShootImpl
{
	private int health = 5;
    private float speed;
    
    /**
    * Create an enemy ship with a given health
    * @param  path   The path to the image of the enemy ship
    * @param  health The health of the enemy ship
    */
	public EnemyShip(String path, int health) 
    {
        super(path, 3, Data.ENEMY1_FIRE_RATE);
        this.transform.setRotation(180);
        this.health = health;
        this.speed = 1;
    }

    /**
     * Get the enemy ship's current health
     * @return The enemy ship's current health
     */
    public int getHealth()
	{
		return health;
	}
	
    /**
     * Get the enemy ship's current speed
     * @return The enemy ship's current speed
     */
	public float getSpeed()
	{
		return speed;
	}

    /**
     * Set the enemy ship's current speed
     * @param speed New enemy ship speed value
     */
	public void setSpeed(float speed)
	{
		this.speed = speed;
	}


    /**
     * This method is called once every frame.
     * send the enemy ship flying to the bottom of the screen (increasing speed)
     * construct an enemyBullet every couple of seconds (based on deltaTime)
     */
    @Override
    public void update()
    {
        super.update();
        if(transform.getPositionY() > GamePanel.getScreenHeight() + image.getHeight() * 3 / 2 * GamePanel.getScreenHeight() / 1080)
            destroy(this);
        transform.setPositionY((int)(transform.getPositionY() + speed));

        fireRate -= GamePanel.deltaTime();
        if (fireRate <= 0)
        {
            fireBullet();
            fireRate = Data.ENEMY1_FIRE_RATE;
        }
    }
    

    /**
     * This method is called when the enemy ship bullet Timer is destroyed
     * Creates a new enemy bullet and adds it to the game
     */
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


    /**
     * Checks if the enemy ship collides with the player
     * @param collider 		the object that the enemy ship collided with
     */
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
            	Data.SCORE += 500;
                destroy(this);
            }
		}
	}
}
