package states;

import java.util.ArrayList;
import screens.Level1;

public class GameStateManager {

	public ArrayList<GameState> states;
	private int currentState;

	public static final int MENU = 0;
	public static final int LEVEL1 = 1;
	public static final int DEAD = 2;

	public GameStateManager() {
		states = new ArrayList<GameState>();

		currentState = MENU;
		states.add(new Level1(this));
	}

	public void update() {
		states.get(currentState).update();
	}

	public void draw(java.awt.Graphics2D g) {
		states.get(currentState).draw(g);
	}

	public void keyPressed(int k) {
		states.get(currentState).keyPressed(k);
	}

	public void keyReleased(int k) {
		states.get(currentState).keyReleased(k);
	}
}
