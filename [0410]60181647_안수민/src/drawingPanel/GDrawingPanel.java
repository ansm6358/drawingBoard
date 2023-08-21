package drawingPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

import global.Constants.EToolBar;
import shape.GShape;
import shape.GShape.EOnState;
import shape.GPolygon;;

public class GDrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private enum EActionState {eReady, e2PDrawing, eNPDrawing, eMoving, eResizing,eRotating}; //cmc�� n����Ʈ ��������� pdr�� two����Ʈ ��������� �ٲ����� 
	private EActionState eActionState; //�׸��� ����� ���� �ͳ��� ������ �и� ***�� �� ����� ������� �����ؾ��Ѵ�.	
	private MouseHandler mouseHandler;
	
	private Vector<GShape> shapeVector;
	private GShape currentShape;
	
	private GShape currentTool;
	public void setCurrentTool(EToolBar currentTool) {
		this.currentTool = currentTool.getShape();
	}
	public GDrawingPanel() {
		this.eActionState = EActionState.eReady;
		
		this.setForeground(Color.black);
		this.setBackground(Color.WHITE);
		
		this.mouseHandler = new MouseHandler();
		this.addMouseListener(this.mouseHandler);
		this.addMouseMotionListener(this.mouseHandler);
		
		this.shapeVector = new Vector<GShape>();
	}
	
	public void initialize() {
		
	}
	public void paint(Graphics graphics) {
		Graphics2D graphics2d = (Graphics2D)graphics;
		super.paint(graphics2d);
		
		for(GShape shape: this.shapeVector) {		
			shape.draw(graphics2d);
		}
	}
	private void drawShape() {		
		Graphics2D graphics2d = (Graphics2D)this.getGraphics();
		graphics2d.setXORMode(getBackground());
		this.currentShape.draw(graphics2d);
	}
	
	private EOnState onShape(int x, int y) {
		this.currentShape = null;
		for(GShape shape: this.shapeVector) {
			EOnState eOnState = shape.onShape(x, y);
			if(eOnState != null) {
				this.currentShape = shape;
				return eOnState;
			}
		}
		return null;
	}
	private EActionState defineActionState(int x, int y) {
		EOnState eOnState = onShape(x, y);
		if(eOnState==(EOnState.eOnShape)) {
			eActionState = EActionState.eMoving;
		} else if(eOnState==(EOnState.eOnResize)) {
			eActionState = EActionState.eResizing;
		} else if(eOnState==(EOnState.eOnRotate)) {
			eActionState = EActionState.eRotating;
		} else {
			eActionState = EActionState.eReady;
		}
		return eActionState;
	}
	private void initDrawing(int x, int y) {
		this.currentShape = this.currentTool.clone();
		this.currentShape.setOrigin(x, y);
		this.drawShape();
	}
	
	private void keepDrawing(int x, int y) { 
		this.drawShape();
		this.currentShape.setPoint(x, y);
		this.drawShape();
	}
	private void continueDrawing(int x, int y) {
		this.currentShape.addPoint(x,y);

	}
	
	private void finishDrawing(int x, int y) {
		this.shapeVector.add(this.currentShape);
	}
	private void initMoving(int x, int y) {
		Graphics2D graphics2d = (Graphics2D)this.getGraphics();
		//graphics2d.setPaintMode();
		if(!this.currentShape.isAnchor()) {
		graphics2d.setXORMode(getBackground());
		drowAnchor(graphics2d);
		}
				this.currentShape.initMoving(x, y);

	}
	
	private void drowAnchor(Graphics2D graphics2d) {
		this.currentShape.setSelected(true,graphics2d);
	}
	private void keepMoving(int x, int y) {
		Graphics2D graphics2d = (Graphics2D)this.getGraphics();
		graphics2d.setXORMode(getBackground());
		this.drawShape();
		drowAnchor(graphics2d);
		this.currentShape.keepMoving(x, y);
		this.drawShape();
		drowAnchor(graphics2d);
	}
	
	private void finishMoving(int x, int y) {
		this.currentShape.finishMoving(x, y);
		
	}

	private void relieveAnchor(int x, int y) {
		this.checkAncker(x,y);
	}
	private void checkAncker(int x, int y) {
		for(GShape shape: this.shapeVector) {
			EOnState eOnState = shape.onShape(x, y);
			if(shape.isAnchor()&&eOnState==null) {
				this.currentShape = shape;
				Graphics2D graphics2d = (Graphics2D)this.getGraphics();
				graphics2d.setXORMode(getBackground());
				drowAnchor(graphics2d);
				this.currentShape.setAnchorinit();
			}
		}
	}
	private class MouseHandler implements MouseListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 1) {
				if(currentTool instanceof GPolygon) {
				mouse1Clicked(e);}
			} else if (e.getClickCount() == 2) {
				mouse2Clicked(e);
			}
		}
		private void mouse2Clicked(MouseEvent e) {	
			if(eActionState == EActionState.eNPDrawing) {
				finishDrawing(e.getX(),e.getY());
				eActionState = EActionState.eReady;
			}
		}
		private void mouse1Clicked(MouseEvent e) {
			if(eActionState == EActionState.eReady) {
				initDrawing(e.getX(),e.getY());
				eActionState = EActionState.eNPDrawing;
			} else if(eActionState == EActionState.eNPDrawing) {
				continueDrawing(e.getX(),e.getY());
			}
		} 
		
		@Override
		public void mouseMoved(MouseEvent e) {
			if (eActionState == EActionState.eNPDrawing) {
				keepDrawing(e.getX(),e.getY());
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if(eActionState == EActionState.eReady) {				
				eActionState = defineActionState(e.getX(),e.getY());
				System.out.println(eActionState);
				relieveAnchor(e.getX(),e.getY());
				if(onShape(e.getX(), e.getY()) != null) {
					initMoving(e.getX(), e.getY());
					eActionState = EActionState.eMoving;
				} else {
					if(!(currentTool instanceof GPolygon)) {
					initDrawing(e.getX(),e.getY());
					eActionState = EActionState.e2PDrawing;
					}
				}
			}
		}

		
		@Override
		public void mouseReleased(MouseEvent e) {
			if(eActionState == EActionState.e2PDrawing) {
				finishDrawing(e.getX(),e.getY());
				eActionState = EActionState.eReady;
			} else if(eActionState == EActionState.eMoving) {
				finishMoving(e.getX(),e.getY()); 
				eActionState = EActionState.eReady;
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			if(eActionState == EActionState.e2PDrawing) {
				keepDrawing(e.getX(),e.getY()); 
			} else if(eActionState == EActionState.eMoving) {
				keepMoving(e.getX(),e.getY()); 		
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
