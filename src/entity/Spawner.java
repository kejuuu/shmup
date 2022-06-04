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


	/**
	 * Create a spawner with a given spawn rate
	 * this will spawn enemy based on the spawnrate
	 * @param spawnRate  interval for each enemy spawn (in milliseconds)
	 */
	public Spawner(float spawnRate) 
	{
		super(Constants.EMPTY, -99);
		this.spawnRate = spawnRate; // in milliseconds
	}

	
	/**
	 * This method is called once every frame.
	 * add the timer with deltaTime and check if the timer is greater than the spawnRate
	 * if so, spawn an enemy
	 */
	public void update()
	{
		spawnTimer += GamePanel.deltaTime();
		if (spawnTimer >= spawnRate)
		{
			spawnTimer = 0;
			spawn();
		}
	}


	/**
	 * spawn a single enemy with a randomX position at the top of the screen
	 * also set a random speed for the enemy and reduce the spawnRate
	 */
	private void spawn()
	{
		Random rng = new Random();
		int x = rng.nextInt(GamePanel.getScreenWidth() - width);
		int y = -height;
		EnemyShip enemy = new EnemyShip(Constants.ENEMY1, 5);
		enemy.transform.setPosition(x, y);
		enemy.setSpeed(rng.nextInt(Data.WAVE + 1) + 1);

		spawnedEnemy++;
		if (spawnedEnemy >= waveTreshold)
		{
			Data.WAVE += 1;
			waveTreshold = Data.WAVE * 2;
			spawnedEnemy = 0;
			spawnRate -= 250f;
			if (spawnRate <= 600)
			{
				spawnRate = 600;
			}
		}
	}
}
