package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.image.*;

public class data 
{
    public static List<GameObject> drawable = new ArrayList<GameObject>();
    public static List<Collidable> collideObject = new ArrayList<Collidable>();
    public static List<AnimatedSprite> animatedSprite = new ArrayList<AnimatedSprite>();
    
    public static Map<String, List<BufferedImage>> cachedAnimatedSprite = new HashMap<String, List<BufferedImage>>();

    public static int WAVE = 1;
    public static double PLAYER_FIRE_RATE = 100;
    public static double ENEMY1_FIRE_RATE = 1200;
}
