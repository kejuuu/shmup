package GUI;
import utils.GameObject;

public abstract class Button extends GameObject
{
    public Button(String path, int posX, int posY)
    {
        super(path, 15);
        this.transform.setPosition(posX, posY);
    }

    @Override
    public void update()
    {
        
    }
    
    public abstract void onClick();
}
