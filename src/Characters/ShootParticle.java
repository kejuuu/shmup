package Characters;

import utils.AnimatedSprite;
import utils.Transform;
import utils.constants;

public class ShootParticle extends AnimatedSprite
{
    public ShootParticle(Transform transform) 
    {   
        super("shootParticle", constants.SHOOT_PARTICLE, 31, transform);
    }
}