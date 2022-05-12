package GUI;

import states.GameStateManager;
import utils.Constants;
import utils.Data;

public class PlayAgainButton extends Button
{

	private GameStateManager gsm;

	public PlayAgainButton(int posX, int posY, GameStateManager gsm) 
	{
		super(Constants.PLAYAGAINBUTTON, posX, posY);
		this.gsm = gsm;
	}

	@Override
	public void onClick()
	{
		Data.setSCORE(0);
		gsm.changeState(GameStateManager.LEVEL1);
	}

}
