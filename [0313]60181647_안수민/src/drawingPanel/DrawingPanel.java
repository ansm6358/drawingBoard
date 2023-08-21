package drawingPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import global.Constants.EToolBar;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MouseHandler mouseHandler;
	
	private String currentTool;
	public void setCurrentTool(String currentTool) {
		this.currentTool = currentTool;
	}
	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
		
		currentTool = EToolBar.select.getText(); //버튼 순서를 바꾸면 설렉트를 부르는데 버튼이 다른것이 눌려 있다
	}

	private void drawing(int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		if(currentTool.equals(EToolBar.rectangle.getText())) {
			if(w<0) {
				x = x+w;
				w=-w;
			}
			if(h<0) {
				y=y+h;
				h=-h;
			}
			graphics.drawRect(x, y, w, h);
		} else if(currentTool.equals(EToolBar.ellipse.getText())) {
			if(w<0) {
				x = x+w;
				w=-w;
			}
			if(h<0) {
				y=y+h;
				h=-h;
			}
			graphics.drawOval(x, y, w, h);
		}	else if(currentTool.equals(EToolBar.line.getText())) {
			graphics.drawLine(x, y, w+x, h+y);
		}
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener {
		private int x0, y0, x1, y1;
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			x0 = e.getX();
			y0 = e.getY();			
			x1 = e.getX();
			y1 = e.getY();	
			drawing(x0,y0,x1-x0, y1-y0);			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			drawing(x0,y0,x1-x0, y1-y0);	
			
			x1 = e.getX();
			y1 = e.getY();	
			
			drawing(x0,y0,x1-x0, y1-y0);	
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		
	}


}
