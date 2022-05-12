package states;

import java.util.Map;

import screens.GameOver;
import screens.Level1;
import screens.Menu;
import utils.Data;

public class GameStateManager
{

	private Map<Integer, GameState> states;
	private int currentState;

	public static final int MENU = 0;
	public static final int LEVEL1 = 1;
	public static final int GAMEOVER = 2;

	public GameStateManager() 
	{
		states = new java.util.HashMap<Integer, GameState>();

		currentState = MENU;
		states.put(MENU, new Menu(this));
	}

	public void changeState(int state)
	{
		Data.getGameDrawable().clear();
		Data.getGameCollidables().clear();

		switch (state)
		{
		case MENU:
			states.put(MENU, new Menu(this));
			break;
		case LEVEL1:
			states.put(LEVEL1, new Level1(this));
			break;
		case GAMEOVER:
			states.put(GAMEOVER, new GameOver(this));
			break;
		default:
			break;
		}
		states.remove(currentState);

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
