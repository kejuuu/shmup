package GUI;

import utils.GameObject;
import utils.constants;

import java.awt.*;

import Characters.Player;
import GameFrame.GamePanel;

public class HeartGUI extends GameObject {
    
    private Font pixelFont;
    
    private int health = 0;
    private Player player;

    public HeartGUI(String path) {
        super(path, 99);
        player = (Player)GameObject.find("Player");
//        player = new Player(constants.PLAYER, 3);
        this.transform.setPosition(50+width, 1070-height);
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(constants.pixelFont));
            pixelFont = pixelFont.deriveFont(Font.PLAIN, 96);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        health = player.health;
    }

    public void draw(Graphics2D g)
    {
        super.draw(g);
        g.setFont(pixelFont);
        g.setColor(Color.red);
        g.drawString("x" + String.valueOf(health), 100, GamePanel.SCREEN_HEIGHT - 10);
        g.setColor(Color.black);
        g.setFont(Font.decode(null));
    }

}
