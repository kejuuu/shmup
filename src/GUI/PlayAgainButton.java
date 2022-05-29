package GUI;

import states.GameStateManager;
import utils.Constants;
import utils.Data;

public class PlayAgainButton extends Button
{

	final private GameStateManager gsm;

	/**
	 * Create a PlayAgainButton to the given position to Restart the game
	 * @param posX is the horizontal position
	 * @param posY is the vertical position
	 */
	public PlayAgainButton(int posX, int posY, GameStateManager gsm) 
	{
		super(Constants.PLAYAGAINBUTTON, posX, posY);
		this.gsm = gsm;
	}


	/**
	 * When clicked, do the following:
	 * Set the players score back to 0
	 * Start the game again
	 */
	@Override
	public void onClick()
	{
		Data.SCORE = 0;
		gsm.changeState(GameStateManager.LEVEL1);
	}

}
