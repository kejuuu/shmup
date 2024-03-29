package utils;

import java.awt.Graphics2D;
import java.util.*;
import javax.imageio.ImageIO;

import GameFrame.GamePanel;

import java.awt.image.*;
import java.awt.geom.AffineTransform;

public class AnimatedSprite
{
	public Transform transform = new Transform();
	private int currentFrame = 0;
	private int frameCount = 0;
	private int width;
	private int height;
	private List<BufferedImage> frames = new ArrayList<BufferedImage>();

	public AnimatedSprite(String spriteName, String[] spritePaths, int frameCount, Transform transform) {
		if (!Data.cachedAnimatedSprite.containsKey(spriteName))
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
			Data.cachedAnimatedSprite.put(spriteName, frames);
		} else
		{
			frames = Data.cachedAnimatedSprite.get(spriteName);
		}

		this.frameCount = frameCount;
		this.transform = transform;
		width = frames.get(0).getWidth();
		height = frames.get(0).getHeight();
		Data.addObject(this);
	}

	public void update()
	{
		currentFrame++;
		if (currentFrame >= frameCount)
			Data.gameAnimatedSprites.remove(this);
	}

	public void draw(Graphics2D g)
	{
		double rotationRequired = Math.toRadians(transform.getRotation());
		double locationX = frames.get(0).getWidth() / 2;
		double locationY = frames.get(0).getHeight() / 2;

		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);

		g.drawImage(op.filter(frames.get(currentFrame), null), transform.getPositionX() - width * 3 / 2 * GamePanel.getScreenWidth() / 1920,
				transform.getPositionY() - height * 3 / 2 * GamePanel.getScreenHeight() / 1080, width * 3 * GamePanel.getScreenWidth() / 1920, height * 3 * GamePanel.getScreenHeight() / 1080, null);
	}

}
