package screens;

import java.awt.*;

import GUI.MainmenuButton;
import GUI.PlayAgainButton;
import GUI.ScoreGUI;
import utils.Background;
import utils.constants;
import utils.data;
import states.GameState;
import states.GameStateManager;

public class GameOver extends GameState 
{
    private PlayAgainButton playAgainButton;
    private MainmenuButton mainMenuButton;
    public GameOver(GameStateManager gsm) 
    {
        this.gsm = gsm;
        new ScoreGUI(720,600);
        playAgainButton = new PlayAgainButton(640, 800, gsm);
        mainMenuButton = new MainmenuButton(780, 800, gsm);
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
        if(x > playAgainButton.transform.positionX - playAgainButton.image.getWidth() * 3 / 2 && x < playAgainButton.transform.positionX + playAgainButton.image.getWidth() * 3 / 2 &&
                y > playAgainButton.transform.positionY - playAgainButton.image.getHeight() * 3 / 2 && y < playAgainButton.transform.positionY + playAgainButton.image.getHeight() * 3 / 2)
        {
            playAgainButton.onClick();
        }
        if(x > mainMenuButton.transform.positionX - mainMenuButton.image.getWidth() * 3 / 2 && x < mainMenuButton.transform.positionX + mainMenuButton.image.getWidth() * 3 / 2 &&
                y > mainMenuButton.transform.positionY - mainMenuButton.image.getHeight() * 3 / 2 && y < mainMenuButton.transform.positionY + mainMenuButton.image.getHeight() * 3 / 2)
        {
            mainMenuButton.onClick();
        }
    }

    @Override
    public void mouseReleased(int x, int y) 
    {
        
    }    
}
