package GUI;

import utils.GameObject;

public abstract class Button extends GameObject
{
	
	/**
	 * Create a button to the given position
	 * @param posX is the horizontal position
	 * @param posY is the vertical position
	 */
	public Button(String path, int posX, int posY) 
	{
		super(path, 15);
		this.transform.setPosition(posX, posY);
	}

	@Override
	public void update()
	{

	}

	/**
	 * Abstract method to implement onClick events
	 */	
	public abstract void onClick();
}
