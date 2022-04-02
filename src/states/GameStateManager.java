package states;

import java.util.ArrayList;
import screens.Level1;
import screens.Menu;

public class GameStateManager
{

	public ArrayList<GameState> states;
	private int currentState;

	public static final int MENU = 0;
	public static final int LEVEL1 = 1;
	public static final int DEAD = 2;

	public GameStateManager() 
	{
		states = new ArrayList<GameState>();

		currentState = MENU;
		states.add(new Menu(this));
	}
	
	public void changeState(int state) 
	{
		if(state == LEVEL1)
		{
			states.add(new Level1(this));
		}
		currentState = state;
	}

	public void update()
	{
		states.get(currentState).update();
	}

	public void draw(java.awt.Graphics2D g)
	{
		states.get(currentState).draw(g);
	}

	// public void keyPressed(int k) {
	// states.get(currentState).keyPressed(k);
	// }

	// public void keyReleased(int k) {
	// states.get(currentState).keyReleased(k);
	// }

	public void mousePressed(int x, int y)
	{
		states.get(currentState).mousePressed(x, y);
	}

	public void mouseReleased(int x, int y)
	{
		states.get(currentState).mouseReleased(x, y);
	}
}
