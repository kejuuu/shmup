package Characters;

import utils.Collidable;
import utils.Transform;

import java.awt.MouseInfo;

public class Player extends Collidable
{
	private int health = 5;

	public Player(String path, int health) 
	{
		super(path, 3);
		this.health = health;
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
	}

	@Override
	public void onCollide(Collidable collider)
	{
		if (collider.getClass().getSimpleName().equals("EnemyBullet"))
		{
			health--;
		} else if (collider.getClass().getSimpleName().equals("Enemy"))
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
