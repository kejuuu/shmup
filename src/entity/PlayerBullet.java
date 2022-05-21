package entity;

import utils.PhysicsGameObject;

public class PlayerBullet extends Bullet
{
	/**
	 * Create a player bullet with a given speed
	 * @param path 		The path to the image of the bullet
	 * @param speed		The speed of the bullet
	 */
	public PlayerBullet(String path, int speed) 
	{
		super(path, speed, 2);
	}


	/**
	 * This method is called once every frame.
	 * send the bullet to the top of the screen
	 */
	@Override
	public void update()
	{
		super.update();
		transform.setPositionY(transform.getPositionY() - speed);
	}


	/**
	 * Checks if the bullet collides with another collider
	 * @param collider 		the object that the bullet collided with
	 */
	@Override
	public void onCollide(PhysicsGameObject collider)
	{
		// if the bullet collides with the enemy, destroy this bullet
		if (collider.getClass().getSimpleName().equals("Enemy"))
		{
			destroy(this);
		}
	}
}
