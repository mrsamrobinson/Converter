package converter.view;

import javax.swing.JFrame;
import converter.controller.Controller;

/**
 * JFrame for the Converter Application.
 * @author Sam Robinson
 * @version 1.0 1/22/14 Created frame.
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
	 * Constructor for the GUIFrame.
	 * @param baseController
	 */
	public GUIFrame(Controller baseController)
	{
		this.baseController = baseController;
		basePanel = new GUIPanel(baseController);

		setupFrame();
	}

	/**
	 * Sets up the JFrame.
	 */
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setTitle("Converter 1.0");
		this.setSize(600, 450);
		this.setVisible(true);
	}
}
