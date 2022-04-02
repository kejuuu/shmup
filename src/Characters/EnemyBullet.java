package Characters;

import utils.Collidable;

public class EnemyBullet extends Bullet{
    public EnemyBullet(String path, int speed) {
        super(path, speed, 2);
    }

    @Override
    public void update() {
        super.update();
        transform.positionY += speed;
    }

    @Override
    public void onCollide(Collidable collider) {
        if (collider.getClass().getSimpleName().equals("Player"))
        {
            destroy(this);
        }
    }
    
}
