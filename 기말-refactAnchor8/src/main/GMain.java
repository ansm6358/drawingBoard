package main;

import java.lang.reflect.InvocationTargetException;

public class GMain {

	static private GMainFrame mainframe;
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		GMainFrame mainframe = new GMainFrame();
		mainframe.initialize();
		mainframe.setVisible(true);
		
	}

}
