package entity;

import utils.PhysicsGameObject;

public abstract class Ship extends PhysicsGameObject
{
	protected int health = 5;
	protected double fireRate = 100; // in milliseconds

	/**
	 * Create a ship with a given firerate
	 * @param  path   The path to the image of the ship
	 * @param  zIndex The zIndex of the ship
	 * @param  fireRate The firerate of the ship (in milliseconds)
	 */
	public Ship(String path, int zIndex, double fireRate) 
	{
		super(path, zIndex);
		this.fireRate = fireRate;
	}


	
	/**
	 * get the ship's current health
	 * @return the ship's current health
	 */
	public int getHealth()
	{
		return health;
	}


	/**
	 * set the ship's current health
	 * @param health The new health value
	 */
	public void setHealth(int health)
	{
		this.health = health;
	}

}
