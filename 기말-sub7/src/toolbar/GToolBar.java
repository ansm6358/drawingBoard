package toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import drawingPanel.GDrawingPanel;
import global.Constants.EArrow;
import global.Constants.EImage;
import global.Constants.EImageLocation;
import global.Constants.ENormal;
import global.Constants.EPoly;
import global.Constants.ERectangle;
import global.Constants.ERound;
import global.Constants.ESelect;
import global.Constants.EShapeType;
import global.Constants.ESpecial;
import global.Constants.EToolBar;
import global.Constants.ETriangle;

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
	private ButtonGroup buttonGroup;
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
		currentButton.setToolTipText(" ");
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
		this.buttons.get(ENormal.select.ordinal()+1).doClick();
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
		for (ENormal eMenuItem : ENormal.values()) {
			ImageIcon imageIconTemp = new ImageIcon(eMenuItem.getImage());
			Image image = imageIconTemp.getImage();
			Image imageTemp = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageTemp);
			JToggleButton menuItem = new JToggleButton(imageIcon);
			menuItem.setToolTipText(eMenuItem.getText());
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
	}

	public void roundType() {
		for (ERound eMenuItem : ERound.values()) {
			ImageIcon imageIconTemp = new ImageIcon(eMenuItem.getImage());
			Image image = imageIconTemp.getImage();
			Image imageTemp = image.getScaledInstance(EImage.x.getSize(), EImage.y.getSize(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageTemp);
			JToggleButton menuItem = new JToggleButton(imageIcon);
			menuItem.setToolTipText(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.name());
			menuItem.addActionListener(this.actionHandler);
			menuItem.setFocusable(false);
			this.buttons.add(menuItem);
			this.changePannel.add(menuItem);
			buttonGroup.add(menuItem);
			if(this.currentButton.getText().equals(eMenuItem.getText())) {
				this.first = false;
				menuItem.doClick();
			}}
	}

	public void triangleType() {
		for (ETriangle eMenuItem : ETriangle.values()) {
			ImageIcon imageIconTemp = new ImageIcon(eMenuItem.getImage());
			Image image = imageIconTemp.getImage();
			Image imageTemp = image.getScaledInstance(EImage.x.getSize(), EImage.y.getSize(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageTemp);
			JToggleButton menuItem = new JToggleButton(imageIcon);
			menuItem.setToolTipText(eMenuItem.getText());
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
	}
	
	public void rectType() {
		for (ERectangle eMenuItem : ERectangle.values()) {
			ImageIcon imageIconTemp = new ImageIcon(eMenuItem.getImage());
			Image image = imageIconTemp.getImage();
			Image imageTemp = image.getScaledInstance(EImage.x.getSize(), EImage.y.getSize(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageTemp);
			JToggleButton menuItem = new JToggleButton(imageIcon);
			menuItem.setToolTipText(eMenuItem.getText());
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
	}
	public void specialType() {
		for (ESpecial eMenuItem : ESpecial.values()) {
			ImageIcon imageIconTemp = new ImageIcon(eMenuItem.getImage());
			Image image = imageIconTemp.getImage();
			Image imageTemp = image.getScaledInstance(EImage.x.getSize(), EImage.y.getSize(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageTemp);
			JToggleButton menuItem = new JToggleButton(imageIcon);
			menuItem.setToolTipText(eMenuItem.getText());
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
	}
	public void arrowType() {
		for (EArrow eMenuItem : EArrow.values()) {
			ImageIcon imageIconTemp = new ImageIcon(eMenuItem.getImage());
			Image image = imageIconTemp.getImage();
			Image imageTemp = image.getScaledInstance(EImage.x.getSize(), EImage.y.getSize(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageTemp);
			JToggleButton menuItem = new JToggleButton(imageIcon);
			menuItem.setToolTipText(eMenuItem.getText());
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
		
	}
	public void polyType() {
		for (EPoly eMenuItem : EPoly.values()) {
			ImageIcon imageIconTemp = new ImageIcon(eMenuItem.getImage());
			Image image = imageIconTemp.getImage();
			Image imageTemp = image.getScaledInstance(EImage.x.getSize(), EImage.y.getSize(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageTemp);
			JToggleButton menuItem = new JToggleButton(imageIcon);
			menuItem.setToolTipText(eMenuItem.getText());
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
		if(actionCommand.equals(ESelect.back.name())) {
			this.resetTool();
			this.first = true;
		} else {
		if(this.first) {
			setting(actionCommand);
			this.first = false;
		} else { 
			this.drawingPanel.setCurrentTool(EToolBar.valueOf(setShape(actionCommand)));
			ImageIcon imageIconTemp = new ImageIcon(EImageLocation.directory.getText()+EToolBar.valueOf(setShape(actionCommand)).name()+EImageLocation.type.getText());
			Image image = imageIconTemp.getImage();
			Image imageTemp = image.getScaledInstance(EImage.x.getSize(), EImage.y.getSize(), Image.SCALE_SMOOTH);
			ImageIcon imageIcon = new ImageIcon(imageTemp);
			this.currentButton.setIcon(imageIcon);
			this.currentButton.setToolTipText(EToolBar.valueOf(setShape(actionCommand)).getText());
		}
		}
	}
	
	private void setting(String actionCommand) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		this.buttonGroup = new ButtonGroup();
		this.buttons.clear();
		this.changePannel.removeAll();	
		JToggleButton menuItem1 = new JToggleButton(ESelect.back.getText());
		menuItem1.setActionCommand(ESelect.back.name());
		menuItem1.addActionListener(this.actionHandler);
		menuItem1.setFocusable(false);
		this.buttons.add(menuItem1);
		this.changePannel.add(menuItem1);
		buttonGroup.add(menuItem1);
		this.getClass().getMethod(actionCommand).invoke(this);
		this.remove(this.firstPannel);
		this.add(this.changePannel);
		this.updateUI();
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
