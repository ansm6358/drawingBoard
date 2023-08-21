package 그림판연습;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import 그림판연습.MainFrame.ActionHandler;

public class CanvasPanel extends Canvas {
	private static final long serialVersionUID = 1L;
	private MouseHandler mouseHandler;
	private int startX;
	private int startY;
	private int lastX;
	private int lastY;
	private Graphics g;
	private Graphics2D g2;
	
	
	public CanvasPanel(ActionHandler actionHandler) {
	this.setBackground(Color.WHITE);
	
	this.mouseHandler = new MouseHandler(); 

	
	this.addMouseMotionListener(mouseHandler);
	
	}
		
	class MouseHandler implements MouseMotionListener, MouseListener{

		@Override
		public void mouseDragged(MouseEvent event) {
			lastX = event.getX();
			lastY = event.getY();
			g2.drawLine(startX+150, startY+210, lastX+150, lastY+210);
			startX = lastX;
			startY = lastY;
		}

		@Override
		public void mouseMoved(MouseEvent event) {
		}

		@Override
		public void mouseClicked(MouseEvent event) {
		}

		@Override
		public void mouseEntered(MouseEvent event) {
		}

		@Override
		public void mouseExited(MouseEvent event) {
		}

		@Override
		public void mousePressed(MouseEvent event) {
			startX = event.getX();
			startY = event.getY();
		}

		@Override
		public void mouseReleased(MouseEvent event) {
		}
		
	}

}
