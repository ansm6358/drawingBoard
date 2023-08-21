package drawingPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import global.Constants.EToolBar;
import shape.Shape;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MouseHandler mouseHandler;
	
	private Shape currentTool;
	public void setCurrentTool(Shape currentTool) {
		this.currentTool = currentTool;
	}
	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
		
		currentTool = EToolBar.select.getShape(); //버튼 순서를 바꾸면 설렉트를 부르는데 버튼이 다른것이 눌려 있다
	}
	
	private void drawShpae(boolean last, int x, int y, int w, int h) {
		Graphics graphics = this.getGraphics();	
graphics.setXORMode(getBackground());
			Graphics2D graphics2d = (Graphics2D)graphics;
			float[] dash=new float[]{2,2,2,2};
			graphics2d.setStroke(new BasicStroke(1,0,BasicStroke.JOIN_MITER,1.0f,dash, 0));
		if(!last) {
			this.currentTool.draw(graphics2d, x, y, w, h);
			} else if(last) {
				//this.currentTool.draw(graphics2d, x, y, w, h);

			//this.currentTool.draw(graphics, x, y, w, h);
			}
		}

	private class MouseHandler implements MouseListener, MouseMotionListener {
		private int x0, y0, x1, y1;
		private boolean last;
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			x0 = e.getX();
			y0 = e.getY();			
			x1 = e.getX();
			y1 = e.getY();	
			last = false;
			drawShpae(last, x0,y0,x1-x0, y1-y0);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			last = false;
			drawShpae(last, x0,y0,x1-x0, y1-y0);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			last = false;
			drawShpae(last, x0,y0,x1-x0, y1-y0);
			
			x1 = e.getX();
			y1 = e.getY();	
			
			drawShpae(last, x0,y0,x1-x0, y1-y0);
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
