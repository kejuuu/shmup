package Characters;

import utils.Collidable;
// import java.util.List;

public class PlayerBullet extends Collidable
{
    public int speed;

    public PlayerBullet(String path, int speed) 
    {
        super(path);
        this.speed = speed;
    }

    public void update()
    {
        super.update();
        transform.positionY -= speed;
        
        if(transform.positionY < 0)
            destroy(this);
    }

    @Override
    public void onCollide(String collider)
    {
        destroy(this);
    }

}
