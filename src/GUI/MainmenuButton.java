package GUI;

import states.GameStateManager;
import utils.Constants;
import utils.Data;

public class MainmenuButton extends Button
{

	final private GameStateManager gsm;

	/**
	 * Create a MainmenuButton to the given position to be able to go back to the main menu
	 * @param posX is the horizontal position
	 * @param posY is the vertical position
	 */
	public MainmenuButton(int posX, int posY, GameStateManager gsm) 
	{
		super(Constants.MAINMENUBUTTON, posX, posY);
		this.gsm = gsm;
	}

	/**
	 * When clicked, do the following:
	 * Set the players score to 0
	 * Navigate back to the Main Menu
	 */
	@Override
	public void onClick()
	{
		Data.setSCORE(0);
		gsm.changeState(GameStateManager.MENU);
	}

}
