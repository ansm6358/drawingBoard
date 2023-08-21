package drawingPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

import global.Constants.EToolBar;
import shape.Polygon;
import shape.Rectangle;
import shape.Shape;

public class DrawingPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private enum EActionState {
		eReady, e2PDrawing, eNPDrawing
	}; // cmc를 n포인트 드로일으로 pdr을 two포인트 드로일으로 바꿔진행

	private EActionState eActionState; // 그리는 방식이 같은 것끼리 도형을 분리 ***이 때 무브와 드로잉은 구분해야한다.
	private MouseHandler mouseHandler;

	private Vector<Shape> shapeVector;
	private Shape currentShape;

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

		this.shapeVector = new Vector<Shape>();
		this.currentTool = EToolBar.rectangle.getShape(); // 버튼 순서를 바꾸면 설렉트를 부르는데 버튼이 다른것이 눌려 있다
	}

	public void paint(Graphics graphics) {
		super.paint(graphics);

		for (Shape shape : this.shapeVector) {
			shape.draw(graphics);
		}
	}

	private void drawShape() {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
		this.currentShape.draw(graphics);
	}

	private void initDrawing(int x, int y) {
		if (this.currentTool.equals(EToolBar.move.getShape())) {
			startMove(x, y);
		} else {
			this.currentShape = this.currentTool.clone();
			this.currentShape.setOrigin(x, y);
			this.drawShape();
		}
	}

	private void startMove(int x, int y) {
		for (Shape shape : this.shapeVector) {
			boolean isRange = checkRange(shape, x, y);
			shape.setisRange(isRange);
			if (isRange) {
				shape.startPoint(x, y);
			}
		}

	}

	private boolean checkRange(Shape shape, int x, int y) {

		if (shape instanceof Rectangle) {
			int x1 = shape.getFirstX();
			int x2 = shape.getLastX();
			int y1 = shape.getFirstY();
			int y2 = shape.getLastY();

			if (x >= x1 && x <= x2) {
				if (y >= y1 && y <= y2) {
					return true;
				}
			}

		} else if (shape instanceof Polygon) {
			shape.compareArray();
			int x1 = shape.getsmallX();
			int x2 = shape.getbigX();
			int y1 = shape.getsmallY();
			int y2 = shape.getbigY();

			if (x >= x1 && x <= x2) {
				if (y >= y1 && y <= y2) {
					return true;
				}
			}
		}
		return false;
	}

	private void keepDrawing(int x, int y) {
		if (this.currentTool.equals(EToolBar.move.getShape())) {
			moveShape(x, y);
		} else {
			this.drawShape();
			this.currentShape.setPoint(x, y);
			this.drawShape();
		}
	}

	private void moveShape(int x, int y) {
		
		boolean isMove;
		for (Shape shape : this.shapeVector) {
			isMove = shape.getisRange();
			
			if(isMove) {
				changeSpace(shape,x,y);
			}
			
		}
	}
	private void lastMove() {
			boolean isMove;
			for (Shape shape : this.shapeVector) {
				isMove = shape.getisRange();			
				if(isMove) {
					shape.saveArray();
				}
			}
				
		}
	private void changeSpace(Shape shape, int x, int y) {
		Graphics graphics = this.getGraphics();
		graphics.setXORMode(getBackground());
			shape.draw(graphics);
			shape.endPoint(x, y);
		if (shape instanceof Rectangle) {		
			shape.changePoint();
		} else if (shape instanceof Polygon) {
			shape.changeArrayPoint();
		}
		shape.draw(graphics);
	}

	private void continueDrawing(int x, int y) {
		this.currentShape.addPoint(x, y);

	}

	private void finishDrawing(int x, int y) {
		if (this.currentTool.equals(EToolBar.move.getShape())) {
			moveShape(x, y);
			lastMove();
		} else {
			this.shapeVector.add(this.currentShape);
		}
	}

	

	private class MouseHandler implements MouseListener, MouseMotionListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1) {
				mouse1Clicked(e);
			} else if (e.getClickCount() == 2) {
				mouse2Clicked(e);
			}
		}

		private void mouse2Clicked(MouseEvent e) {
			if (eActionState == EActionState.eNPDrawing) {
				finishDrawing(e.getX(), e.getY());
				eActionState = EActionState.eReady;
			}
		}

		private void mouse1Clicked(MouseEvent e) {
			if (eActionState == EActionState.eReady) {
				if (!currentTool.equals(EToolBar.move.getShape())) {
					initDrawing(e.getX(), e.getY());
					eActionState = EActionState.eNPDrawing;
				}
			} else if (eActionState == EActionState.eNPDrawing) {
				continueDrawing(e.getX(), e.getY());
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (eActionState == EActionState.eNPDrawing) {
				if (!currentTool.equals(EToolBar.move.getShape())) {
					keepDrawing(e.getX(), e.getY());
				}
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (eActionState == EActionState.eReady) {
				if (!currentTool.equals(EToolBar.polygon.getShape())) {
					initDrawing(e.getX(), e.getY());
					eActionState = EActionState.e2PDrawing;	
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (eActionState == EActionState.e2PDrawing) {
				finishDrawing(e.getX(), e.getY());
				eActionState = EActionState.eReady;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (eActionState == EActionState.e2PDrawing) {
				keepDrawing(e.getX(), e.getY());
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
