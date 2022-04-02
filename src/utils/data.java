package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.image.*;

public class data 
{
    public static List<GameObject> gameDrawable = new ArrayList<GameObject>();
    public static List<Collidable> gameCollidables = new ArrayList<Collidable>();
    public static List<AnimatedSprite> gameAnimatedSprites = new ArrayList<AnimatedSprite>();
    
    public static Map<String, List<BufferedImage>> cachedAnimatedSprite = new HashMap<String, List<BufferedImage>>();

    public static int WAVE = 1;
    public static int SCORE = 0;

    public static double PLAYER_FIRE_RATE = 100;
    public static double ENEMY1_FIRE_RATE = 1200;

    public static void addObject(GameObject object)
    {
        if(object instanceof Collidable)
            gameCollidables.add((Collidable)object);
        
        gameDrawable.add(object);

        //sort the objects by zIndex
        gameDrawable.sort((o1, o2) -> o1.zIndex - o2.zIndex);
    }
}
