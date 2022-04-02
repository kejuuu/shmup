package Characters;

import java.util.Random;

import utils.AnimatedSprite;
import utils.Transform;
import utils.constants;

public class ShootParticle extends AnimatedSprite
{
    public ShootParticle(Transform transform) 
    {   
        super("shootParticle", constants.SHOOT_PARTICLE, 31, transform);
        Transform t = new Transform();
        t.setPosition(transform.positionX, transform.positionY);
        t.rotation = new Random().nextInt(360);
        this.transform = t;
    }
}