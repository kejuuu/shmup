package utils;

import java.awt.*;

import GameFrame.GamePanel;

public abstract class PhysicsGameObject extends GameObject
{

	public PhysicsGameObject(String path, int zIndex) {
		super(path, zIndex);
	}

	@Override
	public void update()
	{
		for (int i = 0; i < Data.gameCollidables.size(); i++)
		{
			if (Data.gameCollidables.get(i) == this)
				continue;
			if (Collision.checkCollision(this, Data.gameCollidables.get(i)))
				onCollide(Data.gameCollidables.get(i));
		}
	}

	@Override
	public void draw(Graphics2D g)
	{
		super.draw(g);

		if (Constants.DEBUG)
		{
			g.setColor(Color.blue);
			g.drawRect(transform.getPositionX() - width * 3 / 2 * GamePanel.getScreenWidth() / 1920,
					transform.getPositionY() - height * 3 / 2 * GamePanel.getScreenHeight() / 1080,
					width * 3 * GamePanel.getScreenWidth() / 1920, height * 3 * GamePanel.getScreenHeight() / 1080);
			g.drawString(getInfo(), transform.getPositionX() - width * 3 / 2 * GamePanel.getScreenWidth() / 1920,
					transform.getPositionY() + height * 3 * GamePanel.getScreenHeight() / 1080);
			g.setColor(Color.black);
		}
	}

	public abstract void onCollide(PhysicsGameObject collider);
}
