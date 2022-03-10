package utils;

public class Transform {
    public int positionX = 0;
    public int positionY = 0;

    public Transform() {
        positionX = 0;
        positionY = 0;
    }

    public Transform(int x, int y)
    {
        positionX = x;
        positionY = y;
    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }
}
