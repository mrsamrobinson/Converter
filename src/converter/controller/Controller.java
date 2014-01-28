package converter.controller;

import java.util.Scanner;

import javax.swing.JOptionPane;

import converter.view.GUIFrame;
import converter.view.GUIPanel;

/**
 * Controller for the Converter application.
 * @author Sam Robinson
 * @version 1.0 Created the GUIFrame for the application window, initialized the Frame in start().
 */
public class Controller
{
	/**
	 * Creates an instance of the GUIFrame for the application window.
	 */
	private GUIFrame ConverterFrame;
	
	/**
	 * Constructor for the Controller.
	 */
	public Controller()
	{

	}
	
	/**
	 * Start method called in the Runner to start the program.
	 */
	public void start()
	{
		
		ConverterFrame = new GUIFrame(this);
	}
	
	public String determineFunction(int one, int two, String currentInput)
	{
		String output = "";
		String currentFunction = "" + one + two;
		
		if(currentFunction.equals("00"))
		{
			JOptionPane.showMessageDialog(null, "That is not a conversion!");
		}
		else if(currentFunction.equals("11"))
		{
			JOptionPane.showMessageDialog(null, "That is not a conversion!");
		}
		else if(currentFunction.equals("22"))
		{
			JOptionPane.showMessageDialog(null, "That is not a conversion!");
		}
		else if(currentFunction.equals("01"))
		{
			output = binToDec(currentInput);
		}
		else if(currentFunction.equals("02"))
		{
//			output = ;
		}
		else if(currentFunction.equals("10"))
		{
			int binary = Integer.parseInt(currentInput);
			
			String inBinary = Integer.toBinaryString(binary);
			
			output = inBinary;
		}
		else if(currentFunction.equals("12"))
		{
//			output = ;
		}
		else if(currentFunction.equals("20"))
		{
//			output = ;
		}
		else if(currentFunction.equals("21"))
		{
//			output = ;
		}
		
		return output;
	}
	
	private String binToDec(String input)
	{
		int a[] = {0, 1};

	    int number;
	    int remainder;
	    String binary = "";

	    Scanner in = new Scanner(System.in);

	    System.out.print("Enter Decimal Number: ");
	    number = Integer.parseInt( in.next());

	    System.out.print("Binary Number in Reverse: ");
	    do {
	        remainder=number%2;
	        if(remainder > 0){
	            binary += a[1];
	            //System.out.print(a[1]);
	        }
	        else{
	            binary += a[0];
	            //System.out.print(a[0]);
	        }
	        number=number / 2;
	    } while(number>0);

	    System.out.print(binary);

	    System.out.print(" \nDecimal number: ");
	    //String s = Integer.toString(number);
	    double result = 0;
	    for (int i = 0; i < binary.length(); i++)
	       result = result + Double.parseDouble(binary.substring(i, i + 1)) * Math.pow(2, i);
	    System.out.print(result);
		
		return input;
	}
	
}
