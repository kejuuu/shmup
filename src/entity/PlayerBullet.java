package entity;

import utils.PhysicsGameObject;

public class PlayerBullet extends Bullet
{
	public PlayerBullet(String path, int speed) 
	{
		super(path, speed, 2);
	}

	@Override
	public void update()
	{
		super.update();
		transform.positionY -= speed;
	}

	@Override
	public void onCollide(PhysicsGameObject collider)
	{
		if (collider.getClass().getSimpleName().equals("Enemy"))
		{
			destroy(this);
		}
	}
}
