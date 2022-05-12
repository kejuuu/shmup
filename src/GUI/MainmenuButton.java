package GUI;

import states.GameStateManager;
import utils.constants;
import utils.data;

public class MainmenuButton extends Button
{

	private GameStateManager gsm;

	public MainmenuButton(int posX, int posY, GameStateManager gsm) 
	{
		super(constants.MAINMENUBUTTON, posX, posY);
		this.gsm = gsm;
	}

	@Override
	public void onClick()
	{
		data.setSCORE(0);
		gsm.changeState(GameStateManager.MENU);
	}

}
