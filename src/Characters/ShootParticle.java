package Characters;

import utils.AnimatedSprite;
import utils.Transform;
import utils.constants;

public class ShootParticle extends AnimatedSprite
{
    public ShootParticle() {
        super("shootParticle", constants.SHOOT_PARTICLE, 31, new Transform());
    }
}