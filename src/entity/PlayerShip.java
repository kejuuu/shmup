package entity;

import utils.PhysicsGameObject;
import utils.Transform;
import utils.Attackable;
import utils.Constants;
import utils.Data;

import java.awt.MouseInfo;

import GameFrame.GamePanel;

public class PlayerShip extends PhysicsGameObject implements Attackable
{
	private int health = 5;
	private boolean isFiring = false;
	private double fireRate = Data.getPLAYER_FIRE_RATE(); // in milliseconds

	public PlayerShip(String path, int health) {
		super(path, 3);
		this.health = health;
	}

	public void setFiring(boolean isFiring)
	{
		this.isFiring = isFiring;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public void update()
	{
		super.update();
		transform.setPosition(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
		if (isFiring)
		{
			fireRate -= GamePanel.deltaTime();
			if (fireRate <= 0)
			{
				fireBullet();
				fireRate = Data.getPLAYER_FIRE_RATE();
			}
		}
	}

	@Override
	public void fireBullet()
	{
		PlayerBullet instance = new PlayerBullet(Constants.PLAYER_BULLET, 10);
		instance.transform.setPosition(transform.positionX + image.getWidth() / 2 - 15,
				transform.positionY - instance.image.getHeight());

	}

	@Override
	public void onCollide(PhysicsGameObject collider)
	{
		if (collider.getClass().getSimpleName().equals("EnemyBullet"))
		{
			health--;
		} else if (collider.getClass().getSimpleName().equals("EnemyShip"))
		{
			health--;
			Transform particleLoc = new Transform(transform.positionX + image.getWidth() / 2,
					transform.positionY + image.getHeight() / 2, 0);
			new ShootParticle(particleLoc);
			destroy(collider);
		}
		if (health <= 0)
		{
			destroy(this);
		}
	}

}
