package entity;

import utils.PhysicsGameObject;
import utils.Transform;
import utils.Attackable;
import utils.Constants;
import utils.Data;

import java.awt.MouseInfo;

import GameFrame.GamePanel;

public class PlayerShip extends Ship implements Attackable
{
	private boolean isFiring = false;

	public PlayerShip(String path, int health) {
		super(path, 3, Data.getPLAYER_FIRE_RATE());
		this.health = health;
	}

	public void setFiring(boolean isFiring)
	{
		this.isFiring = isFiring;
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
		instance.transform.setPosition(transform.getPositionX() + image.getWidth() / 2 - 15,
				transform.getPositionY() - instance.getImage().getHeight());

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
			Transform particleLoc = new Transform(transform.getPositionX() + image.getWidth() / 2,
					transform.getPositionY() + image.getHeight() / 2, 0);
			new ShootParticle(particleLoc);

		}
		if (collider != null && !collider.getClass().getSimpleName().equals("PlayerBullet"))
		{
			destroy(collider);
		}
		if (health <= 0)
		{
			destroy(this);
		}
	}

}
