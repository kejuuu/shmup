package utils;

import java.awt.Rectangle;
import GameFrame.GamePanel;
import GUI.Button;

public class Collision
{
	public static boolean checkCollision(GameObject a, GameObject b)
	{
		Rectangle ra = new Rectangle(
				a.transform.getPositionX() - a.image.getWidth() * 3 / 2 * GamePanel.getWidthScaleFactor(),
				a.transform.getPositionY() - a.image.getHeight() * 3 / 2 * GamePanel.getHeightScaleFactor(),
				a.image.getWidth() * 3 * GamePanel.getWidthScaleFactor(),
				a.image.getHeight() * 3 * GamePanel.getHeightScaleFactor());
		Rectangle rb = new Rectangle(
				b.transform.getPositionX() - b.image.getWidth() * 3 / 2 * GamePanel.getWidthScaleFactor(),
				b.transform.getPositionY() - b.image.getHeight() * 3 / 2 * GamePanel.getHeightScaleFactor(),
				b.image.getWidth() * 3 * GamePanel.getWidthScaleFactor(),
				b.image.getHeight() * 3 * GamePanel.getHeightScaleFactor());

		if (ra.intersects(rb))
		{
			return true;
		}
		return false;
	}

	public static boolean checkMousePosition(Button button, int x, int y)
	{
		if (x > button.transform.getPositionX() - button.image.getWidth() * 3 / 2 * GamePanel.getWidthScaleFactor()
				&& x < button.transform.getPositionX() + button.image.getWidth() * 3 / 2 * GamePanel.getWidthScaleFactor()
				&& y > button.transform.getPositionY()
						- button.image.getHeight() * 3 / 2 * GamePanel.getHeightScaleFactor()
				&& y < button.transform.getPositionY()
						+ button.image.getHeight() * 3 / 2 * GamePanel.getHeightScaleFactor())
		{
			return true;
		}
		return false;
	}

}