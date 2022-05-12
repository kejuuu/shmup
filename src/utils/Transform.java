package utils;

public class Transform
{
	private int positionX = 0;
	private int positionY = 0;

	private int rotation = 0;

	public Transform() {
		positionX = 0;
		positionY = 0;
		rotation = 0;
	}

	public Transform(int x, int y, int rotation) {
		positionX = x;
		positionY = y;
		this.rotation = rotation;
	}

	public void setPosition(int x, int y)
	{
		this.positionX = x;
		this.positionY = y;
	}

	public void setRotation(int rotation)
	{
		this.rotation = rotation;
	}
	
	public int getPositionX()
	{
		return positionX;
	}

	public void setPositionY(int y)
	{
		this.positionY = y;
	}
	
	public int getPositionY()
	{
		return positionY;
	}

	public int getRotation()
	{
		return rotation;
	}
}
