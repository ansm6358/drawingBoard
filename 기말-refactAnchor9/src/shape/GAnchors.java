package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.io.Serializable;
import java.util.Vector;

public class GAnchors implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final int w = 10;
	private final int h = 10;
	private final int dw = w / 2;
	private final int dh = h / 2;
	private AffineTransform affineTransform;
	private double rotateRate;
	//private double radian=0;
	
	public enum EAnchors {
		NW, NN, NE, EE, SE, SS, SW, WW, RR, GG
	}

	private Vector<Ellipse2D> anchors;
	private Vector<Shape> anchorsShape;

	@SuppressWarnings("unused") // 프로그램을 짤 때 실수 한게(안 쓰는 것이) 아니라 일부러 만든 것이란 것을 표시하기 위한것
	public GAnchors() {
		this.anchors = new Vector<Ellipse2D>();
		this.anchorsShape = new Vector<Shape>();
		for (EAnchors eAnchors : EAnchors.values()) {
			this.anchors.add(new Ellipse2D.Double(0, 0, w, h));
		}
		this.affineTransform = new AffineTransform();
	}

	public EAnchors onShape(int x, int y) {
		for(int i = 0; i<EAnchors.values().length; i++) {
			if(this.anchorsShape.get(i).contains(x, y)) {
				return EAnchors.values()[i];
			}
		}
		return null;
	}

	public void draw(Graphics2D graphics2D) {
		for (Shape shape : this.anchorsShape) {
//			graphics2D.setColor(Color.white);
//			graphics2D.fill(shape);
//			graphics2D.setColor(Color.black);
			graphics2D.draw(shape);	
		}
	}

	public void setBoundingRect(Rectangle r) {
		for (EAnchors eAnchors : EAnchors.values()) {
			int x = 0, y = 0;
			switch (eAnchors) {
			case NW:
				x = r.x;
				y = r.y;
				break;
			case NN:
				x = r.x + r.width / 2;
				y = r.y;
				break;
			case NE:
				x = r.x + r.width;
				y = r.y;
				break;
			case EE:
				x = r.x + r.width;
				y = r.y + r.height / 2;
				break;
			case SE:
				x = r.x + r.width;
				y = r.y + r.height;
				break;
			case SS:
				x = r.x + r.width / 2;
				y = r.y + r.height;
				break;
			case SW:
				x = r.x;
				y = r.y + r.height;
				break;
			case WW:
				x = r.x;
				y = r.y + r.height / 2;
				break;
			case RR:
				x = r.x + r.width / 2;
				y = r.y - 50;
				break;
			case GG:
				x = r.x + r.width / 2;
				y = r.y - 25;
				break;
			}
			x = x - dw;
			y = y - dh;
			this.anchors.get(eAnchors.ordinal()).setFrame(x, y, w, h);

		}
		this.anchorsShape.clear();
		for (Shape shape : this.anchors) {
			
			this.anchorsShape.add(shape);
		}
		for(int i = 0; i<this.anchorsShape.size(); i++ ) {
			affineTransform.setToRotation(this.rotateRate, r.getCenterX(), r.getCenterY());
			this.anchorsShape.add(i, affineTransform.createTransformedShape(this.anchorsShape.get(i)));
			this.anchorsShape.remove(i+1);
			
		}
	}

	public void changeGG(Graphics2D graphics2d, AffineTransform affineTransform, double centerX, double centerY) {
//		if(this.radian!=0) {
//			System.out.println(affineTransform.getRotateInstance(radian, centerX, centerY));
//			//affineTransform.setToRotation(radian, centerX, centerY);
//		}
		int GGNum = EAnchors.GG.ordinal();
		this.anchorsShape.add(GGNum, affineTransform.createTransformedShape(this.anchorsShape.get(GGNum)));
		this.anchorsShape.remove(GGNum+1);
		//graphics2d.draw(this.anchors.get(EAnchors.GG.ordinal()));
		//this.anchors.get(EAnchors.GG.ordinal()).setFrame(x, this.anchors.get(EAnchors.GG.ordinal()).getY(), w, h);
		//graphics2d.draw(this.anchors.get(EAnchors.GG.ordinal()));
	}

	public void moveAnchor(int dw, int dh) {
		for(int i = 0; i<this.anchorsShape.size(); i++ ) {
		this.affineTransform.setToTranslation(dw, dh);
		this.anchorsShape.add(i, this.affineTransform.createTransformedShape(this.anchorsShape.get(i)));
		this.anchorsShape.remove(i+1);
		
	}
	}

	public void rotateAnchors(AffineTransform affineTransform, double radian) {
		this.rotateRate += radian;
		for(int i = 0; i<this.anchorsShape.size(); i++ ) {
			this.affineTransform = affineTransform;
			this.anchorsShape.add(i, affineTransform.createTransformedShape(this.anchorsShape.get(i)));
			this.anchorsShape.remove(i+1);
			
		}
	}

	public double getNWX() {
		return this.anchorsShape.get(EAnchors.NW.ordinal()).getBounds().getCenterX();
	}

	public double getNWY() {
		// TODO Auto-generated method stub
		return this.anchorsShape.get(EAnchors.NW.ordinal()).getBounds().getCenterY();
	}

	public void resize(EAnchors resizeAnchor, double settingX, double settingY) {
		
				this.affineTransform.setToTranslation(settingX, settingY);
				this.anchorsShape.add(resizeAnchor.ordinal(), this.affineTransform.createTransformedShape(this.anchorsShape.get(resizeAnchor.ordinal())));
				this.anchorsShape.remove(resizeAnchor.ordinal()+1);
				
			
	}
}
