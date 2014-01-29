package converter.controller;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.JOptionPane;

import converter.view.GUIFrame;
import converter.view.GUIPanel;

/**
 * Controller for the Converter application.
 * 
 * @author Sam Robinson
 * @version 1.7 Created the GUIFrame for the application window, initialized the
 *          Frame in start(), added documentation, started determineFunction()
 *          method, added binToDec() method, finished Decimal to Binary
 *          conversion process, finished Binary to Decimal conversion process,
 *          added Binary to Hexadecimal conversion, polished binToDec() method,
 *          added Decimal to Hexadecimal conversion, added Hex to decimal and
 *          binary conversions, added documentation.
 */
public class Controller
{
	/**
	 * Creates an instance of the GUIFrame for the application window.
	 */
	private GUIFrame converterFrame;

	/**
	 * Constructor for the Controller (not being used).
	 */
	public Controller()
	{

	}

	/**
	 * Start method called in the Runner to start the program.
	 */
	public void start()
	{

		converterFrame = new GUIFrame(this);
	}

	/**
	 * Determines which conversion algorithm to initialize, then convert it.
	 * 
	 * @param one
	 *            selected Index of the fromBox Combo Box.
	 * @param two
	 *            selected Index of the toBox Combo Box.
	 * @param currentInput
	 *            The text from the inputField TextField.
	 * @return
	 */
	public String determineFunction(int one, int two, String currentInput)
	{
		String output = "";
		String currentFunction = "" + one + two;

		if (currentFunction.equals("00"))
		{
			// Binary to Binary.

			// Gives the current input as the output.
			output = currentInput;
		}
		else if (currentFunction.equals("11"))
		{
			// Decimal to Decimal.

			// Gives the current input as the output.
			output = currentInput;
		}
		else if (currentFunction.equals("22"))
		{
			// Hex to Hex.

			// Gives the current input as the output.
			output = currentInput;
		}
		else if (currentFunction.equals("01"))
		{
			// Binary to Decimal.

			// Runs a custom built conversion process.
			output = binToDec(currentInput);
		}
		else if (currentFunction.equals("02"))
		{
			// Binary to Hexadecimal.

			// Uses built in java method.
			output = new BigInteger(currentInput, 2).toString(16);
		}
		else if (currentFunction.equals("10"))
		{
			// Decimal to Binary.

			// Uses built in java method.
			int binary = Integer.parseInt(currentInput);

			String inBinary = Integer.toBinaryString(binary);

			output = inBinary;
		}
		else if (currentFunction.equals("12"))
		{
			// Decimal to Hexadecimal.

			// Converts decimal to Binary, then from Binary to Hexadecimal.
			int binary = Integer.parseInt(currentInput);

			String inBinary = Integer.toBinaryString(binary);

			output = new BigInteger(inBinary, 2).toString(16);
		}
		else if (currentFunction.equals("20"))
		{
			// Hexadecimal to Binary.

			// Converts Hex to Decimal, then from Decimal to Binary.
			int temp = Integer.parseInt(currentInput, 16);

			output = Integer.toBinaryString(temp);
		}
		else if (currentFunction.equals("21"))
		{
			// Hexadecimal to Decimal.

			// Color test = Color.decode(currentInput);

			// Converts Hex to Decimal in a single step.
			int temp = Integer.parseInt(currentInput, 16);

			output = Integer.toString(temp);

		}

		return output;
	}

	private String binToDec(String input)
	{
		double result = 0;

		String newInput = "";

		for (int temp = input.length(); temp > 0; temp--)
		{
			newInput += input.substring(temp - 1, temp);
		}

		for (int i = 0; i < newInput.length(); i++)
			result = result + Double.parseDouble(newInput.substring(i, i + 1)) * Math.pow(2, i);

		String output = Double.toString(result);

		output = output.substring(0, output.length() - 2);

		return output;
	}

}
