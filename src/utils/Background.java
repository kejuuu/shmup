package utils;

import java.awt.*;

import GameFrame.GamePanel;

public class Background extends GameObject
{
    private int scrollSpeed;

    public Background(String path, int scrollSpeed) 
    {
        super(path);
        this.scrollSpeed = scrollSpeed;
    }

    public void scrollBg()
    {
        transform.positionY += scrollSpeed;
    }

    // Menggambar background dan melakukan looping jika background melebihi layar
    public void draw(Graphics2D g)
    {
        g.drawImage(image, transform.positionX, transform.positionY, GamePanel.SCREEN_WIDTH, GamePanel.SCREEN_HEIGHT,
                null);

        if (transform.positionY >= 0)
        {
            g.drawImage(image, 0, transform.positionY - GamePanel.SCREEN_HEIGHT, GamePanel.SCREEN_WIDTH,
                    GamePanel.SCREEN_HEIGHT, null);
            if (transform.positionY - GamePanel.SCREEN_HEIGHT >= 0)
            {
                transform.positionY = 0;
            }
        }
    }
}
