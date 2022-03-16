package Characters;

import utils.GameObject;
import java.awt.MouseInfo;

public class Player extends GameObject
{
    public int health = 5;

    public Player(String path, int health) 
    {
        super(path);
        this.health = health;
    }

    @Override
    public void update()
    {
        transform.setPosition(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
    }

}
