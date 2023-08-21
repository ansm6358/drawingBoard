package menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import drawingPanel.GDrawingPanel;
import global.Constants.EFileMenu;
import global.Constants.EToolBar;

public class GFileMenu extends JMenu {

	private static final long serialVersionUID = 1L;

	private File directory, file;

	// assciations
	private GDrawingPanel drawingPanel;

	public void associate(GDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public GFileMenu(String text) {
		super(text);

		this.file = null;
		this.directory = new File("data");

		ActionHandler actionHandler = new ActionHandler();

		for (EFileMenu eMenuItem : EFileMenu.values()) {
			JMenuItem menuItem = new JMenuItem(eMenuItem.getText());
			menuItem.setActionCommand(eMenuItem.getMethod());
			menuItem.addActionListener(actionHandler);
			menuItem.setAccelerator(KeyStroke.getKeyStroke(eMenuItem.getShortcut(),eMenuItem.getHotkey()));
			this.add(menuItem);
		}
	}

	public void initialize() {
	}

	public void nnew() {
		int select = JOptionPane.showConfirmDialog(this.drawingPanel, "�����ϰڽ��ϱ�?","checkSave",JOptionPane.YES_NO_OPTION);
		if(select == JOptionPane.YES_OPTION) {
			this.save();			
		}
		
		this.drawingPanel.restoreShapeVector(null);
		this.drawingPanel.setUpdated(true);
		this.file = null; // ��������1 (new�� ���� ���� ������ ���� ��)

	}

	public void readObject() {
		try {
			ObjectInputStream objectInputStream;
			objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			Object object = objectInputStream.readObject();
			this.drawingPanel.restoreShapeVector(object);
			objectInputStream.close();
			this.drawingPanel.setUpdated(false);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void open() {
		//��������2 ���� ������ �����ϸ� ���� �������� �ƴ��� Ȯ���ϴ� �� ���� �ֱ� : ���⼭ ����� ���� ������ �ֽ��ϴ� ���� �ϰڽ��ϱ�? if file = null
		int select = JOptionPane.showConfirmDialog(this.drawingPanel, "�����ϰڽ��ϱ�?","checkSave",JOptionPane.YES_NO_OPTION);
		if(select == JOptionPane.YES_OPTION) {
			this.save();			
		}

		JFileChooser chooser = new JFileChooser(this.directory);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Grapics Data", "god");
		FileNameExtensionFilter filter1 = new FileNameExtensionFilter("XML Data", "xml");
		chooser.setFileFilter(filter);
		chooser.setFileFilter(filter1);
		int returnVal = chooser.showOpenDialog(this.drawingPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.directory = chooser.getCurrentDirectory();
			this.file = chooser.getSelectedFile();
			this.readObject();
			
		}
	}

	private void writeObject() {
		try {
			ObjectOutputStream objectOutputStream;
			objectOutputStream = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(file)));
			objectOutputStream.writeObject(this.drawingPanel.getShapeVector());
			objectOutputStream.close();
			this.drawingPanel.setUpdated(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void save() {
		if (this.drawingPanel.isUpdated()) {
			if (file == null) {
				this.saveAs();
			} else {
				this.writeObject();
			}
		}
	}

	public void saveAs() {
		JFileChooser chooser = new JFileChooser(this.directory);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Grapics Data", "god");
		FileNameExtensionFilter filter1 = new FileNameExtensionFilter("XML Data", "xml");
		chooser.setFileFilter(filter);
		chooser.setFileFilter(filter1);
		int returnVal = chooser.showSaveDialog(this.drawingPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			this.directory = chooser.getCurrentDirectory();
			this.file = chooser.getSelectedFile();
			this.writeObject();
		}	
	}

	public void print() {
		
	}
	
	public void close() {
		this.save();
		System.exit(0);
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
