package Characters;

import java.util.Random;


public class PlayerBullet extends Bullet
{
    public PlayerBullet(String path, int speed) 
    {
        super(path, speed);
    }

    @Override
    public void update()
    {
        super.update();
        transform.positionY -= speed;
    }

    @Override
    public void onCollide(String collider)
    {
        if (collider.equals("Enemy"))
        {
            destroy(this);
            ShootParticle destroyParticle = new ShootParticle();
            destroyParticle.transform = this.transform;
            destroyParticle.transform.rotation = new Random().nextInt(360);
        }
    }
}
