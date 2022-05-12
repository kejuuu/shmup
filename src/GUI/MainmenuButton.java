package GUI;

import states.GameStateManager;
import utils.Constants;
import utils.Data;

public class MainmenuButton extends Button
{

	final private GameStateManager gsm;

	public MainmenuButton(int posX, int posY, GameStateManager gsm) 
	{
		super(Constants.MAINMENUBUTTON, posX, posY);
		this.gsm = gsm;
	}

	@Override
	public void onClick()
	{
		Data.setSCORE(0);
		gsm.changeState(GameStateManager.MENU);
	}

}
