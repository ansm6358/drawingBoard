package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;

import drawingPanel.GDrawingPanel;
import global.Constants.EMainFrame;
import menu.GMenuBar;
import toolbar.GToolBar;

public class GMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	// component
	private GMenuBar menuBar;
	private GToolBar toolBar;
	private GDrawingPanel drawingPanel;
	private KeyHandler keyHandler;
	private WindowHandler windowhadler;
	private Point Lastlocation;
	private Dimension Lastsize;
	private boolean fullScreen;

	public GMainFrame() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		// attributes = 속성, 값
		this.setLocation(EMainFrame.x.getValue(), EMainFrame.y.getValue());
		this.setSize(EMainFrame.w.getValue(), EMainFrame.h.getValue());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.fullScreen = false;

		this.setLayout(new BorderLayout());
		// component = 자식
		this.keyHandler = new KeyHandler();
		this.addKeyListener(this.keyHandler);

		this.windowhadler = new WindowHandler();
		this.addWindowListener(this.windowhadler);
		
		this.menuBar = new GMenuBar();
		this.setJMenuBar(this.menuBar);

		this.toolBar = new GToolBar();
		this.add(this.toolBar, BorderLayout.WEST);

		this.drawingPanel = new GDrawingPanel();
		this.add(this.drawingPanel, BorderLayout.CENTER);

		// associations
		this.menuBar.associate(this.drawingPanel);
		this.toolBar.associate(this.drawingPanel);

	}

	public void initialize() {

		this.menuBar.initialize();
		this.toolBar.initialize();
		this.drawingPanel.initialize();
	}

	public void changFullScreen() {
		if (!this.fullScreen) {
			this.Lastlocation = this.getLocation();
			this.Lastsize = this.getSize();
			this.setExtendedState(this.MAXIMIZED_BOTH);
			this.dispose();
			this.setUndecorated(true);
			this.setVisible(true);
			this.fullScreen = true;
		} else {
			this.dispose();
			this.setUndecorated(false);
			this.setVisible(true);
			this.setLocation(this.Lastlocation);
			this.setSize(this.Lastsize);
			this.fullScreen = false;
		}

	}

	public void cancleFull() {
		if(this.fullScreen) {
			this.dispose();
			this.setUndecorated(false);
			this.setVisible(true);
			this.fullScreen = false;
		}
	}
	
	public void sizeUp() {
		this.setSize(this.getWidth()+10, this.getHeight()+10);
		
	}

	public void sizeDown() {
		this.setSize(this.getWidth()-10, this.getHeight()-10);
		
	}
	
	public void finish() {
		// TODO Auto-generated method stub
		
	}
	
	class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
			if (event.isAltDown() && event.getKeyCode() == KeyEvent.VK_ENTER) {
				changFullScreen();
			} else if(event.getKeyCode() == KeyEvent.VK_ESCAPE) {
				cancleFull();
			} else if(event.isControlDown() && event.getKeyCode() == 107) {
				sizeUp();
			}  else if(event.isControlDown() && event.getKeyCode() == 109) {
				sizeDown();
			} 
		}

		@Override
		public void keyReleased(KeyEvent event) {
		}

		@Override
		public void keyTyped(KeyEvent event) {
		}

	}
	
	class WindowHandler implements WindowListener{

		@Override
		public void windowActivated(WindowEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent event) {
			
			finish();
		}

		@Override
		public void windowDeactivated(WindowEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}


	

}
