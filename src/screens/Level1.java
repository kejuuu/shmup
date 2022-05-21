package screens;

import java.awt.*;

import GUI.HeartGUI;
import GUI.ScoreGUI;
import GameFrame.GamePanel;
import entity.PlayerShip;
import entity.ShootParticle;
import entity.Spawner;
import states.GameState;
import states.GameStateManager;
import utils.Background;
import utils.Transform;
import utils.Constants;
import utils.Data;

public class Level1 extends GameState
{
	private final PlayerShip player;

	public Level1(GameStateManager gsm) 
	{
		this.gsm = gsm;

		new Background(Constants.BACKGROUND, 1);
		new Spawner(3000);
		new ShootParticle(new Transform(-100, -100, 0));
		this.player = new PlayerShip(Constants.PLAYER, 5);
		new HeartGUI(Constants.PLAYER, 50, GamePanel.getScreenHeight());
		new ScoreGUI(10, 50, false);
	}

	public void update()
	{
		for (int i = 0; i < Data.gameDrawable.size(); i++)
			Data.gameDrawable.get(i).update();

		for (int i = 0; i < Data.gameAnimatedSprites.size(); i++)
			Data.gameAnimatedSprites.get(i).update();


		Data.SCORE += GamePanel.deltaTime() * 0.1;

		if (player.getHealth() <= 0)
		{
			// Pergi ke state gameover
			gsm.changeState(GameStateManager.GAMEOVER);
		}
	}

	public void draw(Graphics2D g)
	{
		for (int i = 0; i < Data.gameDrawable.size(); i++)
			Data.gameDrawable.get(i).draw(g);

		for (int i = 0; i < Data.gameAnimatedSprites.size(); i++)
			Data.gameAnimatedSprites.get(i).draw(g);
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
