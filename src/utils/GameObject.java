package utils;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class GameObject
{
    public BufferedImage image;
    public Transform transform = new Transform();
    public int width;
    public int height;
    
    private String imagePath;


    public GameObject(String path) 
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

                
        // ? Debug collision box
        g.setColor(Color.RED);
        g.drawRect(transform.positionX - width * 3 / 2, transform.positionY - height * 3 / 2, width * 3, height * 3);
    }

    public String getInfo()
    {
        return imagePath;
    }
}
