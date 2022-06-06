package utils;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import GameFrame.GamePanel;

public abstract class GameObject
{
	public final Transform transform = new Transform();
	protected BufferedImage image;
	protected int width;
	protected int height;
	protected int zIndex;

	protected String imagePath;

	public GameObject(String path, int zIndex) {
		try
		{
			image = ImageIO.read(getClass().getResource(path));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		imagePath = path;
		this.zIndex = zIndex;

		Data.addObject(this);
	}

	public void draw(Graphics2D g)
	{
		double rotationRequired = Math.toRadians(transform.getRotation());
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;

		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		g.drawImage(op.filter(image, null), transform.getPositionX() - width * 3 / 2 * GamePanel.getWidthScaleFactor(),
				transform.getPositionY() - height * 3 / 2 * GamePanel.getHeightScaleFactor(),
				width * 3 * GamePanel.getWidthScaleFactor(), height * 3 * GamePanel.getHeightScaleFactor(), null);

	}

	public void destroy(GameObject object)
	{
		if (Data.gameDrawable.contains(object))
			Data.gameDrawable.remove(object);

		if (Data.gameCollidables.contains(object) && object instanceof PhysicsGameObject)
			Data.gameCollidables.remove(object);
	}

	public String getInfo()
	{
		return imagePath;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}

	public static GameObject find(String className)
	{
		for (int i = 0; i < Data.gameDrawable.size(); i++)
		{
			if (Data.gameDrawable.get(i).getClass().getSimpleName().equals(className))
				return Data.gameDrawable.get(i);
		}
		return null;
	}

	public abstract void update();
}
