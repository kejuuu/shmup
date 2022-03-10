package utils;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.*;

public class GameObject {
    public BufferedImage image;
    public Transform transform = new Transform();
    public int width;
    public int height;

    public GameObject(String path) {
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
        width = image.getWidth();
        height = image.getHeight();
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, transform.positionX-width*3/2, transform.positionY - height*3/2, width*3, height*3, null);
    }
}
