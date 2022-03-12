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

	public static final int SCREEN_WIDTH = 1920;
	public static final int SCREEN_HEIGHT = 1080;
	public static final int SCALE = 1;

	private Thread thread;
	private boolean running;
	private int FPS = 60;
	private long tpf = 1000 / FPS;

	private BufferedImage image;
	private Graphics2D g;

	private GameStateManager gsm;

	GamePanel() 
	{
		super();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		requestFocus();
	}

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

	private void init()
	{
		image = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		running = true;

		gsm = new GameStateManager();
	}

	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
		g2.dispose();
	}

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
			try
			{
				if (wait < 1)
					Thread.sleep(1);
				else
					Thread.sleep(wait);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private void update()
	{
		gsm.update();
	}

	private void draw()
	{
		gsm.draw(g);
	}

	public void keyTyped(KeyEvent k)
	{

	}

	// public void keyPressed(KeyEvent k) {
	// gsm.keyPressed(k.getKeyCode());
	// }

	// public void keyReleased(KeyEvent k) {
	// gsm.keyReleased(k.getKeyCode());
	// }

	public void mousePressed(MouseEvent m)
	{
		gsm.mousePressed(m.getX(), m.getY());
	}

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

}