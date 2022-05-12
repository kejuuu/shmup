package entity;

import java.util.Random;

import utils.AnimatedSprite;
import utils.Transform;
import utils.Constants;

public class ShootParticle extends AnimatedSprite
{
	public ShootParticle(Transform transform) 
	{
		super("shootParticle", Constants.SHOOT_PARTICLE, 31, transform);
		Transform t = new Transform();
		t.setPosition(transform.getPositionX(), transform.getPositionY());
		t.setRotation(new Random().nextInt(360));
		this.transform = t;
	}
}