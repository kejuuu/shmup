package utils;

import java.awt.*;

import GameFrame.GamePanel;

public abstract class Collidable extends GameObject
{

	public Collidable(String path, int zIndex) {
		super(path, zIndex);
	}

	@Override
	public void update()
	{
		for (int i = 0; i < data.getGameCollidables().size(); i++)
		{
			if (data.getGameCollidables().get(i) == this)
				continue;
			if (Collision.checkCollision(this, data.getGameCollidables().get(i)))
			{
				onCollide(data.getGameCollidables().get(i));
			}
		}
	}

	@Override
	public void draw(Graphics2D g)
	{
		super.draw(g);

		if (constants.DEBUG)
		{
			g.setColor(Color.blue);
			g.drawRect(transform.positionX - width * 3 / 2 * GamePanel.getScreenWidth() / 1920,
					transform.positionY - height * 3 / 2 * GamePanel.getScreenHeight() / 1080,
					width * 3 * GamePanel.getScreenWidth() / 1920, height * 3 * GamePanel.getScreenHeight() / 1080);
			g.drawString(getInfo(), transform.positionX - width * 3 / 2 * GamePanel.getScreenWidth() / 1920,
					transform.positionY + height * 3 * GamePanel.getScreenHeight() / 1080);
			g.setColor(Color.black);
		}
	}

	public abstract void onCollide(Collidable collider);
}
