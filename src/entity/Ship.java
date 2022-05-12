package entity;

import utils.PhysicsGameObject;

public abstract class Ship extends PhysicsGameObject
{
	protected int health = 5;
	protected double fireRate = 100; // in milliseconds

	public Ship(String path, int zIndex, double fireRate) 
	{
		super(path, zIndex);
		this.fireRate = fireRate;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

}
