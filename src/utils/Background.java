package utils;

import java.awt.*;

import GameFrame.GamePanel;

public class Background extends GameObject
{
	private int scrollSpeed;

	public Background(String path, int scrollSpeed) 
	{
		super(path, -99);
		this.scrollSpeed = scrollSpeed;
	}

	@Override
	public void update()
	{
		transform.setPositionY(transform.getPositionY() + scrollSpeed);
	}

	// Menggambar background dan melakukan looping jika background melebihi layar
	@Override
	public void draw(Graphics2D g)
	{
		g.drawImage(image, transform.getPositionX(), transform.getPositionY(), GamePanel.getScreenWidth(),
				GamePanel.getScreenHeight(), null);

		if (transform.getPositionY()>= 0)
		{
			g.drawImage(image, 0, transform.getPositionY()- GamePanel.getScreenHeight(), GamePanel.getScreenWidth(),
					GamePanel.getScreenHeight(), null);
			if (transform.getPositionY() - GamePanel.getScreenHeight() >= 0)
			{
				transform.setPositionY(0);
			}
		}
	}
}
