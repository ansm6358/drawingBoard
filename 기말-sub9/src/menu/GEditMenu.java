package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import drawingPanel.GDrawingPanel;
import global.Constants.EEditMenu;

public class GEditMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	private GDrawingPanel drawingPanel;
	
	public GEditMenu(String text) {
		super(text);
		
		ActionHandler actionHandler = new ActionHandler();

		for (EEditMenu eMenuItem : EEditMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.getMethod());
			menuItem.addActionListener(actionHandler);
			menuItem.setAccelerator(KeyStroke.getKeyStroke(eMenuItem.getShortcut(),eMenuItem.getHotkey()));
			this.add(menuItem);}
	}

	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public void initialize() {
		
	}
	// 파일 메뉴에도 같은 코드가 사용되니 슈퍼 클래스로 바꾸자
	private void invokeMethod(String name) {
		try {
			this.getClass().getMethod(name).invoke(this);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public void undo() {
		
	}
	public void redo() {
		
	}
	public void cut() {
		this.drawingPanel.cut();
	}
	public void copy() {
		this.drawingPanel.copy();
	}
	public void paste() {
		this.drawingPanel.paste();
	}
	public void group() {
		
	}
	public void ungroup() {
		
	}
	
	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			invokeMethod(event.getActionCommand());
		}
	}
}
