package screens;

import java.awt.*;

import GUI.MainmenuButton;
import GUI.PlayAgainButton;
import GUI.ScoreGUI;
import GameFrame.GamePanel;
import utils.Background;
import utils.Collision;
import utils.Constants;
import utils.Data;
import states.GameState;
import states.GameStateManager;

public class GameOver extends GameState
{
	private final PlayAgainButton playAgainButton;
	private final MainmenuButton mainMenuButton;

	/**
	 * Display GameOver Screen with the width and height as the width and height of the device
	 * Display the last score the player got
	 * Set the state to GAMEOVER
	 */
	public GameOver(GameStateManager gsm) {
		this.gsm = gsm;
		new ScoreGUI((int) (GamePanel.getScreenWidth() / 2),
				GamePanel.getScreenHeight() - (int) (GamePanel.getScreenHeight() / 2) + 50, true);
		playAgainButton = new PlayAgainButton((int) (GamePanel.getScreenWidth() / 2 - GamePanel.getScreenWidth() / 8),
				(int) (GamePanel.getScreenHeight() / 2) + 250, gsm);
		mainMenuButton = new MainmenuButton((int) (GamePanel.getScreenWidth() / 2 + GamePanel.getScreenWidth() / 8),
				(int) (GamePanel.getScreenHeight() / 2) + 250, gsm);
		new Background(Constants.GAMEOVERBACKGROUND, 0);
	}

	@Override
	public void update()
	{
		for (int i = 0; i < Data.getGameDrawable().size(); i++)
			Data.getGameDrawable().get(i).update();
	}

	@Override
	public void draw(Graphics2D g)
	{
		for (int i = 0; i < Data.getGameDrawable().size(); i++)
			Data.getGameDrawable().get(i).draw(g);
	}

	/**
	 * If playAgainbutton was pressed, start the game again with a 0 score
	 * If mainMenuButton was pressed, go back to the main mennu
	 */
	@Override
	public void mousePressed(int x, int y)
	{
		if (Collision.checkMousePosition(playAgainButton, x, y))
		{
			playAgainButton.onClick();
		}
		if (Collision.checkMousePosition(mainMenuButton, x, y))
		{
			mainMenuButton.onClick();
		}
	}

	@Override
	public void mouseReleased(int x, int y)
	{
	}

}
