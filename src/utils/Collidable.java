package utils;

import java.awt.*;


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

    @Override
    public void draw(Graphics2D g)
    {
        super.draw(g);

        if(constants.DEBUG)
        {
            g.setColor(Color.blue);
            g.drawRect(transform.positionX - width * 3 / 2, transform.positionY - height * 3 / 2, width * 3, height * 3);
            g.drawString(getInfo(), transform.positionX - width * 3/2, transform.positionY + height*3);
            g.setColor(Color.black);
        }
    }

    public abstract void onCollide(String collider);
}
