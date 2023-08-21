package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.io.Serializable;

import shape.GAnchors.EAnchors;

public abstract class GShape implements Cloneable, Serializable {

	public enum EOnState {
		eOnShape, eOnResize, eOnRotate
	};

	protected Shape shape; 
	protected int px;
	protected int py;
	private boolean selected;
	private GAnchors anchors;
	private boolean initAnchor;
	private Color color;
	private EAnchors eAnchor;
	private AffineTransform affineTransform;

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		if (this.selected)
			this.anchors.setBoundingRect(this.shape.getBounds());
	}

	public GShape() {
		this.selected = false;
		this.anchors = new GAnchors();
		this.affineTransform = new AffineTransform();
	}
	
	public EAnchors geteAnchor() {
		return eAnchor;
	}

	public void seteAnchor(EAnchors eAnchor) {
		this.eAnchor = eAnchor;
	}

	abstract public void setOrigin(int x, int y);

	abstract public void setPoint(int x, int y);

	abstract public void addPoint(int x, int y);

	public void initMoving(Graphics2D graphics2d, int x, int y) {
		this.px = x;
		this.py = y;
		if (!this.selected) {
			this.selected = true;
			this.anchors.setBoundingRect(this.shape.getBounds());
			this.anchors.draw(graphics2d);
		}
		initAnchor = true;
	}

	public void keepMoving(Graphics2D graphics2d, int x, int y) {
		int dw = x - this.px;
		int dh = y - this.py;
		
		this.affineTransform.setToTranslation(dw, dh);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
		
		this.px = x;
		this.py = y;
	};

	public void finishMoving(Graphics2D graphics2d, int x, int y) {
		
	};

	public GShape clone() {
		try {
			return (GShape) this.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics2D graphics2d) {
		graphics2d.draw(this.shape);
		if (this.selected) {
			this.anchors.setBoundingRect(this.shape.getBounds());
			if(this.initAnchor) {
				graphics2d.setPaintMode();
				this.anchors.draw(graphics2d);
				graphics2d.setXORMode(this.color);
				this.initAnchor = false;
			}
			this.anchors.draw(graphics2d);
		}
	}

	public EOnState onShape(int x, int y) {
		if (this.selected) {
			EAnchors eAnchor = this.anchors.onShape(x, y);
			this.seteAnchor(eAnchor);
			if (eAnchor == EAnchors.RR) { // rotate
				return EOnState.eOnRotate;
			} else if (eAnchor == null) { //
				if (this.shape.contains(x, y)) {
					return EOnState.eOnShape;
				}
			} else { // resize
				return EOnState.eOnResize;
			}
		} else {
			if (this.shape.contains(x, y)) {
				return EOnState.eOnShape;
			}
		}
		return null;
	}

	public void initResizing(int x, int y) {
		this.px = x;
		this.py = y;
		initAnchor = true;
	}

	public void keepResizing(Graphics2D graphics2d, int x, int y) {
		double rateW;
		double rateH;
		double settingX;
		double settingY;
		
		switch (this.eAnchor) {
		case NW:
			rateW = (this.px-x+this.shape.getBounds().getWidth())/this.shape.getBounds().getWidth();
			rateH = (this.py-y+this.shape.getBounds().getHeight())/this.shape.getBounds().getHeight();
			settingX = this.px - (rateW*this.shape.getBounds().getX());
			settingY = this.py - (rateH*this.shape.getBounds().getY());	
			doResize(rateW, rateH, settingX, settingY);
			break;
		case NN:
			rateH = (this.py-y+this.shape.getBounds().getHeight())/this.shape.getBounds().getHeight();
			settingY = this.py - (rateH*this.shape.getBounds().getY());	
			doResize(1, rateH, 0, settingY);
			break;			
		case NE:
			rateW = (x-this.shape.getBounds().getX())/this.shape.getBounds().getWidth();
			rateH = (this.py-y+this.shape.getBounds().getHeight())/this.shape.getBounds().getHeight();
			settingX = this.shape.getBounds().getX() - (rateW*this.shape.getBounds().getX());
			settingY = this.py - (rateH*this.shape.getBounds().getY());	
			doResize(rateW, rateH, settingX, settingY);
			break;
		case EE:
			rateW = (x-this.shape.getBounds().getX())/this.shape.getBounds().getWidth();
			settingX = this.shape.getBounds().getX() - (rateW*this.shape.getBounds().getX());
			doResize(rateW, 1, settingX, 0);
			break;
		case SE:
			rateW = (x-this.shape.getBounds().getX())/this.shape.getBounds().getWidth();
			rateH = (y-this.shape.getBounds().getY())/this.shape.getBounds().getHeight();
			settingX = this.shape.getBounds().getX() - (rateW*this.shape.getBounds().getX());
			settingY = this.shape.getBounds().getY() - (rateH*this.shape.getBounds().getY());	
			doResize(rateW, rateH, settingX, settingY);
			break;
		case SS:
			rateH = (y-this.shape.getBounds().getY())/this.shape.getBounds().getHeight();
			settingY = this.shape.getBounds().getY() - (rateH*this.shape.getBounds().getY());	
			doResize(1, rateH, 0, settingY);
			break;
		case SW:
			rateW = (this.px-x+this.shape.getBounds().getWidth())/this.shape.getBounds().getWidth();
			rateH = (y-this.shape.getBounds().getY())/this.shape.getBounds().getHeight();
			settingX = this.px - (rateW*this.shape.getBounds().getX());
			settingY = this.shape.getBounds().getY() - (rateH*this.shape.getBounds().getY());	
			doResize(rateW, rateH, settingX, settingY);
			break;
		case WW:
			rateW = (this.px-x+this.shape.getBounds().getWidth())/this.shape.getBounds().getWidth();
			settingX = this.px - (rateW*this.shape.getBounds().getX());
			doResize(rateW, 1, settingX, 0);
			break;	
		}
		
		this.px = x;
		this.py = y;
	}

	private void doResize(double rateW, double rateH, double settingX, double settingY) {
		this.affineTransform.setToScale(rateW, rateH);
		this.shape = this.affineTransform.createTransformedShape(this.shape);

		this.affineTransform.setToTranslation(settingX,settingY);
		this.shape = this.affineTransform.createTransformedShape(this.shape);
	}

	public void finishResizing(Graphics2D graphics2d, int x, int y) {
		
	}


}
