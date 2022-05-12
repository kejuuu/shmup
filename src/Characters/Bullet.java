package Characters;

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
        
        if(transform.positionY < 0 || transform.positionY > GamePanel.getScreenHeight())
            destroy(this);
    }

    public abstract void onCollide(PhysicsGameObject collider);
}
