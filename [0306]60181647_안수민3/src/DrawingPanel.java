import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MouseHandler mouseHandler;
	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
	}
	
	private void drawRect(int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();
		graphics.drawRect(x, y, w, h);
	}
	
	private class MouseHandler implements MouseListener {
		private int x0, y0;
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
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			drawRect(x0,y0,e.getX()-x0, e.getY()-y0);
		}
		
	}
}
