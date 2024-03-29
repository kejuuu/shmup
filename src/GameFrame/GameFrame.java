package GameFrame;

import javax.swing.JFrame;

public class GameFrame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3868855034012153296L;

	/**
	 * Create a new GameFrame
	 * with a title of "Plane Strike I"
	 * and set it to fullscreen
	 */
	public GameFrame() 
	{
		this.add(new GamePanel());
		this.setTitle("Plane Strike I");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.dispose();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}