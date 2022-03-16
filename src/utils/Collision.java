package utils;

import java.awt.Rectangle;
import java.util.List;

public class Collision
{
    public static boolean checkCollision(GameObject a, GameObject b)
    {
        Rectangle ra = new Rectangle(a.transform.positionX - a.image.getWidth() * 3/2, a.transform.positionY - a.image.getHeight() * 3/2, a.image.getWidth() * 3,
                a.image.getHeight() * 3);
        Rectangle rb = new Rectangle(b.transform.positionX - b.image.getWidth() * 3/2, b.transform.positionY - b.image.getHeight() * 3/2, b.image.getWidth() * 3,
                b.image.getHeight() * 3);

        if (ra.intersects(rb))
        {
            return true;
        }
        return false;
    }
    public static boolean checkCollision(GameObject a, GameObject b, List<String> ignoreCollision)
    {
        if (ignoreCollision.contains(a.getInfo()) || ignoreCollision.contains(b.getInfo()))
            return false;

        Rectangle ra = new Rectangle(a.transform.positionX - a.image.getWidth() * 3/2, a.transform.positionY - a.image.getHeight() * 3/2, a.image.getWidth() * 3,
                a.image.getHeight() * 3);
        Rectangle rb = new Rectangle(b.transform.positionX - b.image.getWidth() * 3/2, b.transform.positionY - b.image.getHeight() * 3/2, b.image.getWidth() * 3,
                b.image.getHeight() * 3);

        if (ra.intersects(rb))
        {
            return true;
        }
        return false;
    }
}