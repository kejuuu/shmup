package entity;

import utils.PhysicsGameObject;

public class EnemyBullet extends Bullet
{
	/**
	 * Create an enemy bullet with a given speed and zIndex
	 * this will call the Bullet Constructor
	 * @param path      The path to the image of the bullet
	 * @param speed     The speed of the bullet
	 */
	public EnemyBullet(String path, int speed) {
		super(path, speed, 2);
	}


	/**
	 * This method is called once every frame.
	 * send the bullet to the bottom of the screen
	 */
	@Override
	public void update()
	{
		super.update();

		// send the EnemyBullet flying to the bottom of the screen (increasing speed)
		transform.setPositionY(transform.getPositionY() + speed);
	}


	/**
	 * Checks if the bullet collides with the player
	 * @param collider 		the object that the bullet collided with
	 */
	@Override
	public void onCollide(PhysicsGameObject collider)
	{
		// if the bullet collides with the player, destroy this bullet
		if (collider.getClass().getSimpleName().equals("Player"))
		{
			destroy(this);
		}
	}

}
