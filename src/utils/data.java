package utils;

import java.util.ArrayList;
import java.util.List;

import Characters.AnimatedSprite;

public class data 
{
    public static List<GameObject> drawable = new ArrayList<GameObject>();
    public static List<Collidable> collideObject = new ArrayList<Collidable>();
    public static List<AnimatedSprite> animatedSprite = new ArrayList<AnimatedSprite>();

    public static int WAVE = 1;
    public static double PLAYER_FIRE_RATE = 100;
    public static double ENEMY1_FIRE_RATE = 1200;
}
