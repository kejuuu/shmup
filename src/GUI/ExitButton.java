package GUI;

public class ExitButton extends Button
{

	public ExitButton(String path, int posX, int posY) 
	{
		super(path, posX, posY);
	}

	@Override
	public void onClick()
	{
		System.exit(0);
	}
}
