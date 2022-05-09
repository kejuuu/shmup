package utils;

import java.awt.*;

import GameFrame.GamePanel;

public class Background extends GameObject
{
    private int scrollSpeed;

    public Background(String path, int scrollSpeed) 
    {
        super(path, -99);
        this.scrollSpeed = scrollSpeed;
    }

    @Override
    public void update()
    {
        transform.positionY += scrollSpeed;
    }

    // Menggambar background dan melakukan looping jika background melebihi layar
    public void draw(Graphics2D g)
    {
        g.drawImage(image, transform.positionX, transform.positionY, GamePanel.getScreenWidth(), GamePanel.getScreenHeight(),
                null);

        if (transform.positionY >= 0)
        {
            g.drawImage(image, 0, transform.positionY - GamePanel.getScreenHeight(), GamePanel.getScreenWidth(),
                    GamePanel.getScreenHeight(), null);
            if (transform.positionY - GamePanel.getScreenHeight() >= 0)
            {
                transform.positionY = 0;
            }
        }
    }
}
