package converter.view;

import javax.swing.JFrame;

import converter.controller.Controller;

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
		this.setSize(600, 450);
		this.setVisible(true);
	}
}
