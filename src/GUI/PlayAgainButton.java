package GUI;

import states.GameStateManager;
import utils.constants;
import utils.data;

public class PlayAgainButton extends Button
{

	private GameStateManager gsm;

	public PlayAgainButton(int posX, int posY, GameStateManager gsm) 
	{
		super(constants.PLAYAGAINBUTTON, posX, posY);
		this.gsm = gsm;
	}

	@Override
	public void onClick()
	{
		data.setSCORE(0);
		gsm.changeState(GameStateManager.LEVEL1);
	}

}
