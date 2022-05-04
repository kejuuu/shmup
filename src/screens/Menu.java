package screens;

import java.awt.Graphics2D;

import GUI.ExitButton;
import GUI.PlayButton;
import states.GameState;
import states.GameStateManager;
import utils.Background;
import utils.constants;
import utils.data;

public class Menu extends GameState {

    private PlayButton playButton;
    private ExitButton exitButton;

    public Menu(GameStateManager gsm) {
        this.gsm = gsm;
        new Background(constants.MENUBACKGROUND, 0);
        playButton = new PlayButton(constants.PLAYBUTTON, 960, 900, gsm);
        exitButton = new ExitButton(constants.EXITBUTTON, 1850, 75);
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
        if(x > playButton.transform.positionX - playButton.image.getWidth() * 3 / 2 && x < playButton.transform.positionX + playButton.image.getWidth() * 3 / 2 &&
                y > playButton.transform.positionY - playButton.image.getHeight() * 3 / 2 && y < playButton.transform.positionY + playButton.image.getHeight() * 3 / 2)
        {
            playButton.onClick();
        }
        if(x > exitButton.transform.positionX - exitButton.image.getWidth() * 3 / 2 && x < exitButton.transform.positionX + exitButton.image.getWidth() * 3 / 2 &&
                y > exitButton.transform.positionY - exitButton.image.getHeight() * 3 / 2 && y < exitButton.transform.positionY + exitButton.image.getHeight() * 3 / 2)
        {
            System.exit(0);
        }
    }

    @Override
    public void mouseReleased(int x, int y)
    {
        
    }


}
