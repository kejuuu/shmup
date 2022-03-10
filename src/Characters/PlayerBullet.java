package Characters;

import java.awt.Rectangle;
import utils.GameObject;

public class PlayerBullet extends GameObject{
    public int speed;
    public PlayerBullet(String path, int speed) {
        super(path);
        this.speed = speed;
    }

    public void update() {
        transform.positionY -= speed;
        //check collision with class enemy
    }    
}
