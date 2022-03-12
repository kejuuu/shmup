package utils;

import java.awt.Rectangle;

public class Collision
{
    public static boolean checkCollision(GameObject a, GameObject b)
    {
        Rectangle ra = new Rectangle((int) a.transform.positionX, (int) a.transform.positionY, a.image.getWidth(),
                a.image.getHeight());
        Rectangle rb = new Rectangle((int) b.transform.positionX, (int) b.transform.positionY, b.image.getWidth(),
                b.image.getHeight());

        if (ra.intersects(rb))
        {
            System.out.println(a.getInfo() + " collides with " + b.getInfo());
            return true;
        }
        return false;
    }
}
