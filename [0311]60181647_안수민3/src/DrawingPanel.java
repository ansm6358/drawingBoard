import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

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
	}
	
	private void drawRect(int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		graphics.drawRect(x, y, w, h);
	}

	private void drawEllsipse(int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		graphics.drawOval(x, y, w, h);
	}
	
	private void drawLine(int x0, int y0, int x1, int y1) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		graphics.drawLine(x0, y0, x1, y1);
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
			if(currentTool.equals("Rectangle")) {
			drawRect(x0,y0,x1-x0, y1-y0);
			} else if(currentTool.equals("Ellipse")) {
				drawEllsipse(x0,y0,x1-x0, y1-y0);
			} else if(currentTool.equals("Line")) {
				drawLine(x0,y0,x1, y1);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if(currentTool.equals("Rectangle")) {
				drawRect(x0,y0,x1-x0, y1-y0);
			} else if(currentTool.equals("Ellipse")) {
				drawEllsipse(x0,y0,x1-x0, y1-y0);
			} else if(currentTool.equals("Line")) {
				drawLine(x0,y0,x1, y1);
			}
			
			x1 = e.getX();
			y1 = e.getY();	
			
			if(currentTool.equals("Rectangle")) {
				drawRect(x0,y0,x1-x0, y1-y0);
			} else if(currentTool.equals("Ellipse")) {
					drawEllsipse(x0,y0,x1-x0, y1-y0);
			} else if(currentTool.equals("Line")) {
				drawLine(x0,y0,x1, y1);
			}
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
