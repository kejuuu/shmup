package GUI;

public class ExitButton extends Button
{

	/**
	 * Create a Exit button to the given position
	 * @param posX is the horizontal position
	 * @param posY is the vertical position
	 */
	public ExitButton(String path, int posX, int posY) 
	{
		super(path, posX, posY);
	}

	/**
	 * Close the application when clicked
	 */
	@Override
	public void onClick()
	{
		System.exit(0);
	}
}
