package toolbar;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import drawingPanel.GDrawingPanel;
import global.Constants.ENormal;
import global.Constants.ERound;
import global.Constants.EShapeType;
import global.Constants.EToolBar;

public class GToolBar extends JToolBar {

	// atribute
	private static final long serialVersionUID = 1L;

	// components
	private Vector<JRadioButton> buttons;
	private ActionHandler actionHandler;
	private JPanel changePannel;
	private JPanel firstPannel;
	private boolean first;
	// associations
	private GDrawingPanel drawingPanel;

	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public GToolBar() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		//ButtonGroup buttonGroup = new ButtonGroup();
		
		this.setLayout(new GridLayout(0, 1));
		this.firstPannel = new JPanel();
		this.firstPannel.setLayout(new BoxLayout(this.firstPannel, BoxLayout.Y_AXIS));
		
		this.buttons = new Vector<JRadioButton>();
		this.actionHandler = new ActionHandler();
		this.first = true;
		for (EShapeType eShapeType : EShapeType.values()) {
			JButton shapeType = new JButton(eShapeType.getText());
			shapeType.addActionListener(this.actionHandler);
			shapeType.setActionCommand(eShapeType.getMethod());
			//this.getClass().getMethod(eShapeType.getMethod()).invoke(this);
			this.firstPannel.add(shapeType);
		}
		
		this.add(this.firstPannel);
		
		// for (EToolBar eToolBar: EToolBar.values()) {
		// JRadioButton button = new JRadioButton(eToolBar.getText());
		// button.setActionCommand(eToolBar.name());
		// button.addActionListener(actionHandler);
		// this.buttons.add(button);
		// this.add(button);
		// buttonGroup.add(button);
		// }

	}

	public void initialize() {
		//this.buttons.get(EToolBar.rectangle.ordinal()).doClick();
	}

	private void resetTool() {
		this.remove(this.changePannel);
		this.add(this.firstPannel);
		this.updateUI();
	}
	public void normaltypee() {
		this.changePannel = new JPanel();
		this.changePannel.setLayout(new BoxLayout(this.changePannel, BoxLayout.Y_AXIS));
		for (ENormal eMenuItem : ENormal.values()) {
			JButton menuItem = new JButton(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.name());
			menuItem.addActionListener(this.actionHandler);
			this.changePannel.add(menuItem);
		}
		this.remove(this.firstPannel);
		this.add(this.changePannel);
		this.updateUI();
	}

	public void roundType() {
		this.changePannel = new JPanel();
		this.changePannel.setLayout(new BoxLayout(this.changePannel, BoxLayout.Y_AXIS));
		for (ERound eMenuItem : ERound.values()) {
			JButton menuItem = new JButton(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.name());
			menuItem.addActionListener(this.actionHandler);
			this.changePannel.add(menuItem);
		}
		this.remove(this.firstPannel);
		this.add(this.changePannel);
		this.updateUI();
	}

	private String setShape(String actionCommand) {
		for (EToolBar eToolBar : EToolBar.values()) {
			if (eToolBar.name().equals(actionCommand)) {
				return eToolBar.name();
			}
		}
		return null;
	}

	public void chage(String actionCommand) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		if(this.first) {
			this.getClass().getMethod(actionCommand).invoke(this);
			this.first = false;
		} else {
			drawingPanel.setCurrentTool(EToolBar.valueOf(setShape(actionCommand)));
			this.resetTool();
			this.first = true;
		}
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			try {
				chage(event.getActionCommand());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	

}
