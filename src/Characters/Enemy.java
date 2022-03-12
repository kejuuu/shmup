package Characters;

import utils.GameObject;

public class Enemy extends GameObject
{
    int health = 5;

    public Enemy(String path, int health) {
        super(path);
        this.health = health;
    }

    public void onCollide()
    {
        health--;
    }
}
