package states;

public abstract class GameState
{
	protected GameStateManager gsm;

	public void update()
	{
		
	};

	public abstract void draw(java.awt.Graphics2D g);

	// public abstract void keyPressed(int k);

	// public abstract void keyReleased(int k);

	public abstract void mousePressed(int x, int y);

	public abstract void mouseReleased(int x, int y);
}
