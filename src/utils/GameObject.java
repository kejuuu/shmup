package utils;

import java.awt.image.*;
import javax.imageio.ImageIO;
import java.awt.*;

public class GameObject {
    public BufferedImage image;
    public Transform transform = new Transform();

    public GameObject(String path) {
        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, transform.positionX, transform.positionY, null);
    }
}
