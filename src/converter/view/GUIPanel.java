package converter.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import converter.controller.Controller;

public class GUIPanel extends JPanel
{
	/**
	 * Reference to baseController.
	 */
	private Controller baseController;
	
	private JComboBox fromBox;
	
	private JComboBox toBox;
	
	private JTextField inputField;
	
	private JTextArea outputArea;
	
	private JButton convertButton;
	
	private JLabel inputLabel;
	
	private JLabel outputLabel;
	
	private JLabel toLabel;
	
	private SpringLayout baseLayout;
	
	private String[] baseArray;
	
	
	/**
	 * constructor
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
		baseLayout.putConstraint(SpringLayout.SOUTH, toLabel, -39, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, outputLabel, -10, SpringLayout.WEST, outputArea);
		baseLayout.putConstraint(SpringLayout.NORTH, inputLabel, 4, SpringLayout.NORTH, convertButton);
		baseLayout.putConstraint(SpringLayout.EAST, inputLabel, -6, SpringLayout.WEST, inputField);
		baseLayout.putConstraint(SpringLayout.NORTH, inputField, 109, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, outputLabel, 5, SpringLayout.NORTH, outputArea);
		baseLayout.putConstraint(SpringLayout.NORTH, convertButton, -1, SpringLayout.NORTH, inputField);
		baseLayout.putConstraint(SpringLayout.WEST, convertButton, 24, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.NORTH, outputArea, 41, SpringLayout.SOUTH, inputField);
		baseLayout.putConstraint(SpringLayout.EAST, outputArea, -157, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputField, 0, SpringLayout.EAST, outputArea);
		
		setupFromBox();
		setupToBox();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupFromBox()
	{
		baseArray[0] = "Binary";
		baseArray[1] = "Decimal";
		baseArray[2] = "Hexadecimal";
		
		fromBox = new JComboBox(baseArray);
		baseLayout.putConstraint(SpringLayout.WEST, fromBox, -263, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, fromBox, 0, SpringLayout.EAST, inputField);
		baseLayout.putConstraint(SpringLayout.SOUTH, fromBox, -36, SpringLayout.NORTH, inputField);
	}
	
	private void setupToBox()
	{
		baseArray[0] = "Binary";
		baseArray[1] = "Decimal";
		baseArray[2] = "Hexadecimal";
		
		toBox = new JComboBox(baseArray);
		baseLayout.putConstraint(SpringLayout.WEST, toBox, 157, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, toBox, -332, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, toLabel, 27, SpringLayout.EAST, toBox);
		baseLayout.putConstraint(SpringLayout.SOUTH, toBox, -36, SpringLayout.NORTH, inputField);
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
	}
	
	/**
	 * Sets up the Layout.
	 */
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		
	}
}
