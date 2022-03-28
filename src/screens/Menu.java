package screens;

import java.awt.Graphics2D;

import states.GameState;
import states.GameStateManager;

public class Menu extends GameState {

    public Menu(GameStateManager gsm) {
        this.gsm = gsm;
        // new Background(constants.BACKGROUND, 0);
    }

    @Override
    public void update()
    {
        
    }
    
    @Override
    public void draw(Graphics2D g)
    {
        
    }

    @Override
    public void mousePressed(int x, int y)
    {
        gsm.changeState(states.GameStateManager.LEVEL1);
    }

    @Override
    public void mouseReleased(int x, int y)
    {
        
    }


}
