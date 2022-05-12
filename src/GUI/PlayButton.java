package GUI;

import states.GameStateManager;

public class PlayButton extends Button
{
	private GameStateManager gsm;

	public PlayButton(String path, int posX, int posY, GameStateManager gsm) 
	{
		super(path, posX, posY);
		this.gsm = gsm;
	}

	@Override
	public void onClick()
	{
		gsm.changeState(GameStateManager.LEVEL1);
	}
}
