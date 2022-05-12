package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.image.*;

public class data
{
	private static List<GameObject> gameDrawable = new ArrayList<GameObject>();
	private static List<PhysicsGameObject> gameCollidables = new ArrayList<PhysicsGameObject>();
	private static List<AnimatedSprite> gameAnimatedSprites = new ArrayList<AnimatedSprite>();

	private static Map<String, List<BufferedImage>> cachedAnimatedSprite = new HashMap<String, List<BufferedImage>>();

	private static int WAVE = 1;
	private static int SCORE = 0;

	private static double PLAYER_FIRE_RATE = 100;
	private static double ENEMY1_FIRE_RATE = 1200;

	public static void addObject(GameObject object)
	{
		if (object instanceof PhysicsGameObject)
			gameCollidables.add((PhysicsGameObject) object);

		gameDrawable.add(object);

		// sort the objects by zIndex
		gameDrawable.sort((o1, o2) -> o1.zIndex - o2.zIndex);
	}

	public static double getPLAYER_FIRE_RATE()
	{
		return PLAYER_FIRE_RATE;
	}

	public static void setPLAYER_FIRE_RATE(double pLAYER_FIRE_RATE)
	{
		PLAYER_FIRE_RATE = pLAYER_FIRE_RATE;
	}

	public static double getENEMY1_FIRE_RATE()
	{
		return ENEMY1_FIRE_RATE;
	}

	public static void setENEMY1_FIRE_RATE(double eNEMY1_FIRE_RATE)
	{
		ENEMY1_FIRE_RATE = eNEMY1_FIRE_RATE;
	}

	public static int getWAVE()
	{
		return WAVE;
	}

	public static void setWAVE(int wAVE)
	{
		WAVE = wAVE;
	}

	public static int getSCORE()
	{
		return SCORE;
	}

	public static void addSCORE(int sCORE)
	{
		SCORE += sCORE;
	}

	public static void setSCORE(int sCORE)
	{
		SCORE = sCORE;
	}

	public static List<AnimatedSprite> getGameAnimatedSprites()
	{
		return gameAnimatedSprites;
	}

	public static void setGameAnimatedSprites(List<AnimatedSprite> gameAnimatedSprites)
	{
		data.gameAnimatedSprites = gameAnimatedSprites;
	}

	public static Map<String, List<BufferedImage>> getCachedAnimatedSprite()
	{
		return cachedAnimatedSprite;
	}

	public static void setCachedAnimatedSprite(Map<String, List<BufferedImage>> cachedAnimatedSprite)
	{
		data.cachedAnimatedSprite = cachedAnimatedSprite;
	}

	public static List<GameObject> getGameDrawable()
	{
		return gameDrawable;
	}

	public static void setGameDrawable(List<GameObject> gameDrawable)
	{
		data.gameDrawable = gameDrawable;
	}

	public static List<PhysicsGameObject> getGameCollidables()
	{
		return gameCollidables;
	}

	public static void setGameCollidables(List<PhysicsGameObject> gameCollidables)
	{
		data.gameCollidables = gameCollidables;
	}
}
