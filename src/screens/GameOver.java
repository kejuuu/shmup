package screens;

import java.awt.*;

import GUI.ScoreGUI;
import utils.Background;
import utils.constants;
import utils.data;
import states.GameState;
import states.GameStateManager;

public class GameOver extends GameState 
{
    private ScoreGUI scoreGUI;
    public GameOver(GameStateManager gsm) 
    {
        this.gsm = gsm;
        scoreGUI = new ScoreGUI(720,1000);
        new Background(constants.GAMEOVERBACKGROUND, 0);
    }

    @Override 
    public void update() 
    { 
        for (int i = 0; i < data.gameDrawable.size(); i++)
            data.gameDrawable.get(i).update();
    }

    @Override
    public void draw(Graphics2D g) 
    {
        for (int i = 0; i < data.gameDrawable.size(); i++)
            data.gameDrawable.get(i).draw(g);
    }

    @Override
    public void mousePressed(int x, int y) 
    {
        
    }

    @Override
    public void mouseReleased(int x, int y) 
    {
        
    }    
}
