package GUI;

import utils.GameObject;
import utils.constants;

import java.awt.*;

import Characters.Player;

public class HeartGUI extends GameObject {
    
    private Font pixelFont;
    
    private int health = 0;
    private Player player;
    
    private int posX;
    private int posY;

    public HeartGUI(String path, int posX, int posY) {
        super(path, 99);
        this.posX = posX;
        this.posY = posY;
        player = (Player)GameObject.find("Player");
        this.transform.setPosition(posX + width, posY - height - 50);
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(constants.PIXELFONT));
            pixelFont = pixelFont.deriveFont(Font.PLAIN, 96);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        this.health = player.getHealth();
    }

    public void draw(Graphics2D g)
    {
        super.draw(g);
        g.setFont(pixelFont);
        g.setColor(Color.red);
        g.drawString("x" + String.valueOf(health), posX + width * 2 + 30, posY - 60);
        g.setColor(Color.black);
        g.setFont(Font.decode(null));
    }

}
