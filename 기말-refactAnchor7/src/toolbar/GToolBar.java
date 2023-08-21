package toolbar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import drawingPanel.GDrawingPanel;
import global.Constants.EFileMenu;
import global.Constants.EShape;
import global.Constants.EToolBar;
import global.Constants.EToolBar.GRound;

public class GToolBar extends JToolBar {

	//atribute
	private static final long serialVersionUID = 1L;

	//components
	private Vector<JRadioButton> buttons; 
	private ShapeMenu shapeMenu;
	private ActionHandler actionHandler;
	//associations
	private GDrawingPanel drawingPanel;
	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}	
	public GToolBar() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ButtonGroup buttonGroup = new ButtonGroup();
		
		this.setLayout(new GridLayout(0,1));
		
		this.buttons = new Vector<JRadioButton>();
		this.actionHandler = new ActionHandler();
		
		for (EToolBar eToolBar: EToolBar.values()) {
			JMenu shapeType = new JMenu(eToolBar.getText());
			this.getClass().getMethod(eToolBar.getMethod()).invoke(this);
			//button.setActionCommand(eToolBar.name());
			//button.addActionListener(actionHandler);
			this.add(shapeType);
			//buttonGroup.add(button);
			}
		
		}

	public void initialize() {
		//this.buttons.get(EToolBar.rectangle.ordinal()).doClick();
	}
	
	public void roundType() {
		for (GRound eMenuItem : GRound.values()) {
			JMenuItem menuItem = new JMenuItem(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.name());
			menuItem.addActionListener(actionHandler);
			this.add(menuItem);
		}
	}
	private class ActionHandler implements ActionListener	{

		@Override
		public void actionPerformed(ActionEvent event) {
			drawingPanel.setCurrentTool(EShape.valueOf(event.getActionCommand()));
			
		}	
	}

}
