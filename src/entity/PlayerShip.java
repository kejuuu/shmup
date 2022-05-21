package entity;

import utils.PhysicsGameObject;
import utils.Transform;
import utils.ShootImpl;
import utils.Constants;
import utils.Data;

import java.awt.MouseInfo;

import GameFrame.GamePanel;

public class PlayerShip extends Ship implements ShootImpl
{
	private boolean canFire = false;

	/**
	 * Create a player ship with a given health
	 * @param  path   The path to the image of the player ship
	 * @param  health The health of the player ship
	 */
	public PlayerShip(String path, int health) 
	{
		super(path, 3, Data.PLAYER_FIRE_RATE);
		this.health = health;
	}

	/**
	 * Set the player canFire variable
	 * if true, then the player can fire and spawn playerBullets
	 * @param canFire The new value of canFire
	 */
	public void setFiring(boolean canFire)
	{
		this.canFire = canFire;
	}

	/**
	 * This method is called once every frame.
	 * set the position of the ship to the mouse position
	 * if the player can fire, then spawn playerBullets every couple of seconds (based on deltaTime)
	 */
	public void update()
	{
		super.update();
		transform.setPosition(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
		if (canFire)
		{
			fireRate -= GamePanel.deltaTime();
			if (fireRate <= 0)
			{
				fireBullet();
				fireRate = Data.PLAYER_FIRE_RATE;
			}
		}
	}

	/**
	 * This method is called once every frame.
	 * if the player can fire, then spawn playerBullets every couple of seconds (based on deltaTime)
	 */
	@Override
	public void fireBullet()
	{
		PlayerBullet instance = new PlayerBullet(Constants.PLAYER_BULLET, 10);
		instance.transform.setPosition(transform.getPositionX() + image.getWidth() / 2 - 15,
				transform.getPositionY() - instance.getImage().getHeight());

	}


	/**
	 * This method is called when the player ship collided with other PhysicsGameObjects
	 * @param other The other PhysicsGameObject
	 */
	@Override
	public void onCollide(PhysicsGameObject collider)
	{
		// if the player ship collided with an enemy bullet, reduce the player's health by one
		if (collider.getClass().getSimpleName().equals("EnemyBullet"))
		{
			health--;
		} 
		// else if the player ship collided with an enemy ship, reduce the player's health by one 
		// and create a new particle effect based on the player's position
		else if (collider.getClass().getSimpleName().equals("EnemyShip"))
		{
			health--;
			Transform particleLoc = new Transform(transform.getPositionX() + image.getWidth() / 2,
					transform.getPositionY() + image.getHeight() / 2, 0);
			new ShootParticle(particleLoc);

		}

		// Guard clause to check if the collider has already been destroyed
		if (collider != null && !collider.getClass().getSimpleName().equals("PlayerBullet"))
		{
			destroy(collider);
		}

		// if player's health is less than or equal to 0, then destroy the player ship
		if (health <= 0)
		{
			destroy(this);
		}
	}

}
