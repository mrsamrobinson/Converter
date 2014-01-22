package converter.controller;

import converter.view.GUIFrame;

public class Controller
{
	private GUIFrame ConverterFrame;
	
	public Controller()
	{
		
	}
	
	public void start()
	{
		
		ConverterFrame = new GUIFrame(this);
	}
	
}
