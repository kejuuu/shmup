package utils;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class GameObject
{
    public BufferedImage image;
    public Transform transform = new Transform();
    protected int width;
    protected int height;
    public int zIndex;
    
    protected String imagePath;


    public GameObject(String path, int zIndex) 
    {
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

        data.addObject(this);
    }

    public void draw(Graphics2D g)
    {
        double rotationRequired = Math.toRadians(transform.rotation);
        double locationX = image.getWidth() / 2;
        double locationY = image.getHeight() / 2;

        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

        g.drawImage(op.filter(image, null), transform.positionX - width * 3 / 2, transform.positionY - height * 3 / 2,
                width * 3, height * 3, null);

    }

    public void destroy(GameObject object)
    {
        if(data.gameDrawable.contains(object))
            data.gameDrawable.remove(object);
        
        if(data.gameCollidables.contains(object) && object instanceof Collidable)
        {
            data.gameCollidables.remove(object);
        }
    }

    public String getInfo()
    {
        return imagePath;
    }

    public static GameObject find(String className)
    {
        for(int i=0;i<data.gameDrawable.size();i++)
        {
            if(data.gameDrawable.get(i).getClass().getSimpleName().equals(className))
                return data.gameDrawable.get(i);
        }
        return null;
    }

    public abstract void update();
}
