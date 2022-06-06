package GameFrame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

import states.GameStateManager;

public class GamePanel extends JPanel implements Runnable, /* KeyListener */ MouseListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 643646138463852373L;

	private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final int SCREEN_WIDTH = (int) screenSize.getWidth();
	private static final int SCREEN_HEIGHT = (int) screenSize.getHeight();
	private static final int WIDTH_SCALE_FACTOR = (int) SCREEN_WIDTH / 1920;
	private static final int HEIGHT_SCALE_FACTOR = (int) SCREEN_HEIGHT / 1080;

	private Thread thread;
	private boolean running;
	private static int FPS = 60;
	private static long tpf = 1000 / FPS;

	/**
	 * Get the game's deltaTime,
	 * this will be used to calculate the time between frames
	 * and create framerate independent movement of objects
	 * @return the time passed between two frames 
	 */
	public static long deltaTime()
	{
		return tpf;
	}

	private BufferedImage image;
	private Graphics2D g;
	private GameStateManager gsm;

	/**
	 * Create a new fullscreen gamepanel and request focus to this panel
	 */
	GamePanel() 
	{
		super();
		this.setPreferredSize(screenSize);
		this.setMinimumSize(screenSize);
		this.setBackground(Color.black);
		this.setFocusable(true);
		requestFocus();
	}

	/**
	 * create a new thread, add input listener to it.
	 */
	public void addNotify()
	{
		super.addNotify();
		if (thread == null)
		{
			thread = new Thread(this);
			// addKeyListener(this);
			addMouseListener(this);
			thread.start();
		}
	}

	/**
	 * Buffer an image to the screen, and set the running to true.
	 * also create a gamestatemanager to manage the gameState
	 */
	private void init()
	{
		image = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;

		gsm = new GameStateManager();
	}

	/**
	 * get the graphics context and draw the image
	 * also disposes the graphic context and release the unused memory
	 */
	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
		g2.dispose();
	}

	/**
	 * run the thread every single frame
	 * to create framerate independent movement of objects
	 * the thread has to be delayed so that each frame runs for the same amount of time
	 */
	public void run()
	{
		init();

		long start;
		long elapsed;
		long wait;

		while (running)
		{
			start = System.nanoTime();
			update();
			draw();
			drawToScreen();
			elapsed = System.nanoTime() - start;
			wait = tpf - (elapsed / 1000000);

			// this code delays the frame so that it runs at the same speed regardless of the framerate
			try
			{
				if (wait < 1)
					Thread.sleep(1);
				else
					Thread.sleep(wait);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * updates the gameStateManager
	 */
	private void update()
	{
		gsm.update();
	}

	/**
	 * draw the gameStateManager's graphics
	 */
	private void draw()
	{
		gsm.draw(g);
	}

	/**
	 * Event listener to the event of the mouse being pressed
	 * @param m the mouse event
	 */
	public void mousePressed(MouseEvent m)
	{
		gsm.mousePressed(m.getX(), m.getY());
	}

	/**
	 * Event listener to the event of the mouse being released
	 * @param m the mouse event
	 */
	public void mouseReleased(MouseEvent m)
	{
		gsm.mouseReleased(m.getX(), m.getY());
	}

	public void mouseEntered(MouseEvent m)
	{

	}

	public void mouseExited(MouseEvent m)
	{

	}

	public void mouseClicked(MouseEvent m)
	{
	}

	/**
	 * get the current device screen size
	 * @return the current device screen size
	 */
	public static Dimension getScreensize()
	{
		return screenSize;
	}

	/**
	 * get the current device screen width
	 * @return the current device screen width
	 */
	public static int getScreenWidth()
	{
		return SCREEN_WIDTH;
	}

	/**
	 * get the current device screen height
	 * @return the current device screen height
	 */
	public static int getScreenHeight()
	{
		return SCREEN_HEIGHT;
	}
	
	/**
	 * get the current device width scale factor
	 * @return the current device width scale factor
	 */
	public static int getWidthScaleFactor()
	{
		return WIDTH_SCALE_FACTOR;
	}

	/**
	 * get the current device height scale factor
	 * @return the current device height scale factor
	 */
	public static int getHeightScaleFactor()
	{
		return HEIGHT_SCALE_FACTOR;
	}

}