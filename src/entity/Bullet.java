package entity;

import utils.PhysicsGameObject;
import GameFrame.GamePanel;

public abstract class Bullet extends PhysicsGameObject
{
    protected int speed;
    
    public Bullet(String path, int speed, int zIndex) 
    {
        super(path, zIndex);
        this.speed = speed;
    }

    public void update()
    {
        super.update();
        
        if(transform.getPositionX() < 0 || transform.getPositionY() > GamePanel.getScreenHeight())
            destroy(this);
    }

    public abstract void onCollide(PhysicsGameObject collider);
}
