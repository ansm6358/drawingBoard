package menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import drawingPanel.GDrawingPanel;
import global.Constants.EColorMenu;

public class GColorMenu extends JMenu {
	private GDrawingPanel drawingPanel;
	private static final long serialVersionUID = 1L;

	public GColorMenu(String name) {
		super(name);
		ActionHandler actionHandler = new ActionHandler();
		for (EColorMenu eColorMenu : EColorMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eColorMenu.getText());
			menuItem.setActionCommand(eColorMenu.getMethod());
			menuItem.addActionListener(actionHandler);
			menuItem.setAccelerator(KeyStroke.getKeyStroke(eColorMenu.getShortcut(),eColorMenu.getHotkey()));
			this.add(menuItem);
		}
	}

	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public void initialize() {

	}

	public void line() {
		Color color = JColorChooser.showDialog(this.drawingPanel, "Line Color", this.drawingPanel.getForeground());
		this.drawingPanel.setLineColor(color);
	}

	public void fill() {
		Color color = JColorChooser.showDialog(this.drawingPanel, "Fill Color", this.drawingPanel.getForeground());
		this.drawingPanel.setFillColor(color);
	}

	public void invokemethod(String name) {

		try {
			this.getClass().getMethod(name).invoke(this);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {

			e.printStackTrace();
		}

	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			invokemethod(e.getActionCommand());

		}

	}
}
