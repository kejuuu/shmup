package entity;

import GameFrame.GamePanel;
import utils.GameObject;
import utils.Constants;
import utils.Data;

import java.util.Random;

public class Spawner extends GameObject
{

	private float spawnRate = 0;
	private float spawnTimer = 0;

	private int waveTreshold = 3;
	private int spawnedEnemy = 0;

	public Spawner(float spawnRate) 
	{
		super(Constants.EMPTY, -99);
		this.spawnRate = spawnRate; // in milliseconds
	}

	public void update()
	{
		spawnTimer += GamePanel.deltaTime();
		if (spawnTimer >= spawnRate)
		{
			spawnTimer = 0;
			spawn();
		}
	}

	private void spawn()
	{
		Random rng = new Random();
		int x = rng.nextInt(GamePanel.getScreenWidth() - width);
		int y = -height;
		EnemyShip enemy = new EnemyShip(Constants.ENEMY1, 5);
		enemy.transform.setPosition(x, y);
		enemy.setSpeed(rng.nextInt(Data.getWAVE()) + 1);

		spawnedEnemy++;
		if (spawnedEnemy >= waveTreshold)
		{
			Data.setWAVE(Data.getWAVE() + 1);
			waveTreshold = Data.getWAVE() * 2;
			spawnedEnemy = 0;
			spawnRate -= 250f;
			if (spawnRate <= 600)
			{
				spawnRate = 600;
			}
		}
	}
}
