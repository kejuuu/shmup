package screens;

import java.awt.*;

import Characters.Player;
import Characters.ShootParticle;
import Characters.Spawner;
import GUI.HeartGUI;
import GUI.ScoreGUI;
import GameFrame.GamePanel;
import states.GameState;
import states.GameStateManager;
import utils.Background;
import utils.Transform;
import utils.constants;
import utils.data;

public class Level1 extends GameState
{
	private Player player;

	public Level1(GameStateManager gsm) 
	{
		this.gsm = gsm;

		new Background(constants.BACKGROUND, 1);
		new Spawner(3000);
		new ShootParticle(new Transform(-100, -100, 0));
		this.player = new Player(constants.PLAYER, 5);
		new HeartGUI(constants.PLAYER, 50, GamePanel.getScreenHeight());
		new ScoreGUI(10, 50, false);
	}

	public void update()
	{
		for (int i = 0; i < data.getGameDrawable().size(); i++)
			data.getGameDrawable().get(i).update();

		for (int i = 0; i < data.getGameAnimatedSprites().size(); i++)
			data.getGameAnimatedSprites().get(i).update();


		data.addSCORE((int) (GamePanel.deltaTime() * 0.1));

		if (player.getHealth() <= 0)
		{
			// Pergi ke state gameover
			gsm.changeState(GameStateManager.GAMEOVER);
		}
	}

	public void draw(Graphics2D g)
	{
		for (int i = 0; i < data.getGameDrawable().size(); i++)
			data.getGameDrawable().get(i).draw(g);

		for (int i = 0; i < data.getGameAnimatedSprites().size(); i++)
			data.getGameAnimatedSprites().get(i).draw(g);
	}

	public void mousePressed(int x, int y)
	{
		player.setFiring(true);
	}

	public void mouseReleased(int x, int y)
	{
		player.setFiring(false);
	}
}
