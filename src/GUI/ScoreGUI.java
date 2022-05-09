package GUI;

import utils.GameObject;
import utils.constants;
import utils.data;

import java.awt.*;

public class ScoreGUI extends GameObject {
    
    private Font pixelFont;
    private int score;
    private String text;
    private boolean center;

    private int posX;
    private int posY;


    public ScoreGUI(int posX, int posY, boolean center)
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
        this.score = data.getSCORE();
        this.text = "Score: " + String.valueOf(score);
        this.center = center;

    }
    
    @Override
    public void update()
    {
        this.score = data.getSCORE();
        this.text = "Score: " + String.valueOf(score);
    }

    public void draw(Graphics2D g)
    {
        super.draw(g);
        try {
	        g.setFont(pixelFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.setColor(Color.black);
        if (center) 
        {
        	g.drawString(text, (int)(posX - g.getFontMetrics(pixelFont).stringWidth(text) / 2), posY);
        }
        else 
        {
        	g.drawString(text, posX, posY);
        }
        g.setColor(Color.black);
        g.setFont(Font.decode(null));
    }
}
