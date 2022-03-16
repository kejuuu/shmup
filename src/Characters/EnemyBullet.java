package Characters;

public class EnemyBullet extends Bullet{
    public EnemyBullet(String path, int speed) {
        super(path, speed);
    }

    @Override
    public void update() {
        super.update();
        transform.positionY += speed;
    }

    @Override
    public void onCollide(String collider) {
        if (collider.equals("Player"))
        {
            destroy(this);
        }
    }
    
}
