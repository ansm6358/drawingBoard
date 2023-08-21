package toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
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
	private Vector<JToggleButton> buttons;
	private ActionHandler actionHandler;
	//private JPanel allPannel;
	private JPanel changePannel;
	private JPanel firstPannel;
	private JPanel fixPannel;
	private JButton currentButton;
	private boolean first;
	// associations
	private GDrawingPanel drawingPanel;

	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public GToolBar() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		ButtonGroup buttonGroup = new ButtonGroup();
		
		this.setBackground(Color.GREEN);
		this.setLayout(new BorderLayout(0,30));
		
		this.buttons = new Vector<JToggleButton>();
		this.actionHandler = new ActionHandler();
		this.first = true;
		
		this.firstPannel = new JPanel();
		this.firstPannel.setLayout(new BoxLayout(this.firstPannel, BoxLayout.Y_AXIS));
		this.firstPannel.setBackground(Color.GREEN);
		
		this.fixPannel = new JPanel();
		this.fixPannel.setLayout(new BoxLayout(this.fixPannel, BoxLayout.Y_AXIS));
		this.fixPannel.setBackground(Color.GREEN);
		
		this.changePannel = new JPanel();
		this.changePannel.setLayout(new BoxLayout(this.changePannel, BoxLayout.Y_AXIS));
		this.changePannel.setBackground(Color.GREEN);
		
		JLabel lable = new JLabel("현재 도형");
		this.fixPannel.add(lable);
		this.currentButton = new JButton();
		currentButton.setToolTipText("asdf");
		currentButton.setBorderPainted(false); 
		currentButton.setContentAreaFilled(false);
		currentButton.setFocusable(false);
		this.fixPannel.add(currentButton);
		this.add(this.fixPannel, BorderLayout.NORTH);
		
		for (EShapeType eShapeType : EShapeType.values()) {
			JToggleButton shapeType = new JToggleButton(eShapeType.getText());
			shapeType.addActionListener(this.actionHandler);
			shapeType.setActionCommand(eShapeType.getMethod());
			shapeType.setFocusable(false);
			this.buttons.add(shapeType);
			this.firstPannel.add(shapeType);
			buttonGroup.add(shapeType);
		}
		
		this.add(this.firstPannel);

		
	}

	public void initialize() {
		this.buttons.get(EShapeType.nomal.ordinal()).doClick();
		this.buttons.get(ENormal.rectangle.ordinal()).doClick();
		this.resetTool();
		this.first = true;
		//this.buttons.get(EToolBar.rectangle.ordinal()).doClick();
	}

	private void resetTool() {
		this.remove(this.changePannel);
		this.add(this.firstPannel);
		this.updateUI();
	}
	public void normaltypee() {
		ButtonGroup buttonGroup = new ButtonGroup();
		this.buttons.clear();
		this.changePannel.removeAll();
		
		for (ENormal eMenuItem : ENormal.values()) {
			JToggleButton menuItem = new JToggleButton(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.name());
			menuItem.addActionListener(this.actionHandler);
			menuItem.setFocusable(false);
			this.buttons.add(menuItem);
			this.changePannel.add(menuItem);
			buttonGroup.add(menuItem);
			if(this.currentButton.getText().equals(eMenuItem.getText())) {
				this.first = false;
				menuItem.doClick();
			}
		}
		this.remove(this.firstPannel);
		this.add(this.changePannel);
		this.updateUI();
	}

	public void roundType() {
		ButtonGroup buttonGroup = new ButtonGroup();
		this.buttons.clear();
		this.changePannel.removeAll();
		
		for (ERound eMenuItem : ERound.values()) {
			JToggleButton menuItem = new JToggleButton(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.name());
			menuItem.addActionListener(this.actionHandler);
			menuItem.setFocusable(false);
			this.buttons.add(menuItem);
			this.changePannel.add(menuItem);
			buttonGroup.add(menuItem);
			if(this.currentButton.getText().equals(eMenuItem.getText())) {
				this.first = false;
				menuItem.doClick();
			}
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
		if(actionCommand.equals(ENormal.back.name())) {
			this.resetTool();
			this.first = true;
		} else {
		if(this.first) {
			this.getClass().getMethod(actionCommand).invoke(this);
			this.first = false;
		} else { 
			this.drawingPanel.setCurrentTool(EToolBar.valueOf(setShape(actionCommand)));
			this.currentButton.setText(EToolBar.valueOf(setShape(actionCommand)).getText());
		}
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
