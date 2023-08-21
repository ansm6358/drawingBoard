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
	
	private enum EActionState {eReady, eNPointDrawing, eTwoPointDrawing}; //cmc�� n����Ʈ ��������� pdr�� two����Ʈ ��������� �ٲ�����  
	private EActionState eActionState; //�׸��� ����� ���� �ͳ��� ������ �и� ***�� �� ����� ������� �����ؾ��Ѵ�.
	
	private MouseHandler mouseHandler;
	
	private boolean start = false;
	private Shape currentTool;
	public void setCurrentTool(EToolBar currentTool) {
		this.currentTool = currentTool.getShape();
	}
	public DrawingPanel() {
		this.eActionState = EActionState.eReady;
		
		this.setBackground(Color.WHITE);
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
		
		currentTool = EToolBar.rectangle.getShape(); //��ư ������ �ٲٸ� ����Ʈ�� �θ��µ� ��ư�� �ٸ����� ���� �ִ�
	}
	
	private void drawShape() {		
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentTool.draw(graphics);
	}
	
	private void initDrawing(int x, int y) {
		if(currentTool.equals(EToolBar.Polygon.getShape())) {
			if(!start) {
				start = true; 
				this.currentTool.newArray();
				this.currentTool.setOriginArray(x, y);
			}
			drawPoly(x,y);
	} else {
		
		this.currentTool.setOrigin(x, y);
		this.drawShape();
	}
		}
	
	private void drawPoly(int x, int y) {
		Graphics graphics = this.getGraphics();		
		this.currentTool.removeArray(x, y);
		this.currentTool.setOriginArray(x, y);
		this.currentTool.draw(graphics);

	}
	
	private void keepDrawing(int x, int y) { 
		if(currentTool.equals(EToolBar.Polygon.getShape())){
			if(start) {
			Graphics graphics = this.getGraphics();
			graphics.setXORMode(getBackground());
			this.currentTool.draw(graphics);
			this.currentTool.removeArray(x, y);
			this.currentTool.setPointArray(x, y);
			this.currentTool.draw(graphics);
			}
			} else {		
				this.drawShape();
				this.currentTool.setPoint(x, y);
				this.drawShape();				
			}

	}
	private void continueDrawing(int x, int y) {
		this.currentTool.addPoint(x,y);

	}
	
	private void finishDrawing(int x, int y) {
		if(currentTool.equals(EToolBar.Polygon.getShape())) {
			start = false;
			drawPoly(x,y);
			
	} else {
//		Graphics graphics = this.getGraphics();
//		this.currentTool.draw(graphics);
	}
	}

	private class MouseHandler implements MouseListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 1) {
				mouse1Clicked(e);
			} else if (e.getClickCount() == 2) {
				mouse2Clicked(e);
			}
		}
		private void mouse2Clicked(MouseEvent e) {	
			finishDrawing(e.getX(),e.getY()); 
			eActionState = EActionState.eReady;
		}
		private void mouse1Clicked(MouseEvent e) {
			if(eActionState == EActionState.eReady) {
				if(currentTool.equals(EToolBar.Polygon.getShape())) {
				initDrawing(e.getX(),e.getY());
				eActionState = EActionState.eNPointDrawing;
				}
			} else if(eActionState == EActionState.eNPointDrawing) {
				initDrawing(e.getX(),e.getY()); 
			}
		} 
		@Override
		public void mouseMoved(MouseEvent e) {
			if(eActionState == EActionState.eNPointDrawing) {
			keepDrawing(e.getX(),e.getY()); 
		}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if(eActionState == EActionState.eReady) {
				if(!currentTool.equals(EToolBar.Polygon.getShape())) {
				initDrawing(e.getX(),e.getY());
				eActionState = EActionState.eTwoPointDrawing;
				} 
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if(eActionState == EActionState.eTwoPointDrawing) {
				initDrawing(e.getX(),e.getY());
				eActionState = EActionState.eReady;
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if(eActionState == EActionState.eTwoPointDrawing) {
				keepDrawing(e.getX(),e.getY()); 
			}
		}
		
		
		
		@Override
		public void mouseEntered(MouseEvent e) {	
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}


}
