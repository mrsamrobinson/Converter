package converter.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import converter.controller.Controller;
import converter.model.Converter;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The main GUI for the Converter application.
 * 
 * @author Sam Robinson
 * @version 1.4 Created the Panel, added all necessary components to the Panel,
 *          added documentation, added properties to the setupLayout method make
 *          the application window more appealing, added convertButton listener,
 *          added Enter Key listener, changed background color.
 */
public class GUIPanel extends JPanel
{
	/**
	 * Reference to baseController.
	 */
	private Controller baseController;
	/**
	 * Creates a new JComboBox.
	 */
	private JComboBox fromBox;
	/**
	 * Creates a new JComboBox.
	 */
	private JComboBox toBox;
	/**
	 * Creates a new JTextField.
	 */
	public JTextField inputField;
	/**
	 * Creates a new JTextArea.
	 */
	public JTextArea outputArea;
	/**
	 * Creates a new JButton.
	 */
	private JButton convertButton;
	/**
	 * Creates a new JLabel.
	 */
	private JLabel inputLabel;
	/**
	 * Creates a new JLabel.
	 */
	private JLabel outputLabel;
	/**
	 * Creates a new JLabel.
	 */
	private JLabel toLabel;
	/**
	 * Creates a new SpringLayour for layout of the Panel.
	 */
	private SpringLayout baseLayout;
	/**
	 * Creates a String array to set the contents for the ComboBoxes.
	 */
	private String[] baseArray;

	/**
	 * Constructor
	 * 
	 * @param baseController
	 */
	public GUIPanel(Controller baseController)
	{
		this.baseController = baseController;

		inputField = new JTextField(35);
		outputArea = new JTextArea(5, 35);
		convertButton = new JButton("Convert");
		inputLabel = new JLabel("Input:");
		outputLabel = new JLabel("Output:");
		toLabel = new JLabel("to");

		baseArray = new String[3];

		baseLayout = new SpringLayout();

		setupFromBox();
		setupToBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	/**
	 * Sets the contents of the JComboBox 'fromBox'.
	 */
	private void setupFromBox()
	{
		baseArray[0] = "Binary";
		baseArray[1] = "Decimal";
		baseArray[2] = "Hexadecimal";

		fromBox = new JComboBox(baseArray);
	}

	/**
	 * Sets the contents of the JComboBox 'toBox'.
	 */
	private void setupToBox()
	{
		baseArray[0] = "Binary";
		baseArray[1] = "Decimal";
		baseArray[2] = "Hexadecimal";

		toBox = new JComboBox(baseArray);
	}

	/**
	 * Sets up the Panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(convertButton);
		this.add(inputField);
		this.add(outputArea);
		this.add(inputLabel);
		this.add(outputLabel);
		this.add(toLabel);
		this.add(fromBox);
		this.add(toBox);

		this.setSize(600, 450);
		this.setBackground(new Color(200, 200, 200));
	}

	/**
	 * Sets up the Layout and constraints for each component in the Panel.
	 */
	private void setupLayout()
	{
		convertButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		inputLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		baseLayout.putConstraint(SpringLayout.NORTH, convertButton, -5, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, convertButton, 30, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.NORTH, inputLabel, 112, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputField, 0, SpringLayout.WEST, outputArea);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, 2, SpringLayout.EAST, outputArea);
		baseLayout.putConstraint(SpringLayout.NORTH, toLabel, 51, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, outputArea, 10, SpringLayout.EAST, outputLabel);
		baseLayout.putConstraint(SpringLayout.EAST, outputArea, -157, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, outputArea, -1, SpringLayout.NORTH, outputLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, outputLabel, 44, SpringLayout.SOUTH, inputLabel);
		baseLayout.putConstraint(SpringLayout.WEST, outputLabel, 99, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, outputLabel, 149, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, inputLabel, 111, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputLabel, 151, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, toLabel, 295, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 38, SpringLayout.SOUTH, toBox);
		baseLayout.putConstraint(SpringLayout.NORTH, toBox, 52, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, toBox, 20, SpringLayout.EAST, toLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, toBox, 75, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, toBox, 135, SpringLayout.EAST, toLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, fromBox, 0, SpringLayout.NORTH, toLabel);
		baseLayout.putConstraint(SpringLayout.WEST, fromBox, 159, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, fromBox, 23, SpringLayout.NORTH, toLabel);
		baseLayout.putConstraint(SpringLayout.EAST, fromBox, 274, SpringLayout.WEST, this);
	}

	/**
	 * Button and ComboBox listeners.
	 */
	private void setupListeners()
	{
		convertButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				outputArea.setText("");
				String output = baseController.determineFunction(fromBox.getSelectedIndex(), toBox.getSelectedIndex(), inputField.getText());
				outputArea.append(output);
			}
		});

		inputField.addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyChar() == KeyEvent.VK_ENTER)
				{
					outputArea.setText("");
					String output = baseController.determineFunction(fromBox.getSelectedIndex(), toBox.getSelectedIndex(), inputField.getText());
					outputArea.append(output);
				}
			}

			public void keyReleased(KeyEvent e)
			{

			}

			public void keyTyped(KeyEvent e)
			{

			}
		});
	}
}
