package GUI;

import utils.GameObject;
import utils.Constants;
import utils.Data;

import java.awt.*;

public class ScoreGUI extends GameObject
{

	private Font pixelFont;
	private int score;
	private String text;
	private boolean center;
	private boolean boost;

	private int posX;
	private int posY;

	/**
	 * Create a ScoreGUI to the given position to Display the players score
	 * @param posX is the horizontal position
	 * @param posY is the vertical position
	 */
	public ScoreGUI(int posX, int posY, boolean center) 
	{
		super(Constants.EMPTY, 99);
		try
		{
			pixelFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(Constants.PIXELFONT));
			pixelFont = pixelFont.deriveFont(Font.PLAIN, 96);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		this.posX = posX;
		this.posY = posY;
		this.score = Data.getSCORE();
		this.text = "Score: " + String.valueOf(score);
		this.center = center;

	}

	
	/**
	 * Update the players score to be displayed on the score GUI
	 */
	@Override
	public void update()
	{
		this.score = Data.getSCORE();
		this.text = "Score: " + String.valueOf(score);
	}

	
	/**
	 * Display the updated score to the ScoreGUI
	 */
	public void draw(Graphics2D g)
	{
		super.draw(g);
		try
		{
			g.setFont(pixelFont);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		g.setColor(Color.black);
		if (center)
			g.drawString(text, (int) (posX - g.getFontMetrics(pixelFont).stringWidth(text) / 2), posY);
		else
			g.drawString(text, posX, posY);
		g.setColor(Color.black);
		g.setFont(Font.decode(null));
	}
}
