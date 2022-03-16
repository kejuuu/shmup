package utils;

public abstract class Collidable extends GameObject {

    public Collidable(String path)
    {
        super(path);
        data.collideObject.add(this);
    }

    @Override
    public void update()
    {
        for(int i=0;i<data.collideObject.size();i++)
        {
            if(data.collideObject.get(i) == this)
                continue;
            if(Collision.checkCollision(this, data.collideObject.get(i)))
            {
                onCollide(data.collideObject.get(i).getClass().getSimpleName());
            }
        }  
    }

    public abstract void onCollide(String collider);
}
