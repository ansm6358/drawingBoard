package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import drawingPanel.GDrawingPanel;
import global.Constants.EFileMenu;
import global.Constants.EToolBar;

public class GFileMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	// assciations
	private GDrawingPanel drawingPanel;

	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public GFileMenu(String text) {
		super(text);

		ActionHandler actionHandler = new ActionHandler();

		for (EFileMenu eMenuItem : EFileMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.getMethod());
			menuItem.addActionListener(actionHandler);
			this.add(menuItem);
		}
	}

	public void initialize() {
	}

	public void nnew() {
	}

	public void open() {
		try {
			File file = new File("data/output");
			ObjectInputStream objectInputStream;
			objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			Object object = objectInputStream.readObject();
			this.drawingPanel.setShapeVector(object);
			objectInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void save() {
		File file = new File("data/output");
		ObjectOutputStream objectOutputStream;
		try {
			objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			objectOutputStream.writeObject(this.drawingPanel.getShapeVector());
			objectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveAs() {
	}

	public void close() {
	}

	private void invokeMethod(String name) {
		try {
			this.getClass().getMethod(name).invoke(this);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}
	}

	private class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			invokeMethod(event.getActionCommand());
		}
	}
}
