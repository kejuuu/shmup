package screens;

import java.awt.Graphics2D;
import GameFrame.GamePanel;

import GUI.ExitButton;
import GUI.PlayButton;
import states.GameState;
import states.GameStateManager;
import utils.Background;
import utils.Constants;
import utils.Collision;
import utils.Data;

public class Menu extends GameState
{

	private final PlayButton playButton;
	private final ExitButton exitButton;

	public Menu(GameStateManager gsm) 
	{
		this.gsm = gsm;
		new Background(Constants.MENUBACKGROUND, 0);
		playButton = new PlayButton(Constants.PLAYBUTTON, (int) (GamePanel.getScreenWidth() / 2),
				GamePanel.getScreenHeight() - (int) (GamePanel.getScreenWidth() / 8), gsm);
		exitButton = new ExitButton(Constants.EXITBUTTON, GamePanel.getScreenWidth() - 75, 75);
	}

	@Override
	public void draw(Graphics2D g)
	{
		for (int i = 0; i < Data.gameDrawable.size(); i++)
			Data.gameDrawable.get(i).draw(g);
	}

	@Override
	public void mousePressed(int x, int y)
	{
		if (Collision.checkMousePosition(playButton, x, y))
		{
			playButton.onClick();
		}
		if (Collision.checkMousePosition(exitButton, x, y))
		{
			System.exit(0);
		}
	}

	@Override
	public void update()
	{
		for (int i = 0; i < Data.gameDrawable.size(); i++)
			Data.gameDrawable.get(i).update();
	}

	@Override
	public void mouseReleased(int x, int y)
	{
		
	}

}
