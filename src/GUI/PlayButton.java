package GUI;

import states.GameStateManager;

public class PlayButton extends Button
{
	final private GameStateManager gsm;

	/**
	 * Create a PlayButton to the given position to Start the game
	 * @param posX is the horizontal position
	 * @param posY is the vertical position
	 */
	public PlayButton(String path, int posX, int posY, GameStateManager gsm) 
	{
		super(path, posX, posY);
		this.gsm = gsm;
	}

	/**
	 * When clicked, start the game
	 */
	@Override
	public void onClick()
	{
		gsm.changeState(GameStateManager.LEVEL1);
	}
}
