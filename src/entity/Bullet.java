package entity;

import utils.PhysicsGameObject;
import GameFrame.GamePanel;

public abstract class Bullet extends PhysicsGameObject
{
    protected int speed;
    
    /**
     * Create a bullet with a given speed and zIndex
     * @param path      The path to the image of the bullet
     * @param speed     The speed of the bullet
     * @param zIndex    The zIndex of the bullet (for image ordering)
     */
    public Bullet(String path, int speed, int zIndex) 
    {
        super(path, zIndex);
        this.speed = speed;
    }


    /**
     * This method is called once every frame.
     */
    public void update()
    {
        super.update();
        
        // if the bullet if out of the screen, destroy it.
        if(transform.getPositionX() < 0 || transform.getPositionY() > GamePanel.getScreenHeight())
            destroy(this);
    }

    public abstract void onCollide(PhysicsGameObject collider);
}
