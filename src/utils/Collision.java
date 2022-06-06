package utils;

import java.awt.Rectangle;
import GameFrame.GamePanel;
import GUI.Button;

public class Collision
{
	public static boolean checkCollision(GameObject a, GameObject b)
	{
		Rectangle ra = new Rectangle(
				a.transform.getPositionX() - a.image.getWidth() * 3 / 2 * GamePanel.getScreenWidth() / 1920,
				a.transform.getPositionY() - a.image.getHeight() * 3 / 2 * GamePanel.getScreenHeight() / 1080,
				a.image.getWidth() * 3 * GamePanel.getScreenWidth() / 1920,
				a.image.getHeight() * 3 * GamePanel.getScreenHeight() / 1080);
		Rectangle rb = new Rectangle(
				b.transform.getPositionX() - b.image.getWidth() * 3 / 2 * GamePanel.getScreenWidth() / 1920,
				b.transform.getPositionY() - b.image.getHeight() * 3 / 2 * GamePanel.getScreenHeight() / 1080,
				b.image.getWidth() * 3 * GamePanel.getScreenWidth() / 1920,
				b.image.getHeight() * 3 * GamePanel.getScreenHeight() / 1080);

		if (ra.intersects(rb))
		{
			return true;
		}
		return false;
	}

	public static boolean checkMousePosition(Button button, int x, int y)
	{
		if (x > button.transform.getPositionX() - button.image.getWidth() * 3 / 2 * GamePanel.getScreenWidth() / 1920
				&& x < button.transform.getPositionX() + button.image.getWidth() * 3 / 2 * GamePanel.getScreenWidth() / 1920
				&& y > button.transform.getPositionY()
						- button.image.getHeight() * 3 / 2 * GamePanel.getScreenHeight() / 1080
				&& y < button.transform.getPositionY()
						+ button.image.getHeight() * 3 / 2 * GamePanel.getScreenHeight() / 1080)
		{
			return true;
		}
		return false;
	}

}