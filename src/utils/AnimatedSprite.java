package utils;

import java.awt.Graphics2D;
import java.util.*;
import javax.imageio.ImageIO;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class AnimatedSprite
{
	private int currentFrame = 0;
	private int frameCount = 0;
	public Transform transform = new Transform();
	private int width;
	private int height;
	private List<BufferedImage> frames = new ArrayList<BufferedImage>();

	public AnimatedSprite(String spriteName, String[] spritePaths, int frameCount, Transform transform) {
		if (!Data.getCachedAnimatedSprite().containsKey(spriteName))
		{
			for (int i = 0; i < spritePaths.length; i++)
			{
				try
				{
					frames.add(ImageIO.read(getClass().getResource(spritePaths[i])));
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
			Data.getCachedAnimatedSprite().put(spriteName, frames);
		} else
		{
			frames = Data.getCachedAnimatedSprite().get(spriteName);
		}

		this.frameCount = frameCount;
		this.transform = transform;
		width = frames.get(0).getWidth();
		height = frames.get(0).getHeight();
		Data.getGameAnimatedSprites().add(this);
	}

	public void update()
	{
		currentFrame++;
		if (currentFrame >= frameCount)
			Data.getGameAnimatedSprites().remove(this);
	}

	public void draw(Graphics2D g)
	{
		double rotationRequired = Math.toRadians(transform.rotation);
		double locationX = frames.get(0).getWidth() / 2;
		double locationY = frames.get(0).getHeight() / 2;

		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		g.drawImage(op.filter(frames.get(currentFrame), null), transform.positionX - width * 3 / 2,
				transform.positionY - height * 3 / 2, width * 3, height * 3, null);
	}

}
