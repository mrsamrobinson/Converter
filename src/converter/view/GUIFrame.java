package converter.view;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import converter.controller.Controller;

/**
 * JFrame for the Converter Application.
 * 
 * @author Sam Robinson
 * @version 1.3 1/28/14 Created frame, added Window Listener,
 * Added application Icon image, fixed Window Listener.
 */
public class GUIFrame extends JFrame
{
	/**
	 * Creates a reference to baseController.
	 */
	private Controller baseController;

	/**
	 * Creates a new GUIPanel named basePanel.
	 */
	private GUIPanel basePanel;
	
	/**
	 * The Image itself.
	 */
	private Image icon;
	
	/**
	 * URL for the image.
	 */
	private URL url;

	/**
	 * Constructor for the GUIFrame.
	 * 
	 * @param baseController
	 */
	public GUIFrame(Controller baseController)
	{
		this.baseController = baseController;
		basePanel = new GUIPanel(baseController);
		
		url = getClass().getResource("/converter/view/images/icon.jpg");
		
		icon = new ImageIcon(url).getImage();

		setupFrame();
		setupListener();
	}

	/**
	 * Sets up the JFrame.
	 */
	private void setupFrame()
	{	
		this.setContentPane(basePanel);
		this.setIconImage(icon);
		this.setTitle("Converter 1.0");
		this.setSize(600, 450);
		this.setVisible(true);
	}

	public void setupListener()
	{
		this.addWindowListener(new WindowListener()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}

			@Override
			public void windowOpened(WindowEvent e)
			{
				
			}

			@Override
			public void windowClosed(WindowEvent e)
			{
				
			}

			@Override
			public void windowIconified(WindowEvent e)
			{
				
			}

			@Override
			public void windowDeiconified(WindowEvent e)
			{
				
			}

			@Override
			public void windowActivated(WindowEvent e)
			{
				
			}

			@Override
			public void windowDeactivated(WindowEvent e)
			{
				
			}

		});

	}

}
