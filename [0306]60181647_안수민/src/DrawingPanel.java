import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MouseHandler mouseHandler;
	private String shape;
	
	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		this.shape = "rec";
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
	}
	public void changeShape(String cshape) {
		this.shape = cshape;
	}
	private void drawRect(int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();
		if(w<0) {
			x = x+w;
			w=-w;
		}
		if(h<0) {
			y=y+h;
			h=-h;
		}
		graphics.drawRect(x, y, w, h);
		
	}
	private void redrawRect(int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();
		graphics.setColor(Color.WHITE);
		if(w<0) {
			x = x+w;			
			w=-w;
		}
		if(h<0) {
			y=y+h;
			h=-h;
		}
		graphics.drawRect(x, y, w, h);
		graphics.setColor(Color.black);
		
	}
	private void drawOval(int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();
		if(w<0) {
			x = x+w;
			w=-w;
		}
		if(h<0) {
			y=y+h;
			h=-h;
		}			
		graphics.drawOval(x, y, w, h);
		}
	private void redrawOval(int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();
		graphics.setColor(Color.WHITE);
		if(w<0) {
			x = x+w;			
			w=-w;
		}
		if(h<0) {
			y=y+h;
			h=-h;
		}
		graphics.drawOval(x, y, w, h);
		graphics.setColor(Color.black);		
	}

	private class MouseHandler implements MouseListener, MouseMotionListener {
		private int x0, y0, x1, y1;
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			x0 = e.getX();
			y0 = e.getY();	
			x1 = e.getX();
			y1 = e.getY();	
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(shape=="rec") {
			drawRect(x0,y0,e.getX()-x0, e.getY()-y0);
		}
			else if(shape=="cir") {
				drawOval(x0,y0,e.getX()-x0, e.getY()-y0);
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if(shape=="rec") {
				redrawRect(x0,y0,x1, y1);
				drawRect(x0,y0,e.getX()-x0, e.getY()-y0);
				
			}
			else if(shape=="cir") {
				redrawOval(x0,y0,x1, y1);
				drawOval(x0,y0,e.getX()-x0, e.getY()-y0);
				}
				x1 = e.getX()-x0;
				y1 = e.getY()-y0;
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}


}
