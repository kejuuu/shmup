package GUI;

import utils.GameObject;
import utils.constants;
import utils.data;

import java.awt.*;

public class ScoreGUI extends GameObject {
    
    private Font pixelFont;
    private int score;

    private int posX;
    private int posY;


    public ScoreGUI(int posX, int posY)
    {
        super(constants.EMPTY, 99);
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(constants.PIXELFONT));
            pixelFont = pixelFont.deriveFont(Font.PLAIN, 96);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.posX = posX;
        this.posY = posY;
    }
    
    @Override
    public void update()
    {
        score = data.SCORE;
        System.out.println(data.SCORE);
    }

    public void draw(Graphics2D g)
    {
        super.draw(g);
        g.setFont(pixelFont);
        g.setColor(Color.black);
        g.drawString("Score: " + String.valueOf(score), posX, posY);
        g.setColor(Color.black);
        g.setFont(Font.decode(null));
    }
}
