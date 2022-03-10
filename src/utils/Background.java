package utils;

import java.awt.*;

public class Background extends GameObject {
    private int scrollSpeed;

    public Background(String path, int scrollSpeed) {
        super(path);
        this.scrollSpeed = scrollSpeed;
    }

    public void scrollBg() {
        transform.positionY += scrollSpeed;
    }

    // Menggambar background dan melakukan looping jika background melebihi layar
    public void draw(Graphics2D g) {
        g.drawImage(image, transform.positionX, transform.positionY, null);

        if (transform.positionY >= 0) {
            g.drawImage(image, 0, transform.positionY - 360, null);
            if (transform.positionY - 360 >= 0) {
                transform.positionY = 0;
            }
        }
    }
}
