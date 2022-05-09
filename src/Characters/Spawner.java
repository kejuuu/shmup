package Characters;

import GameFrame.GamePanel;
import utils.GameObject;
import utils.constants;
import utils.data;

import java.util.Random;

public class Spawner extends GameObject{
        
        private float spawnRate = 0;
        private float spawnTimer = 0;

        private int waveTreshold = 3;
        private int spawnedEnemy = 0;
        
        public Spawner(float spawnRate) {
            super(constants.EMPTY, -99);
            this.spawnRate = spawnRate; // in milliseconds
        }
        
        public void update() {
            spawnTimer += GamePanel.deltaTime();
            if(spawnTimer >= spawnRate) {
                spawnTimer = 0;
                spawn();
            }
        }
        
        public void spawn() {
            Random rng = new Random();
            int x = rng.nextInt(GamePanel.getScreenWidth() - width);
            int y = -height;
            Enemy enemy = new Enemy(constants.ENEMY1, 5);
            enemy.transform.setPosition(x, y);
            enemy.setSpeed(rng.nextInt(data.getWAVE()) + 1);

            spawnedEnemy++;
            if(spawnedEnemy >= waveTreshold) {
                data.setWAVE(data.getWAVE() + 1);
                waveTreshold = data.getWAVE()*2;
                spawnedEnemy = 0;
                spawnRate -= 250f;
                if(spawnRate <= 600) {
                    spawnRate = 600;
                }
            }
        }
}
