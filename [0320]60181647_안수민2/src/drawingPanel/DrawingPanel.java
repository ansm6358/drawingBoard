package drawingPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import global.Constants.EToolBar;
import shape.Shape;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private MouseHandler mouseHandler;
	
	private boolean start = false;
	private Shape currentTool;
	public void setCurrentTool(EToolBar currentTool) {
		this.currentTool = currentTool.getShape();
	}
	public DrawingPanel() {
		this.setBackground(Color.WHITE);
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
		
		currentTool = EToolBar.rectangle.getShape(); //��ư ������ �ٲٸ� ����Ʈ�� �θ��µ� ��ư�� �ٸ����� ���� �ִ�
	}
	
	private void drawShape(int x, int y) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		
		this.currentTool.setOrigin(x, y);
		this.currentTool.draw(graphics);
	}
	private void moveShape(int x, int y) { 
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		
		this.currentTool.draw(graphics);
		this.currentTool.setPoint(x, y);
		this.currentTool.draw(graphics);
	}

	private void drawPoly(int x, int y) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		
		this.currentTool.setOrigin(x, y);
		this.currentTool.draw(graphics);
	}
	private void movePoly(int x, int y) { 
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		
		this.currentTool.draw(graphics);
		this.currentTool.setPoint(x, y);
		this.currentTool.draw(graphics);
	}
	private class MouseHandler implements MouseListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			
			
			drawShape(e.getX(),e.getY());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			moveShape(e.getX(),e.getY());

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
