package Characters;

import utils.Collidable;
// import java.util.List;
public abstract class Bullet extends Collidable
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
        
        if(transform.positionY < 0 || transform.positionY > 1080)
            destroy(this);
    }

    public abstract void onCollide(String collider);
}
