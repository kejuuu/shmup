package GUI;

import utils.GameObject;
import utils.constants;
import utils.data;

import java.awt.*;

public class ScoreGUI extends GameObject {
    
    private Font pixelFont;
    private int score;

    public ScoreGUI()
    {
        super(constants.EMPTY);
        this.transform.setPosition(0,0);
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(constants.pixelFont));
            pixelFont = pixelFont.deriveFont(Font.PLAIN, 96);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void update()
    {
        score = data.SCORE;
    }

    public void draw(Graphics2D g)
    {
        super.draw(g);
        g.setFont(pixelFont);
        g.setColor(Color.black);
        g.drawString("Score: " + String.valueOf(score), 10, 50);
        g.setColor(Color.black);
        g.setFont(Font.decode(null));
    }
}
